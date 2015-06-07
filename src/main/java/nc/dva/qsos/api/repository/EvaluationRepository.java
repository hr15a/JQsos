package nc.dva.qsos.api.repository;

import java.util.List;

import nc.dva.qsos.api.model.Evaluation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

@Repository
@RestResource(exported = false)
public interface EvaluationRepository extends JpaRepository<Evaluation, Long> {

	Evaluation findByAppNameAndRelease(String pAppName, String pReleaseNumber);

	@Query(name = "evaluation.countByDomain")
	Long countByDomain(String pQsosAppFamily);

	@Query(name = "evaluation.findByDomain")
	List<Evaluation> findByQsosAppFamily(String pQsosAppFamily);
}
