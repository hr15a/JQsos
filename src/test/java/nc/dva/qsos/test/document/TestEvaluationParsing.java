package nc.dva.qsos.test.document;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.xml.parsers.ParserConfigurationException;

import nc.dva.qsos.api.model.Evaluation;
import nc.dva.qsos.document.utils.EvaluationUtils;
import nc.dva.qsos.document.utils.TimeStamper;

import org.junit.Assert;
import org.junit.Test;
import org.xml.sax.SAXException;

public class TestEvaluationParsing {

	@Test
	public void testEvaluationParsing() {

		try {

			Path lPath = Paths.get(ClassLoader.getSystemResource(
					"Android SDK-latest_fr.qsos").toURI());
			byte[] fileContent = Files.readAllBytes(lPath);

			Evaluation eval = new Evaluation();
			eval.setFileContent(fileContent);
			eval.setFile(lPath.getFileName().toString());
			eval.setCreationTimestamp(TimeStamper.getTimestamp());

			eval = EvaluationUtils.parseEvaluation(eval);

			System.out.println(eval.toString());

		} catch (URISyntaxException | IOException | SAXException
				| ParserConfigurationException e) {

			System.out.println(e.getMessage());

			Assert.fail();
		}
	}

}
