package remove.tanks.game.level.mode.operation;

import java.util.Map;
import java.util.Set;

/**
 * @author Mateusz Długosz
 */
public final class OperationStorage {
    private final Map<String, Operation> operations;

    OperationStorage(Map<String, Operation> operations) {
        this.operations = operations;
    }

    public Operation getOperation(String title) {
        if (!operations.containsKey(title)) {
            throw new OperationNotFoundException(title);
        }
        return operations.get(title);
    }

    public Set<String> getOperationTitles() {
        return operations.keySet();
    }
}
