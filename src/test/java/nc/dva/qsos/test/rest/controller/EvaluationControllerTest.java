package nc.dva.qsos.test.rest.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import nc.dva.qsos.QsosApplication;
import nc.dva.qsos.api.model.Evaluation;
import nc.dva.qsos.services.EvaluationController;

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

	@Test
	public void createEvaluation_ShouldReturnEvaluation() {
		MultipartFile file = getTestEvaluation();

		Evaluation eval = ctrl.save(file);

		System.out.println(eval.toString());

	}

	private MultipartFile getTestEvaluation() {

		MultipartFile result = null;

		try {
			Path lPath = Paths.get(ClassLoader.getSystemResource(
					"Android SDK-latest_fr.qsos").toURI());

			result = new MockMultipartFile(lPath.getFileName().toString(),
					Files.readAllBytes(lPath));

		} catch (URISyntaxException | IOException e) {

		}
		return result;
	}
}
