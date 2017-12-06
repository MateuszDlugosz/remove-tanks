package remove.tanks.game.level.engine.system.state.end;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class LevelEndSystemPrototypeXmlLoader
        extends RegistrableEntitySystemPrototypeXmlLoader<LevelEndSystemPrototype>
{
    private static final String END_TIME_ELEMENT = "endTime";

    @Override
    protected LevelEndSystemPrototype loadEntitySystemPrototype(XmlReader.Element element, int priority) {
        return new LevelEndSystemPrototype(
                priority,
                Float.valueOf(element.getChildByName(END_TIME_ELEMENT).getText().trim())
        );
    }

    @Override
    public SystemType getLoaderType() {
        return SystemType.LevelEndSystem;
    }
}
