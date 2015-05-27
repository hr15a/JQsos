package nc.dva.qsos.services;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import nc.dva.qsos.api.model.Evaluation;
import nc.dva.qsos.api.repository.EvaluationRepository;
import nc.dva.qsos.document.utils.EvaluationUtils;
import nc.dva.qsos.document.utils.TimeStamper;
import nc.dva.qsos.repository.utils.RepositoryUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.SAXException;

@RestController
@RequestMapping(value = "api/evaluation")
public class EvaluationController {

	@Autowired
	private EvaluationRepository lEvaluationRepository;

	@RequestMapping(method = RequestMethod.GET)
	public List<Evaluation> getAll() {

		return lEvaluationRepository.findAll();

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Evaluation findById(@PathVariable("id") Long pId) {

		return lEvaluationRepository.findOne(pId);

	}

	@RequestMapping(method = RequestMethod.POST)
	public Evaluation save(@RequestParam("file") MultipartFile pFile) {

		Evaluation lEvaluation = null;

		try {

			lEvaluation = new Evaluation();

			lEvaluation.setFileContent(pFile.getBytes());
			lEvaluation = EvaluationUtils.parseEvaluation(lEvaluation);

			/*
			 * check if template already exist.
			 */

			if (lEvaluationRepository.findByAppNameAndRelease(
					lEvaluation.getAppName(), lEvaluation.getRelease()) != null) {

				/*
				 * Update it !
				 */

				lEvaluation = lEvaluationRepository.findByAppNameAndRelease(
						lEvaluation.getAppName(), lEvaluation.getRelease());

				lEvaluation.setRepository(RepositoryUtils.INCOMING_REPOSITORY);
				// don't forget to set uploader...

			} else {

				/*
				 * create it !
				 */

				lEvaluation.setCreationTimestamp(TimeStamper.getTimestamp());
				lEvaluation.setFile(pFile.getName());
				lEvaluation.setRepository(RepositoryUtils.INCOMING_REPOSITORY);
				// don't forget to set other properties...
			}

			lEvaluation = lEvaluationRepository.save(lEvaluation);

		} catch (SAXException | IOException | ParserConfigurationException e) {

		}

		return lEvaluation;

	}

}
