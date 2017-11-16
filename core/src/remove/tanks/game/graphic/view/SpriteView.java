package remove.tanks.game.graphic.view;

import com.badlogic.gdx.graphics.g2d.Sprite;
import remove.tanks.game.utility.position.Position;

/**
 * @author Mateusz Długosz
 */
public final class SpriteView implements View {
    private final String id;
    private final Position position;
    private final Sprite sprite;

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

    public Sprite getSprite() {
        return sprite;
    }
}
