package remove.tanks.game.level.engine.entity.component.faction;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class PlayerComponentPrototypeXmlLoader
        implements RegistrableComponentPrototypeXmlLoader<PlayerComponentPrototype>
{
    private static final String LOADER_TYPE = "PlayerComponent";

    @Override
    public PlayerComponentPrototype loadComponentPrototype(XmlReader.Element element) {
        return new PlayerComponentPrototype();
    }

    @Override
    public ComponentType getLoaderType() {
        return ComponentType.PlayerComponent;
    }
}
