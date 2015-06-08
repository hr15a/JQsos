package nc.dva.qsos.test.rest.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import nc.dva.qsos.QsosApplication;
import nc.dva.qsos.api.model.Evaluation;
import nc.dva.qsos.services.EvaluationController;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.multipart.MultipartFile;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = QsosApplication.class)
public class EvaluationControllerTest {

	@Autowired
	EvaluationController ctrl;

	private String[] evaluations = { "Android SDK-latest_fr.qsos",
			"AppCelerator-Titanium 3.3.0_fr.qsos",
			"Objective C-unknowm_fr.qsos",
			"Oracle ADF Mobile-11.1.2.4_fr.qsos", "Sencha Touch-2.3.1a_fr.qsos" };

	@Test
	public void createEvaluation_ShouldReturnEvaluation() {

		for (String evaluation : evaluations) {

			MultipartFile file = getTestEvaluation(evaluation);

			Evaluation eval = ctrl.save(file);

			Assert.assertTrue(eval.getId() != null);

		}

	}

	private MultipartFile getTestEvaluation(String evaluation) {

		MultipartFile result = null;

		try {
			Path lPath = Paths.get(ClassLoader.getSystemResource(evaluation)
					.toURI());

			result = new MockMultipartFile(lPath.getFileName().toString(),
					Files.readAllBytes(lPath));

		} catch (URISyntaxException | IOException e) {

		}
		return result;
	}
}
