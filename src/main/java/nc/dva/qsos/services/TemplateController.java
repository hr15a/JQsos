package nc.dva.qsos.services;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import nc.dva.qsos.api.model.Template;
import nc.dva.qsos.api.repository.TemplateRepository;
import nc.dva.qsos.document.utils.TemplateUtils;
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
@RequestMapping(value = "api/template")
public class TemplateController {

	@Autowired
	private TemplateRepository lTemplateRepository;

	@RequestMapping(method = RequestMethod.GET)
	public List<Template> getAll() {

		return lTemplateRepository.findAll();

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Template findById(@PathVariable("id") Long pId) {

		return lTemplateRepository.findOne(pId);

	}

	@RequestMapping(method = RequestMethod.POST)
	public Template save(@RequestParam("file") MultipartFile pFile) {

		Template lTemplate = null;

		try {

			lTemplate = new Template();

			lTemplate.setFileContent(pFile.getBytes());
			lTemplate = TemplateUtils.parseTemplate(lTemplate);
			lTemplate.setCreationTimestamp(TimeStamper.getTimestamp());
			lTemplate.setFile(pFile.getName());
			lTemplate.setRepository(RepositoryUtils.INCOMING_REPOSITORY);
			// don't forget to set uploader...

			lTemplate = lTemplateRepository.save(lTemplate);

		} catch (SAXException | IOException | ParserConfigurationException e) {

		}

		return lTemplate;

	}

}
