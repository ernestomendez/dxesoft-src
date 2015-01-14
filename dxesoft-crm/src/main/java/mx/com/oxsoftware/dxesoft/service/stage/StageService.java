package mx.com.oxsoftware.dxesoft.service.stage;

import mx.com.oxsoftware.dxesoft.model.entities.stages.Stage;

/**
 * Date: 1/12/15
 * User: ernesto
 *
 * Manages all "stages" operations.
 */
public interface StageService {

    void createStage(Stage stage);

    void deleteStageById(long id);

    Iterable<Stage> findAllActive();

    Stage findById(long id);

    void updateStage(Stage stage) throws Exception;
}
