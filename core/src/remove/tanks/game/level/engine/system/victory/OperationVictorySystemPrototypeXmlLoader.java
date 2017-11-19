package remove.tanks.game.level.engine.system.victory;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class OperationVictorySystemPrototypeXmlLoader
        extends RegistrableEntitySystemPrototypeXmlLoader<OperationVictorySystemPrototype>
{
    private static final String DELAY_ELEMENT = "delay";

    @Override
    protected OperationVictorySystemPrototype loadEntitySystemPrototype(XmlReader.Element element, int priority) {
        return new OperationVictorySystemPrototype(
                priority,
                Float.valueOf(element.getChildByName(DELAY_ELEMENT).getText().trim())
        );
    }

    @Override
    public SystemType getLoaderType() {
        return SystemType.OperationVictorySystem;
    }
}
