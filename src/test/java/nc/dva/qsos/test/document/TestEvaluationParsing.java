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

	private String[] evaluations = { "Android SDK-latest_fr.qsos",
			"AppCelerator-Titanium 3.3.0_fr.qsos",
			"Objective C-unknowm_fr.qsos",
			"Oracle ADF Mobile-11.1.2.4_fr.qsos", "Sencha Touch-2.3.1a_fr.qsos" };

	@Test
	public void testEvaluationParsing() {

		for (String evaluation : evaluations) {

			try {

				Path lPath = Paths.get(ClassLoader.getSystemResource(
						evaluation).toURI());
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

}
