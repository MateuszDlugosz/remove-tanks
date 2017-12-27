package remove.tanks.game.level.engine.system.hud.stages.broker.face;

import com.badlogic.gdx.graphics.g2d.Sprite;
import remove.tanks.game.asset.AssetStorage;
import remove.tanks.game.graphic.sprite.SpriteFactory;
import remove.tanks.game.graphic.sprite.SpritePrototype;
import remove.tanks.game.utility.scale.Scale;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class FaceFactory {
    private final SpriteFactory spriteFactory;

    public FaceFactory(SpriteFactory spriteFactory) {
        this.spriteFactory = spriteFactory;
    }

    public List<Face> createFaces(List<FacePrototype> prototypes, AssetStorage assetStorage, Scale scale) {
        return prototypes.stream()
                .map(p -> createFace(p, assetStorage, scale))
                .collect(Collectors.toList());
    }

    public Face createFace(FacePrototype prototype, AssetStorage assetStorage, Scale scale) {
        try {
            return new Face(
                    prototype.getId(),
                    createSprite(
                            prototype.getSpritePrototype(),
                            assetStorage,
                            scale
                    )
            );
        } catch (Exception e) {
            throw new FaceCreateException(prototype, e);
        }
    }

    private Sprite createSprite(SpritePrototype prototype, AssetStorage assetStorage, Scale scale) {
        return spriteFactory.createSprite(prototype, assetStorage, scale);
    }
}
