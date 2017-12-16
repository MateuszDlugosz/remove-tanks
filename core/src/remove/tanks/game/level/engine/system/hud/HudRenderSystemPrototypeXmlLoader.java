package remove.tanks.game.level.engine.system.hud;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class HudRenderSystemPrototypeXmlLoader
        implements RegistrableEntitySystemPrototypeXmlLoader<HudRenderSystemPrototype>
{
    @Override
    public HudRenderSystemPrototype loadEntitySystemPrototype(XmlReader.Element element, int priority) {
        return new HudRenderSystemPrototype(priority);
    }

    @Override
    public SystemType getLoaderType() {
        return SystemType.HudRenderSystem;
    }
}
