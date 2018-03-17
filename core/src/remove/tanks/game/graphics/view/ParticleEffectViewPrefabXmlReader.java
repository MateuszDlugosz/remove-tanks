package remove.tanks.game.graphics.view;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.graphics.particle.ParticleEffectPrefab;
import remove.tanks.game.graphics.particle.ParticleEffectPrefabXmlReader;
import remove.tanks.game.utility.surface.position.PositionPrefab;
import remove.tanks.game.utility.surface.position.PositionPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class ParticleEffectViewPrefabXmlReader implements SubViewPrefabXmlReader<ParticleEffectViewPrefab> {
    private static final String ID_ATTRIBUTE = "id";

    private final PositionPrefabXmlReader positionPrefabXmlReader;
    private final ParticleEffectPrefabXmlReader particleEffectPrefabXmlReader;

    public ParticleEffectViewPrefabXmlReader(
            PositionPrefabXmlReader positionPrefabXmlReader,
            ParticleEffectPrefabXmlReader particleEffectPrefabXmlReader
    ) {
        this.positionPrefabXmlReader = positionPrefabXmlReader;
        this.particleEffectPrefabXmlReader = particleEffectPrefabXmlReader;
    }

    @Override
    public ParticleEffectViewPrefab readViewPrefab(XmlReader.Element element) {
        try {
            return new ParticleEffectViewPrefab(
                    readId(element),
                    readViewPositionPrefab(element),
                    readParticleEffectPrefab(element)
            );
        } catch (Exception e) {
            throw new ViewPrefabXmlReadException(element, e);
        }
    }

    private String readId(XmlReader.Element element) {
        return element.getAttribute(ID_ATTRIBUTE);
    }

    private PositionPrefab readViewPositionPrefab(XmlReader.Element element) {
        return element.getChildByName(PositionPrefabXmlReader.POSITION_ELEMENT) == null
                ? PositionPrefab.POSITION_PREFAB_ZERO
                : positionPrefabXmlReader.readPositionPrefab(
                element.getChildByName(PositionPrefabXmlReader.POSITION_ELEMENT)
        );
    }

    private ParticleEffectPrefab readParticleEffectPrefab(XmlReader.Element element) {
        return particleEffectPrefabXmlReader.readParticleEffectPrefab(
                element.getChildByName(ParticleEffectPrefabXmlReader.PARTICLE_EFFECT_ELEMENT)
        );
    }

    @Override
    public ViewType getReaderType() {
        return ViewType.ParticleEffectView;
    }
}
