package remove.tanks.game.graphics.view;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import remove.tanks.game.graphics.effect.Effect;
import remove.tanks.game.utility.surface.position.Position;

import java.util.Optional;

/**
 * @author Mateusz Długosz
 */
public final class AnimationView implements View, UpdatableView, ResettableView {
    private final String id;
    private final Position position;
    private final Animation animation;
    private float stateTime;
    private Effect effect;

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

    @Override
    public Optional<Effect> getEffect() {
        return Optional.ofNullable(effect);
    }

    @Override
    public void setEffect(Effect effect) {
        this.effect = effect;
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
