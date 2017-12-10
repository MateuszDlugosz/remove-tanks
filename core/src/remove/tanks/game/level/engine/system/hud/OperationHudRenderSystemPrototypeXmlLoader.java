package remove.tanks.game.level.engine.system.hud;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class OperationHudRenderSystemPrototypeXmlLoader
        implements RegistrableEntitySystemPrototypeXmlLoader<OperationHudRenderSystemPrototype>
{
    @Override
    public OperationHudRenderSystemPrototype loadEntitySystemPrototype(XmlReader.Element element, int priority) {
        return new OperationHudRenderSystemPrototype(priority);
    }

    @Override
    public SystemType getLoaderType() {
        return SystemType.OperationHudRenderSystem;
    }
}
