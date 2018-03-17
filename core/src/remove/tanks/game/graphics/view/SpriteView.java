package remove.tanks.game.graphics.view;

import com.badlogic.gdx.graphics.g2d.Sprite;
import remove.tanks.game.graphics.effect.Effect;
import remove.tanks.game.utility.surface.position.Position;

import java.util.Optional;

/**
 * @author Mateusz Długosz
 */
public final class SpriteView implements View {
    private final String id;
    private final Position position;
    private final Sprite sprite;
    private Effect effect;

    public SpriteView(String id, Position position, Sprite sprite) {
        this.id = id;
        this.position = position;
        this.sprite = sprite;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public Optional<Effect> getEffect() {
        return Optional.ofNullable(effect);
    }

    @Override
    public void setEffect(Effect effect) {
        this.effect = effect;
    }

    public Sprite getSprite() {
        return sprite;
    }
}
