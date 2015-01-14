package mx.com.oxsoftware.dxesoft.service.stage;

import com.google.common.base.Preconditions;
import mx.com.oxsoftware.dxesoft.model.entities.stages.Stage;
import mx.com.oxsoftware.dxesoft.model.repositories.StageRepository;
import mx.com.oxsoftware.dxesoft.utils.DxesoftUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Date: 1/12/15
 * User: ernesto
 */
public class StageServiceImpl implements StageService {
    private static final Logger LOGGER = LoggerFactory.getLogger(StageServiceImpl.class);

    @Autowired
    private StageRepository stageRepository;

    @Override
    public void createStage(Stage stage) {
        LOGGER.debug("createStage");
        Preconditions.checkNotNull(stage, "Stage should not be null");
        stageRepository.save(stage);
    }

    @Override
    public void deleteStageById(long id) {
        LOGGER.debug("Delete stage");
        Preconditions.checkArgument(DxesoftUtils.isValidId(id), "The Id is not valid");
        stageRepository.delete(id);
    }

    @Override
    public Iterable<Stage> findAllActive() {
        LOGGER.debug("Find all active");
        return stageRepository.findAll();
    }

    @Override
    public Stage findById(long id) {
        LOGGER.debug("Find by Id");
        Preconditions.checkArgument(DxesoftUtils.isValidId(id), "The Id is not valid");
        return stageRepository.findOne(id);
    }

    @Override
    public void updateStage(Stage stage) throws Exception {
        LOGGER.debug("Update stage");
        Preconditions.checkNotNull(stage, "Can not update a null stage");

        final Stage stageExist = stageRepository.findOne(stage.getId());

        if (null == stageExist) {
            throw new Exception("alsdkfj");
        } else {
            stageRepository.save(stage);
        }
    }
}
