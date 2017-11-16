package remove.tanks.game.graphic.view;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import remove.tanks.game.utility.position.Position;

/**
 * @author Mateusz Długosz
 */
public final class AnimationView implements View, UpdatableView, ResettableView {
    private final String id;
    private final Position position;
    private final Animation animation;
    private float stateTime;

    public AnimationView(String id, Position position, Animation animation) {
        this.id = id;
        this.position = position;
        this.animation = animation;
        this.stateTime = 0;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    public Sprite getCurrentSprite() {
        return (Sprite) animation.getKeyFrame(stateTime);
    }

    public Animation getAnimation() {
        return animation;
    }

    public float getStateTime() {
        return stateTime;
    }

    @Override
    public void update(float delta) {
        stateTime += delta;
    }

    @Override
    public void reset() {
        stateTime = 0;
    }
}
