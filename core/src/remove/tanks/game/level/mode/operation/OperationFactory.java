package remove.tanks.game.level.mode.operation;

/**
 * @author Mateusz Długosz
 */
public final class OperationFactory {
    public Operation createOperation(OperationPrefab prefab) {
        try {
            return new Operation(
                    prefab.getTitle(),
                    prefab.getLevelSequence()
            );
        } catch (Exception e) {
            throw new OperationCreateException(prefab, e);
        }
    }
}
