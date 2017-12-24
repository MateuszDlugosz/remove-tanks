package remove.tanks.game.level.engine.system.hud;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.engine.system.EntitySystemCreateException;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemFactory;
import remove.tanks.game.level.engine.system.hud.stages.HudStage;
import remove.tanks.game.level.engine.system.hud.stages.HudStageFactory;
import remove.tanks.game.level.engine.system.hud.stages.HudStagePrototype;
import remove.tanks.game.level.resource.ResourceRegistry;

/**
 * @author Mateusz Długosz
 */
public final class HudRenderSystemFactory
        implements RegistrableEntitySystemFactory<HudRenderSystem, HudRenderSystemPrototype>
{
    private final HudStageFactory hudStageFactory;

    public HudRenderSystemFactory(HudStageFactory hudStageFactory) {
        this.hudStageFactory = hudStageFactory;
    }

    @Override
    public HudRenderSystem createEntitySystem(HudRenderSystemPrototype prototype, ResourceRegistry resourceRegistry) {
        try {
            return new HudRenderSystem(
                    prototype.getPriority(),
                    createHudStage(prototype.getHudStagePrototype(), resourceRegistry),
                    resourceRegistry.getResource(LevelResource.SpriteBatch.toString(), SpriteBatch.class),
                    resourceRegistry
            );
        } catch (Exception e) {
            throw new EntitySystemCreateException(prototype, e);
        }
    }

    private HudStage createHudStage(HudStagePrototype prototype, ResourceRegistry resourceRegistry) {
        return hudStageFactory.createHudStage(prototype, resourceRegistry);
    }

    @Override
    public Class<HudRenderSystemPrototype> getFactoryType() {
        return HudRenderSystemPrototype.class;
    }
}
