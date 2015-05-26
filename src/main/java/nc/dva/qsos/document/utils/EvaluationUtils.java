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

			System.out.println(count(pEvaluation, "element"));
			System.out.println(count(pEvaluation, "score"));
			System.out.println(count(pEvaluation, "comment"));

		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return pEvaluation;
	}

	private static int count(Evaluation pEvaluation, String criteria) {

		int result = 0;

		try {

			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();

			DocumentBuilder builder = factory.newDocumentBuilder();

			Document doc = builder.parse(new ByteArrayInputStream(pEvaluation
					.getFileContent()));

			NodeList lNodeList = doc.getElementsByTagName(criteria);

			result = lNodeList.getLength();

		} catch (IOException | ParserConfigurationException | SAXException e) {

			System.out.println(e.getMessage());
		}

		return result;

	}

}
