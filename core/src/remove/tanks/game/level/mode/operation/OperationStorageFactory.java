package remove.tanks.game.level.mode.operation;

import com.badlogic.gdx.Gdx;
import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.utility.scale.Scale;

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

    public OperationStorage createOperationStorage(OperationPrefabFilenameRepository repository, AssetStorage assetStorage, Scale scale) {
        try {
            return new OperationStorage(createOperationPrefabMap(repository, assetStorage, scale));
        } catch (Exception e) {
            throw new OperationStorageCreateException(e);
        }
    }

    private Map<String, Operation> createOperationPrefabMap(OperationPrefabFilenameRepository repository, AssetStorage assetStorage, Scale scale) {
        return operationPrefabXmlReader.readOperationPrefabs(
                repository.getOperationPrefabFilenames().stream().map(Gdx.files::internal).collect(Collectors.toList())
        ).stream()
                .collect(Collectors.toMap(
                        OperationPrefab::getTitle,
                        o -> operationFactory.createOperation(o, assetStorage, scale)
                ));
    }
}
