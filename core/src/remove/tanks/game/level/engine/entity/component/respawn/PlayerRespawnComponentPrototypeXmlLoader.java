package remove.tanks.game.level.engine.entity.component.respawn;

import com.badlogic.gdx.utils.XmlReader;
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
        return new PlayerRespawnComponentPrototype();
    }

    @Override
    public ComponentType getLoaderType() {
        return ComponentType.PlayerRespawnComponent;
    }
}
