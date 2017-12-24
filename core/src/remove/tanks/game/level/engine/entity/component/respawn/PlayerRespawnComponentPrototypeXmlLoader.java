package remove.tanks.game.level.engine.entity.component.respawn;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentPrototypeXmlLoadException;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class PlayerRespawnComponentPrototypeXmlLoader
        implements RegistrableComponentPrototypeXmlLoader<PlayerRespawnComponentPrototype>
{
    @Override
    public PlayerRespawnComponentPrototype loadComponentPrototype(XmlReader.Element element) {
        try {
            return new PlayerRespawnComponentPrototype();
        } catch (Exception e) {
            throw new ComponentPrototypeXmlLoadException(element, e);
        }
    }

    @Override
    public ComponentType getLoaderType() {
        return ComponentType.PlayerRespawnComponent;
    }
}
