package remove.tanks.game.level.engine.system.render.view;

import remove.tanks.game.level.engine.entity.EntityFamily;

/**
 * @author Mateusz Długosz
 */
public enum RenderLayerEntityFamily {
    GroundRenderLayerEntityFamily(EntityFamily.GroundRenderLayerFamily),
    BulletRenderLayerEntityFamily(EntityFamily.BulletRenderLayerFamily),
    VehicleRenderLayerEntityFamily(EntityFamily.VehicleRenderLayerFamily),
    ObstacleRenderLayerEntityFamily(EntityFamily.ObstacleRenderLayerFamily),
    ExplosionRenderLayerEntityFamily(EntityFamily.ExplosionRenderLayerFamily),
    BonusRenderLayerEntityFamily(EntityFamily.BonusRenderLayerFamily),
    CloudRenderLayerEntityFamily(EntityFamily.CloudRenderLayerFamily),
    BombRenderLayerEntityFamily(EntityFamily.BombRenderLayerFamily),
    AirplaneRenderLayerEntityFamily(EntityFamily.AirplaneRenderLayerFamily);

    private final EntityFamily entityFamily;

    RenderLayerEntityFamily(EntityFamily entityFamily) {
        this.entityFamily = entityFamily;
    }

    public EntityFamily getEntityFamily() {
        return entityFamily;
    }
}
