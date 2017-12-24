package remove.tanks.game.level.engine.system.state.victory;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.EntitySystemPrototypeXmlLoadException;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class NoEnemiesVictorySystemPrototypeXmlLoader
        implements RegistrableEntitySystemPrototypeXmlLoader<NoEnemiesVictorySystemPrototype>
{
    private static final String DELAY_ELEMENT = "delay";

    @Override
    public NoEnemiesVictorySystemPrototype loadEntitySystemPrototype(XmlReader.Element element, int priority) {
        try {
            return new NoEnemiesVictorySystemPrototype(
                    priority,
                    loadDelay(element)
            );
        } catch (Exception e) {
            throw new EntitySystemPrototypeXmlLoadException(element, e);
        }
    }

    private float loadDelay(XmlReader.Element element) {
        return Float.valueOf(element.getChildByName(DELAY_ELEMENT).getText().trim());
    }

    @Override
    public SystemType getLoaderType() {
        return SystemType.NoEnemiesVictorySystem;
    }
}
