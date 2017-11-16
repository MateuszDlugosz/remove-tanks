package remove.tanks.game.level.engine.system.map;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class TiledMapRenderSystemPrototypeXmlLoader
        extends RegistrableEntitySystemPrototypeXmlLoader<TiledMapRenderSystemPrototype>
{
    @Override
    protected TiledMapRenderSystemPrototype loadEntitySystemPrototype(XmlReader.Element element, int priority) {
        return new TiledMapRenderSystemPrototype(priority);
    }

    @Override
    public SystemType getLoaderType() {
        return SystemType.TiledMapRenderSystem;
    }
}
