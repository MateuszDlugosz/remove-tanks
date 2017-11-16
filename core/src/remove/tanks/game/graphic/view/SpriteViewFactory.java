package remove.tanks.game.graphic.view;

import com.badlogic.gdx.graphics.g2d.Sprite;
import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.graphic.sprite.SpriteFactory;
import remove.tanks.game.utility.position.Position;
import remove.tanks.game.utility.position.PositionFactory;
import remove.tanks.game.utility.scale.Scale;

/**
 * @author Mateusz Długosz
 */
public final class SpriteViewFactory implements RegistrableViewFactory<SpriteView, SpriteViewPrototype> {
    private final PositionFactory positionFactory;
    private final SpriteFactory spriteFactory;

    public SpriteViewFactory(PositionFactory positionFactory, SpriteFactory spriteFactory) {
        this.positionFactory = positionFactory;
        this.spriteFactory = spriteFactory;
    }

    @Override
    public SpriteView createView(SpriteViewPrototype prototype, AssetStorage assetStorage, Scale scale) {
        try {
            return new SpriteView(
                    prototype.getId(),
                    createPosition(prototype, scale),
                    createSprite(prototype, assetStorage, scale)
            );
        } catch (Exception e) {
            throw new ViewCreateException(prototype, e);
        }
    }

    private Position createPosition(SpriteViewPrototype prototype, Scale scale) {
        return positionFactory.createPosition(prototype.getPositionPrototype(), scale);
    }

    private Sprite createSprite(SpriteViewPrototype prototype, AssetStorage assetStorage, Scale scale) {
        return spriteFactory.createSprite(prototype.getSpritePrototype(), assetStorage, scale);
    }

    @Override
    public Class<SpriteViewPrototype> getFactoryType() {
        return SpriteViewPrototype.class;
    }
}
