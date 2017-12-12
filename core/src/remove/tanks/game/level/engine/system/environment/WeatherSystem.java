package remove.tanks.game.level.engine.system.environment;

import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.google.common.eventbus.EventBus;
import remove.tanks.game.level.engine.system.environment.weather.effect.LightningWeatherEffect;
import remove.tanks.game.level.engine.system.environment.weather.effect.WeatherEffect;
import remove.tanks.game.utility.random.RandomNumberGenerator;

import java.util.Random;

/**
 * @author Mateusz Długosz
 */
public final class WeatherSystem extends EntitySystem {
    private final WeatherEffect effect;

    public WeatherSystem(int priority, EventBus eventBus) {
        super(priority);
        this.effect = new LightningWeatherEffect(
                Gdx.audio.newSound(new FileHandle("audio/sounds/thunder-0.ogg")),
                new Color(1f, 1f, 1f, 1f),
                4,
                10,
                0.1f,
                0.125f,
                new RandomNumberGenerator(new Random()),
                eventBus
        );
    }

    @Override
    public void update(float deltaTime) {
        effect.update(deltaTime);
    }
}
