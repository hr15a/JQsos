package nc.dva.qsos.test.template;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import nc.dva.qsos.api.model.Template;
import nc.dva.qsos.api.model.TemplateNode;
import nc.dva.qsos.document.utils.TemplateUtils;

import org.junit.Assert;
import org.junit.Test;
import org.xml.sax.SAXException;

public class TestTemplateParsing {

	@Test
	public void testTemplateParsing() {

		try {

			Path lPath = Paths.get(ClassLoader.getSystemResource(
					"GNC-DTSI-SolutionsMobiles.mm").toURI());
			byte[] fileContent = Files.readAllBytes(lPath);

			Template lTemplate = new Template();
			lTemplate.setFileContent(fileContent);

			lTemplate = TemplateUtils.parseTemplate(lTemplate);

			Assert.assertTrue(lTemplate.getQsosAppFamily() != null
					&& lTemplate.getQsosSpecificFormat() != null
					&& lTemplate.getLanguage() != null);

		} catch (URISyntaxException | IOException | SAXException
				| ParserConfigurationException e) {

			System.out.println(e.getMessage());

			Assert.fail();
		}

	}

	@Test
	public void testNodeExtraction() {

		try {

			Path lPath = Paths.get(ClassLoader.getSystemResource(
					"GNC-DTSI-SolutionsMobiles.mm").toURI());
			byte[] fileContent = Files.readAllBytes(lPath);

			Template lTemplate = new Template();
			lTemplate.setFileContent(fileContent);

			List<TemplateNode> result = TemplateUtils.getAllNodes(lTemplate);

			Assert.assertFalse(result.isEmpty());

		} catch (URISyntaxException | IOException e) {

			System.out.println(e.getMessage());

			Assert.fail();
		}

	}

}
