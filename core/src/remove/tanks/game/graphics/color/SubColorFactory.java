package remove.tanks.game.graphics.color;

import com.badlogic.gdx.graphics.Color;

/**
 * @author Mateusz Długosz
 */
public interface SubColorFactory<T extends ColorPrefab> {
    Color createColor(T prefab);
    Class<T> getFactoryType();
}
