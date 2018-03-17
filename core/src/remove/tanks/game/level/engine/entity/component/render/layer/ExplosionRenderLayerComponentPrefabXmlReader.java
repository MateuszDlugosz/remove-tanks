package remove.tanks.game.level.engine.entity.component.render.layer;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentPrefabXmlReadException;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.SubComponentPrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class ExplosionRenderLayerComponentPrefabXmlReader implements SubComponentPrefabXmlReader<ExplosionRenderLayerComponentPrefab> {
    @Override
    public ExplosionRenderLayerComponentPrefab readComponentPrefab(XmlReader.Element element) {
        try {
            return new ExplosionRenderLayerComponentPrefab();
        } catch (Exception e) {
            throw new ComponentPrefabXmlReadException(element, e);
        }
    }

    @Override
    public ComponentType getReaderType() {
        return ComponentType.ExplosionRenderLayerComponent;
    }
}
