package nc.dva.qsos.document.utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import nc.dva.qsos.api.model.Evaluation;
import nc.dva.qsos.api.schema.qsos.generated.Document.Header;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class EvaluationUtils {

	public static Evaluation parseEvaluation(Evaluation pEvaluation)
			throws ParserConfigurationException, IOException, SAXException {

		try {

			JAXBContext jaxbContext = JAXBContext
					.newInstance(nc.dva.qsos.api.schema.qsos.generated.Document.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

			nc.dva.qsos.api.schema.qsos.generated.Document document = (nc.dva.qsos.api.schema.qsos.generated.Document) jaxbUnmarshaller
					.unmarshal(new ByteArrayInputStream(pEvaluation
							.getFileContent()));

			Header header = document.getHeader();

			pEvaluation.setAppName(header.getAppname());
			pEvaluation.setQsosAppFamily(header.getQsosappfamily());
			pEvaluation.setQsosAppName(header.getQsosappname());
			pEvaluation.setQsosSpecificFormat(header.getQsosspecificformat());
			pEvaluation.setRelease(header.getRelease());
			pEvaluation.setLanguage(header.getLanguage());
			pEvaluation.setLicenseDesc(header.getLicensedesc());
			pEvaluation.setSections(new Long(document.getSection().size()));

			countCriteria(pEvaluation);

		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return pEvaluation;
	}

	private static void countCriteria(Evaluation pEvaluation) {

		/*
		 * relative to "element" nodes
		 */
		int criteria = 0;

		/*
		 * relative to "score" nodes
		 */
		int criteriaScorable = 0;
		int criteriaScored = 0;
		int criteriaNotScored = 0;

		/*
		 * relative to "comment" nodes
		 */
		int comments = 0;
		int criteriaCommented = 0;
		int criteriaNotCommented = 0;

		try {

			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();

			DocumentBuilder builder = factory.newDocumentBuilder();

			Document doc = builder.parse(new ByteArrayInputStream(pEvaluation
					.getFileContent()));

			doc.getDocumentElement().normalize();

			criteria = doc.getElementsByTagName("element").getLength();
			criteriaScorable = doc.getElementsByTagName("score").getLength();
			comments = doc.getElementsByTagName("comment").getLength();

			NodeList lNodeList = doc.getElementsByTagName("score");

			int lNbNodes = lNodeList.getLength();

			for (int i = 0; i < lNbNodes; i++) {

				Node lNode = lNodeList.item(i);

				org.w3c.dom.Element elem = (org.w3c.dom.Element) lNode;

				if ("score".equals(elem.getNodeName())) {

					if (lNode.getFirstChild() != null) {

						criteriaScored++;

					} else {

						criteriaNotScored++;

					}

				}

			}

			lNodeList = doc.getElementsByTagName("comment");

			lNbNodes = lNodeList.getLength();

			for (int i = 0; i < lNbNodes; i++) {

				Node lNode = lNodeList.item(i);

				org.w3c.dom.Element elem = (org.w3c.dom.Element) lNode;

				if ("comment".equals(elem.getNodeName())) {

					if (lNode.getFirstChild() != null) {

						criteriaCommented++;

					} else {

						criteriaNotCommented++;

					}

				}

			}

			pEvaluation.setCriteria(new Long(criteria));
			pEvaluation.setCriteriaScorable(new Long(criteriaScorable));
			pEvaluation.setComments(new Long(comments));
			pEvaluation.setCriteriaCommented(new Long(criteriaCommented));
			pEvaluation.setCriteriaNotCommented(new Long(criteriaNotCommented));
			pEvaluation.setCriteriaScored(new Long(criteriaScored));
			pEvaluation.setCriteriaNotScored(new Long(criteriaNotScored));

		} catch (IOException | ParserConfigurationException | SAXException e) {

			System.out.println(e.getMessage());
		}

	}

}
