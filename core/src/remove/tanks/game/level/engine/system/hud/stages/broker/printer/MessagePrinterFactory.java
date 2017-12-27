package remove.tanks.game.level.engine.system.hud.stages.broker.printer;

import com.badlogic.gdx.audio.Sound;
import com.google.common.eventbus.EventBus;
import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.audio.sound.SoundFactory;
import remove.tanks.game.audio.sound.SoundPrototype;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.locale.Locale;
import remove.tanks.game.utility.time.Timer;

/**
 * @author Mateusz Długosz
 */
public final class MessagePrinterFactory {
    private final SoundFactory soundFactory;

    public MessagePrinterFactory(SoundFactory soundFactory) {
        this.soundFactory = soundFactory;
    }

    public MessagePrinter createMessagePrinter(MessagePrinterPrototype prototype, ResourceRegistry resourceRegistry) {
        try {
            return new MessagePrinter(
                    createSound(
                            prototype.getSoundPrototype(),
                            resourceRegistry.getResource(LevelResource.AssetStorage.toString(), AssetStorage.class)
                    ),
                    resourceRegistry.getResource(LevelResource.EventBus.toString(), EventBus.class),
                    resourceRegistry.getResource(LevelResource.Locale.toString(), Locale.class),
                    createTimer(prototype.getTime())
            );
        } catch (Exception e) {
            throw new MessagePrinterCreateException(prototype, e);
        }
    }

    private Sound createSound(SoundPrototype prototype, AssetStorage assetStorage) {
        return soundFactory.createSound(prototype, assetStorage);
    }

    private Timer createTimer(float time) {
        return new Timer(time);
    }
}
