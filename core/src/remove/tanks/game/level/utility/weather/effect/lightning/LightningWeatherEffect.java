package remove.tanks.game.level.utility.weather.effect.lightning;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.google.common.eventbus.EventBus;
import remove.tanks.game.audio.sound.SoundChannelName;
import remove.tanks.game.level.event.sound.PlaySoundEvent;
import remove.tanks.game.level.utility.weather.effect.WeatherEffect;
import remove.tanks.game.utility.number.random.RandomNumberGenerator;
import remove.tanks.game.utility.time.Timer;

/**
 * @author Mateusz Długosz
 */
public final class LightningWeatherEffect implements WeatherEffect {
    private final String id;
    private final Sound sound;
    private final SoundChannelName soundChannelName;
    private final Color color;

    private final float minFrequency;
    private final float maxFrequency;
    private Timer frequencyTimer;

    private final float minDuration;
    private final float maxDuration;
    private Timer durationTimer;

    private final RandomNumberGenerator randomNumberGenerator;
    private final EventBus eventBus;

    public LightningWeatherEffect(
            String id,
            Sound sound,
            SoundChannelName soundChannelName,
            Color color,
            float minFrequency,
            float maxFrequency,
            float minDuration,
            float maxDuration,
            RandomNumberGenerator randomNumberGenerator,
            EventBus eventBus
    ) {
        this.id = id;
        this.sound = sound;
        this.soundChannelName = soundChannelName;
        this.color = color;
        this.minFrequency = minFrequency;
        this.maxFrequency = maxFrequency;
        this.minDuration = minDuration;
        this.maxDuration = maxDuration;
        this.randomNumberGenerator = randomNumberGenerator;
        this.eventBus = eventBus;
        this.frequencyTimer = createTimer(minFrequency, maxFrequency);
        this.durationTimer = createTimer(minDuration, maxDuration);
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void update(float delta) {
        if (frequencyTimer.isCompleted()) {
            clearScreen();
            if (durationTimer.isCompleted()) {
                durationTimer = createTimer(minDuration, maxDuration);
                frequencyTimer = createTimer(minFrequency, maxFrequency);
                eventBus.post(new PlaySoundEvent(sound, soundChannelName));
            } else {
                durationTimer.update(delta);
            }
        } else {
            frequencyTimer.update(delta);
        }
    }

    private Timer createTimer(float min, float max) {
        return new Timer(randomNumberGenerator.getRandomFloat(min, max));
    }

    private void clearScreen() {
        Gdx.gl.glClearColor( color.r, color.g, color.b, color.a);
        Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );
    }
}
