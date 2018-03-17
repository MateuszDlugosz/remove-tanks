package remove.tanks.game.physics.light;

import box2dLight.Light;
import com.badlogic.gdx.physics.box2d.Body;
import remove.tanks.game.physics.light.world.WorldLight;
import remove.tanks.game.utility.scale.Scale;

/**
 * @author Mateusz Długosz
 */
public interface SubLightFactory<T extends Light, U extends LightPrefab> {
    T createLight(U prefab, WorldLight worldLight, Scale scale);
    T createLight(U prefab, WorldLight worldLight, Body body, Scale scale);
    Class<U> getFactoryType();
}
