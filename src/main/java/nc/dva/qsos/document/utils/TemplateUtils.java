package nc.dva.qsos.document.utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import nc.dva.qsos.api.model.Template;
import nc.dva.qsos.api.model.TemplateNode;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class TemplateUtils {

	public static Template parseTemplate(Template pTemplate)
			throws ParserConfigurationException, IOException, SAXException {

		String mmLanguageKey = "language_entry";
		String mmVersionKey = "version_entry";
		String mmAppFamilyKey = "type";

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		DocumentBuilder builder = factory.newDocumentBuilder();

		Document doc = builder.parse(new ByteArrayInputStream(pTemplate
				.getFileContent()));

		Element element = doc.getDocumentElement();

		NodeList nodeList = element.getChildNodes();

		String qsosFormatVersion = null;
		String language = null;
		String appFamily = null;
		pTemplate.setQsosSpecificFormat(getAttributeValue(nodeList,
				qsosFormatVersion, mmVersionKey));
		pTemplate.setLanguage(getAttributeValue(nodeList, language,
				mmLanguageKey));
		pTemplate.setQsosAppFamily(getAttributeValue(nodeList, appFamily,
				mmAppFamilyKey));

		return pTemplate;

	}

	public static List<TemplateNode> getAllNodes(Template pTemplate) {

		List<TemplateNode> result = new ArrayList<TemplateNode>();

		try {

			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();

			DocumentBuilder builder = factory.newDocumentBuilder();

			Document doc = builder.parse(new ByteArrayInputStream(pTemplate
					.getFileContent()));

			Element element = doc.getDocumentElement();

			NodeList lNodeList = element.getChildNodes();

			result = nodeExtraction(lNodeList, -1, null, result);

		} catch (IOException | ParserConfigurationException | SAXException e) {

			System.out.println(e.getMessage());
		}

		return result;
	}

	private static String getAttributeValue(NodeList pNodeList, String result,
			String attributeName) {

		Boolean doSearch = Boolean.TRUE;

		for (int i = 0; doSearch && i < pNodeList.getLength(); i++) {

			Node node = pNodeList.item(i);

			if ("node".equals(node.getNodeName())) {

				NamedNodeMap mapAttributes = node.getAttributes();

				if (mapAttributes != null) {

					Node item = mapAttributes.getNamedItem("ID");

					if (item != null) {
						String searchedKey = item.getNodeValue();

						if (attributeName.equals(searchedKey)) {

							result = mapAttributes.getNamedItem("TEXT")
									.getNodeValue();

							doSearch = Boolean.FALSE;

						}
					}

				}

				if (doSearch) {
					NodeList lNodeList = node.getChildNodes();

					if (lNodeList != null) {

						result = getAttributeValue(lNodeList, result,
								attributeName);

					}
				}
			}

		}

		return result;
	}

	private static List<TemplateNode> nodeExtraction(NodeList pNodeList,
			int level, TemplateNode parent, List<TemplateNode> list) {

		level++;

		for (int z = 0; z < pNodeList.getLength(); z++) {

			Node lNode = pNodeList.item(z);

			NamedNodeMap nodeAttributes = lNode.getAttributes();

			if (nodeAttributes != null) {

				if ((nodeAttributes.getNamedItem("ID") != null && !"metadata"
						.equals(nodeAttributes.getNamedItem("ID")
								.getNodeValue()))
						|| nodeAttributes.getNamedItem("BUILTIN") != null) {

					TemplateNode lTemplateNode = null;

					if ("node".equals(lNode.getNodeName())) {

						lTemplateNode = new TemplateNode();

						lTemplateNode.setCriteria(nodeAttributes.getNamedItem(
								"TEXT").getNodeValue());
						lTemplateNode.setId(nodeAttributes.getNamedItem("ID")
								.getNodeValue());
						lTemplateNode.setLevel(level);
						if (parent != null) {
							lTemplateNode.setParent_id(parent.getId());
						}

						list.add(lTemplateNode);

					}

					if ("icon".equals(lNode.getNodeName())) {

						/*
						 * buff.append("note associée : " +
						 * StringUtils.substringAfterLast(
						 * nodeAttributes.getNamedItem("BUILTIN")
						 * .getNodeValue(), "full-"));
						 */
					}

					if (lNode.getChildNodes().getLength() > 0) {

						nodeExtraction(lNode.getChildNodes(), level,
								lTemplateNode, list);

					}
				}
			}
		}

		return list;

	}

}
