package remove.tanks.game.graphics.particle;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public interface SubParticleEffectPrefabXmlReader<T extends ParticleEffectPrefab> {
    T readParticleEffectPrefab(XmlReader.Element element);
    ParticleEffectType getReaderType();
}
