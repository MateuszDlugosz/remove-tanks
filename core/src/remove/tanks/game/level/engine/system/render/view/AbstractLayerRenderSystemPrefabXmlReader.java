package remove.tanks.game.level.engine.system.render.view;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.EntitySystemPrefabXmlReadException;
import remove.tanks.game.level.engine.system.SubEntitySystemPrefabXmlReader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public abstract class AbstractLayerRenderSystemPrefabXmlReader<T extends AbstractLayerRenderSystemPrefab>
        implements SubEntitySystemPrefabXmlReader<T>
{
    @Override
    public T readEntitySystemPrefab(XmlReader.Element element, int priority) {
        try {
            return readLayerRenderEntitySystemPrefab(element, priority);
        } catch (Exception e) {
            throw new EntitySystemPrefabXmlReadException(element, e);
        }
    }

    protected abstract T readLayerRenderEntitySystemPrefab(XmlReader.Element element, int priority);

    @Override
    public abstract SystemType getReaderType();
}
