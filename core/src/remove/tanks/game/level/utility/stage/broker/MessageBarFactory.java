package remove.tanks.game.level.utility.stage.broker;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;
import remove.tanks.game.level.utility.stage.broker.face.Face;
import remove.tanks.game.level.utility.stage.broker.face.FaceFactory;
import remove.tanks.game.level.utility.stage.broker.face.FacePrefab;
import remove.tanks.game.level.utility.stage.broker.printer.MessagePrinter;
import remove.tanks.game.level.utility.stage.broker.printer.MessagePrinterFactory;
import remove.tanks.game.level.utility.stage.broker.printer.MessagePrinterPrefab;
import remove.tanks.game.utility.scale.Scale;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class MessageBarFactory {
    private final MessagePrinterFactory messagePrinterFactory;
    private final FaceFactory faceFactory;

    public MessageBarFactory(
            MessagePrinterFactory messagePrinterFactory,
            FaceFactory faceFactory
    ) {
        this.messagePrinterFactory = messagePrinterFactory;
        this.faceFactory = faceFactory;
    }

    public MessageBar createMessageBar(MessageBarPrefab prefab, ResourceRegistry resourceRegistry) {
        try {
            return new MessageBar(
                    createMessageLabel(prefab, resourceRegistry.getResource(ResourceType.UISkinResource, Skin.class)),
                    createImage(),
                    prefab.getDefaultMessage(),
                    createMessagePrinter(
                            prefab.getMessagePrinterPrefab(),
                            resourceRegistry
                    ),
                    createFaces(
                            prefab.getFacePrefabs(),
                            resourceRegistry.getResource(ResourceType.AssetStorageResource, AssetStorage.class),
                            resourceRegistry.getResource(ResourceType.UIScaleResource, Scale.class)
                    )
            );
        } catch (Exception e) {
            throw new MessageBarCreateException(prefab, e);
        }
    }

    private Label createMessageLabel(MessageBarPrefab prefab, Skin skin) {
        return new Label(prefab.getDefaultMessage(), skin);
    }

    private MessagePrinter createMessagePrinter(MessagePrinterPrefab prefab, ResourceRegistry resourceRegistry) {
        return messagePrinterFactory.createMessagePrinter(prefab, resourceRegistry);
    }

    private Image createImage() {
        return new Image();
    }

    private Map<String, Face> createFaces(List<FacePrefab> prefabs, AssetStorage assetStorage, Scale scale) {
        return faceFactory.createFaces(prefabs, assetStorage, scale).stream()
                .collect(Collectors.toMap(
                        Face::getId,
                        s -> s
                ));
    }
}
