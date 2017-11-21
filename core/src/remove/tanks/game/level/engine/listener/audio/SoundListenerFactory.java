package remove.tanks.game.level.engine.listener.audio;

import com.badlogic.ashley.core.Engine;
import com.google.common.eventbus.EventBus;
import remove.tanks.game.graphic.camera.Game2DCamera;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.engine.listener.RegistrableEntityListenerFactory;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class SoundListenerFactory
        implements RegistrableEntityListenerFactory<SoundListener, SoundListenerPrototype>
{
    @Override
    public SoundListener createEntityListener(SoundListenerPrototype prototype, ResourceRegistry registry, Engine engine) {
        return new SoundListener(
                registry.getResource(LevelResource.EventBus.toString(), EventBus.class),
                registry.getResource(LevelResource.GameCamera.toString(), Game2DCamera.class),
                engine,
                prototype.getPriority()
        );
    }

    @Override
    public Class<SoundListenerPrototype> getFactoryType() {
        return SoundListenerPrototype.class;
    }
}
