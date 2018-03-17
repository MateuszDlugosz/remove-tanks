package remove.tanks.game.level.engine.system.hud;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import remove.tanks.game.level.engine.system.EntitySystemCreateException;
import remove.tanks.game.level.engine.system.SubEntitySystemFactory;
import remove.tanks.game.level.resource.ResourceRegistry;
import remove.tanks.game.level.resource.ResourceType;
import remove.tanks.game.level.utility.stage.HudStage;
import remove.tanks.game.level.utility.stage.HudStageFactory;
import remove.tanks.game.level.utility.stage.HudStagePrefab;

/**
 * @author Mateusz Długosz
 */
public final class HudSystemFactory implements SubEntitySystemFactory<HudSystem, HudSystemPrefab> {
    private final HudStageFactory hudStageFactory;

    public HudSystemFactory(HudStageFactory hudStageFactory) {
        this.hudStageFactory = hudStageFactory;
    }

    @Override
    public HudSystem createEntitySystem(HudSystemPrefab prefab, ResourceRegistry resourceRegistry) {
        try {
            return new HudSystem(
                    prefab.getPriority(),
                    createHudStage(prefab.getHudStagePrefab(), resourceRegistry),
                    resourceRegistry.getResource(ResourceType.SpriteBatchResource, SpriteBatch.class),
                    resourceRegistry
            );
        } catch (Exception e) {
            throw new EntitySystemCreateException(prefab, e);
        }
    }

    private HudStage createHudStage(HudStagePrefab prefab, ResourceRegistry resourceRegistry) {
        return hudStageFactory.createHudStage(prefab, resourceRegistry);
    }

    @Override
    public Class<HudSystemPrefab> getFactoryType() {
        return HudSystemPrefab.class;
    }
}
