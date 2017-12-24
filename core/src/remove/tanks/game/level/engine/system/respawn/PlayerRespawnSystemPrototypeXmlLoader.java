package remove.tanks.game.level.engine.system.respawn;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.EntitySystemPrototypeXmlLoadException;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class PlayerRespawnSystemPrototypeXmlLoader
        implements RegistrableEntitySystemPrototypeXmlLoader<PlayerRespawnSystemPrototype>
{
    private static final String PROTOTYPE_CODE_ELEMENT = "prototypeCode";
    private static final String RESPAWN_TIME_ELEMENT = "respawnTime";

    @Override
    public PlayerRespawnSystemPrototype loadEntitySystemPrototype(XmlReader.Element element, int priority) {
        try {
            return new PlayerRespawnSystemPrototype(
                    priority,
                    loadPrototypeCode(element),
                    loadRespawnTime(element)
            );
        } catch (Exception e) {
            throw new EntitySystemPrototypeXmlLoadException(element, e);
        }
    }

    private String loadPrototypeCode(XmlReader.Element element) {
        return element.getChildByName(PROTOTYPE_CODE_ELEMENT).getText().trim();
    }

    private float loadRespawnTime(XmlReader.Element element) {
        return Float.valueOf(element.getChildByName(RESPAWN_TIME_ELEMENT).getText().trim());
    }

    @Override
    public SystemType getLoaderType() {
        return SystemType.PlayerRespawnSystem;
    }
}
