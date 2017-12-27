package remove.tanks.game.level.engine.system.hud.stages.broker;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.engine.system.hud.stages.broker.face.Face;
import remove.tanks.game.level.engine.system.hud.stages.broker.face.FaceFactory;
import remove.tanks.game.level.engine.system.hud.stages.broker.face.FacePrototype;
import remove.tanks.game.level.engine.system.hud.stages.broker.printer.MessagePrinter;
import remove.tanks.game.level.engine.system.hud.stages.broker.printer.MessagePrinterFactory;
import remove.tanks.game.level.engine.system.hud.stages.broker.printer.MessagePrinterPrototype;
import remove.tanks.game.level.resource.ResourceRegistry;
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

    public MessageBar createMessageBar(MessageBarPrototype prototype, ResourceRegistry resourceRegistry) {
        try {
            return new MessageBar(
                    createMessageLabel(prototype, resourceRegistry.getResource(LevelResource.UiSkin.toString(), Skin.class)),
                    createImage(),
                    prototype.getDefaultMessage(),
                    createMessagePrinter(
                            prototype.getMessagePrinterPrototype(),
                            resourceRegistry
                    ),
                    createFaces(
                            prototype.getFacePrototypes(),
                            resourceRegistry.getResource(LevelResource.AssetStorage.toString(), AssetStorage.class),
                            resourceRegistry.getResource(LevelResource.UiScale.toString(), Scale.class)
                    )
            );
        } catch (Exception e) {
            throw new MessageBarCreateException(prototype, e);
        }
    }

    private Label createMessageLabel(MessageBarPrototype prototype, Skin skin) {
        return new Label(prototype.getDefaultMessage(), skin);
    }

    private MessagePrinter createMessagePrinter(MessagePrinterPrototype prototype, ResourceRegistry resourceRegistry) {
        return messagePrinterFactory.createMessagePrinter(prototype, resourceRegistry);
    }

    private Image createImage() {
        return new Image();
    }

    private Map<String, Face> createFaces(List<FacePrototype> prototypes, AssetStorage assetStorage, Scale scale) {
        return faceFactory.createFaces(prototypes, assetStorage, scale).stream()
                .collect(Collectors.toMap(
                        Face::getId,
                        s -> s
                ));
    }
}
