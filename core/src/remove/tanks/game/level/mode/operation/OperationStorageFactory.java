package remove.tanks.game.level.mode.operation;

import com.badlogic.gdx.Gdx;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class OperationStorageFactory {
    private final OperationPrefabXmlReader operationPrefabXmlReader;
    private final OperationFactory operationFactory;

    public OperationStorageFactory(
            OperationPrefabXmlReader operationPrefabXmlReader,
            OperationFactory operationFactory
    ) {
        this.operationPrefabXmlReader = operationPrefabXmlReader;
        this.operationFactory = operationFactory;
    }

    public OperationStorage createOperationStorage(OperationPrefabFilenameRepository repository) {
        try {
            return new OperationStorage(createOperationPrefabMap(repository));
        } catch (Exception e) {
            throw new OperationStorageCreateException(e);
        }
    }

    private Map<String, Operation> createOperationPrefabMap(OperationPrefabFilenameRepository repository) {
        return operationPrefabXmlReader.readOperationPrefabs(
                repository.getOperationPrefabFilenames().stream().map(Gdx.files::internal).collect(Collectors.toList())
        ).stream()
                .collect(Collectors.toMap(
                        OperationPrefab::getTitle,
                        operationFactory::createOperation
                ));
    }
}
