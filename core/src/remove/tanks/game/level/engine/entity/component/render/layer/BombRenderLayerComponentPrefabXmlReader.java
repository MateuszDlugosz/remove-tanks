package remove.tanks.game.level.engine.entity.component.render.layer;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentPrefabXmlReadException;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.SubComponentPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class BombRenderLayerComponentPrefabXmlReader implements SubComponentPrefabXmlReader<BombRenderLayerComponentPrefab> {
    @Override
    public BombRenderLayerComponentPrefab readComponentPrefab(XmlReader.Element element) {
        try {
            return BombRenderLayerComponentPrefab.INSTANCE;
        } catch (Exception e) {
            throw new ComponentPrefabXmlReadException(element, e);
        }
    }

    @Override
    public ComponentType getReaderType() {
        return ComponentType.BombRenderLayerComponent;
    }
}
