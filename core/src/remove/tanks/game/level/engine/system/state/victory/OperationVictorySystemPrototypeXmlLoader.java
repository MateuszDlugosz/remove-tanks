package remove.tanks.game.level.engine.system.state.victory;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class OperationVictorySystemPrototypeXmlLoader
        implements RegistrableEntitySystemPrototypeXmlLoader<OperationVictorySystemPrototype>
{
    private static final String DELAY_ELEMENT = "delay";

    @Override
    public OperationVictorySystemPrototype loadEntitySystemPrototype(XmlReader.Element element, int priority) {
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
