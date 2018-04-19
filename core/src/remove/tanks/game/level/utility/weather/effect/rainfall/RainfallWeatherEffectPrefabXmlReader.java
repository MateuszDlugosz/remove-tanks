package remove.tanks.game.level.utility.weather.effect.rainfall;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.graphics.particle.ParticleEffectPrefab;
import remove.tanks.game.graphics.particle.ParticleEffectPrefabXmlReader;
import remove.tanks.game.level.utility.weather.effect.SubWeatherEffectPrefabXmlReader;
import remove.tanks.game.level.utility.weather.effect.WeatherEffectPrefabXmlReadException;
import remove.tanks.game.level.utility.weather.effect.WeatherEffectType;

/**
 * @author Mateusz Długosz
 */
public final class RainfallWeatherEffectPrefabXmlReader implements SubWeatherEffectPrefabXmlReader<RainfallWeatherEffectPrefab> {
    private static final String ID_ELEMENT = "id";

    private final ParticleEffectPrefabXmlReader particleEffectPrefabXmlReader;

    public RainfallWeatherEffectPrefabXmlReader(ParticleEffectPrefabXmlReader particleEffectPrefabXmlReader) {
        this.particleEffectPrefabXmlReader = particleEffectPrefabXmlReader;
    }

    @Override
    public RainfallWeatherEffectPrefab readWeatherEffect(XmlReader.Element element) {
        try {
            return new RainfallWeatherEffectPrefab(
                    readId(element),
                    readParticleEffectPrefab(element)
            );
        } catch (Exception e) {
            throw new WeatherEffectPrefabXmlReadException(element, e);
        }
    }

    private String readId(XmlReader.Element element) {
        return element.getChildByName(ID_ELEMENT).getText().trim();
    }

    private ParticleEffectPrefab readParticleEffectPrefab(XmlReader.Element element) {
        return particleEffectPrefabXmlReader.readParticleEffectPrefab(
                element.getChildByName(ParticleEffectPrefabXmlReader.PARTICLE_EFFECT_ELEMENT)
        );
    }

    @Override
    public WeatherEffectType getReaderType() {
        return WeatherEffectType.RainfallWeatherEffect;
    }
}
