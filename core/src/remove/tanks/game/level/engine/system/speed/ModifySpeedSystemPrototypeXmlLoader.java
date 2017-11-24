package remove.tanks.game.level.engine.system.speed;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class ModifySpeedSystemPrototypeXmlLoader
        extends RegistrableEntitySystemPrototypeXmlLoader<ModifySpeedSystemPrototype>
{
    @Override
    protected ModifySpeedSystemPrototype loadEntitySystemPrototype(XmlReader.Element element, int priority) {
        return new ModifySpeedSystemPrototype(priority);
    }

    @Override
    public SystemType getLoaderType() {
        return SystemType.ModifySpeedSystem;
    }
}
