package remove.tanks.game.level.utility.weather.effect.rainfall;

import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import remove.tanks.game.graphics.camera.Game2DCamera;
import remove.tanks.game.level.utility.weather.effect.WeatherEffect;

/**
 * @author Mateusz Długosz
 */
public final class RainfallWeatherEffect implements WeatherEffect {
    private final String id;
    private final ParticleEffect particleEffect;
    private final Game2DCamera game2DCamera;
    private final SpriteBatch spriteBatch;

    public RainfallWeatherEffect(
            String id,
            ParticleEffect particleEffect,
            Game2DCamera game2DCamera,
            SpriteBatch spriteBatch
    ) {
        this.id = id;
        this.particleEffect = particleEffect;
        this.game2DCamera = game2DCamera;
        this.spriteBatch = spriteBatch;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void update(float delta) {
        particleEffect.setPosition(
                game2DCamera.getCameraBoundaries().getMinX() + game2DCamera.getCameraBoundaries().getWidth() * 0.5f,
                game2DCamera.getCameraBoundaries().getMinY() + game2DCamera.getCameraBoundaries().getHeight() * 0.5f
        );
        spriteBatch.begin();
        particleEffect.draw(spriteBatch);
        spriteBatch.end();
    }
}
