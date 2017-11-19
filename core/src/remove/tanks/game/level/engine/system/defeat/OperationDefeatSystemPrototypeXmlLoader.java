package remove.tanks.game.level.engine.system.defeat;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class OperationDefeatSystemPrototypeXmlLoader
        extends RegistrableEntitySystemPrototypeXmlLoader<OperationDefeatSystemPrototype>
{
    private static final String DELAY_ELEMENT = "delay";

    @Override
    protected OperationDefeatSystemPrototype loadEntitySystemPrototype(XmlReader.Element element, int priority) {
        return new OperationDefeatSystemPrototype(
                priority,
                Float.valueOf(element.getChildByName(DELAY_ELEMENT).getText().trim())
        );
    }

    @Override
    public SystemType getLoaderType() {
        return SystemType.OperationDefeatSystem;
    }
}
