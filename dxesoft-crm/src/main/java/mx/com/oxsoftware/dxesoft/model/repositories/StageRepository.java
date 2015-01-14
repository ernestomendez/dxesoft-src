package mx.com.oxsoftware.dxesoft.model.repositories;

import mx.com.oxsoftware.dxesoft.model.entities.stages.Stage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Date: 1/12/15
 * User: ernesto
 */
@Repository
public interface StageRepository extends CrudRepository<Stage, Long> {
}
