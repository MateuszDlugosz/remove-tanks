package remove.tanks.game.level.engine.system.state.defeat;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class NoLifesDefeatSystemPrototypeXmlLoader
        implements RegistrableEntitySystemPrototypeXmlLoader<NoLifesDefeatSystemPrototype>
{
    private static final String DELAY_ELEMENT = "delay";

    @Override
    public NoLifesDefeatSystemPrototype loadEntitySystemPrototype(XmlReader.Element element, int priority) {
        return new NoLifesDefeatSystemPrototype(
                priority,
                Float.valueOf(element.getChildByName(DELAY_ELEMENT).getText().trim())
        );
    }

    @Override
    public SystemType getLoaderType() {
        return SystemType.NoLifesDefeatSystem;
    }
}
