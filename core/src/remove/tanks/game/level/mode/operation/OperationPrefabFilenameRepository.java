package remove.tanks.game.level.mode.operation;

import java.util.List;
import java.util.Map;

/**
 * @author Mateusz Długosz
 */
public final class OperationPrefabFilenameRepository {
    private final List<String> operationPrefabFilenames;

    public OperationPrefabFilenameRepository(List<String> operationPrefabFilenames) {
        this.operationPrefabFilenames = operationPrefabFilenames;
    }

    public List<String> getOperationPrefabFilenames() {
        return operationPrefabFilenames;
    }
}
