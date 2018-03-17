package remove.tanks.game.graphics.view;

import com.badlogic.gdx.graphics.g2d.Sprite;
import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.graphics.sprite.SpriteFactory;
import remove.tanks.game.utility.scale.Scale;
import remove.tanks.game.utility.surface.position.Position;
import remove.tanks.game.utility.surface.position.PositionFactory;

/**
 * @author Mateusz Długosz
 */
public final class SpriteViewFactory implements SubViewFactory<SpriteView, SpriteViewPrefab> {
    private final PositionFactory positionFactory;
    private final SpriteFactory spriteFactory;

    public SpriteViewFactory(PositionFactory positionFactory, SpriteFactory spriteFactory) {
        this.positionFactory = positionFactory;
        this.spriteFactory = spriteFactory;
    }

    @Override
    public SpriteView createView(SpriteViewPrefab prefab, AssetStorage assetStorage, Scale scale) {
        try {
            return new SpriteView(
                    prefab.getId(),
                    createPosition(prefab, scale),
                    createSprite(prefab, assetStorage, scale)
            );
        } catch (Exception e) {
            throw new ViewCreateException(prefab, e);
        }
    }

    private Position createPosition(SpriteViewPrefab prefab, Scale scale) {
        return positionFactory.createPosition(prefab.getPositionPrefab(), scale);
    }

    private Sprite createSprite(SpriteViewPrefab prefab, AssetStorage assetStorage, Scale scale) {
        return spriteFactory.createSprite(prefab.getSpritePrefab(), assetStorage, scale);
    }

    @Override
    public Class<SpriteViewPrefab> getFactoryType() {
        return SpriteViewPrefab.class;
    }
}
