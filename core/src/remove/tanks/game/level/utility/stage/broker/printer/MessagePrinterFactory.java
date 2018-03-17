package remove.tanks.game.level.utility.stage.broker.printer;

import com.badlogic.gdx.audio.Sound;
import com.google.common.eventbus.EventBus;
import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.audio.sound.SoundFactory;
import remove.tanks.game.audio.sound.SoundPrefab;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;
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

    public MessagePrinter createMessagePrinter(MessagePrinterPrefab prefab, ResourceRegistry registry) {
        try {
            return new MessagePrinter(
                    createSound(
                            prefab.getSoundPrefab(),
                            registry.getResource(ResourceType.AssetStorageResource, AssetStorage.class)
                    ),
                    prefab.getSoundChannelName(),
                    registry.getResource(ResourceType.EventBusResource, EventBus.class),
                    registry.getResource(ResourceType.LocaleResource, Locale.class),
                    createTimer(prefab.getTime())
            );
        } catch (Exception e) {
            throw new MessagePrinterCreateException(prefab, e);
        }
    }

    private Sound createSound(SoundPrefab prefab, AssetStorage assetStorage) {
        return soundFactory.createSound(prefab, assetStorage);
    }

    private Timer createTimer(float time) {
        return new Timer(time);
    }
}
