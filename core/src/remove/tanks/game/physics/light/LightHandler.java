package remove.tanks.game.physics.light;

import box2dLight.Light;

/**
 * @author Mateusz Długosz
 */
public final class LightHandler {
    private final String id;
    private final Light light;

    public LightHandler(String id, Light light) {
        this.id = id;
        this.light = light;
    }

    public String getId() {
        return id;
    }

    public Light getLight() {
        return light;
    }
}
