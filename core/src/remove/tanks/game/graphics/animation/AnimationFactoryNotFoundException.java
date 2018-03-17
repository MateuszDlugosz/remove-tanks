package remove.tanks.game.graphics.animation;

/**
 * @author Mateusz Długosz
 */
public final class AnimationFactoryNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Animation factory of %s prefab not found.";

    public AnimationFactoryNotFoundException(Class<? extends AnimationPrefab> prefab) {
        super(String.format(MESSAGE_TEMPLATE, prefab));
    }
}
