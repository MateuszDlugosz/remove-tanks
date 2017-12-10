package remove.tanks.game.level.engine.system.map;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class TiledMapRenderSystemPrototypeXmlLoader
        implements RegistrableEntitySystemPrototypeXmlLoader<TiledMapRenderSystemPrototype>
{
    @Override
    public TiledMapRenderSystemPrototype loadEntitySystemPrototype(XmlReader.Element element, int priority) {
        return new TiledMapRenderSystemPrototype(priority);
    }

    @Override
    public SystemType getLoaderType() {
        return SystemType.TiledMapRenderSystem;
    }
}
