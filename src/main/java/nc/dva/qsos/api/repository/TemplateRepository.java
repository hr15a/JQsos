package nc.dva.qsos.api.repository;

import nc.dva.qsos.api.model.Template;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

@Repository
@RestResource(exported = false)
public interface TemplateRepository extends JpaRepository<Template, Long> {

}
