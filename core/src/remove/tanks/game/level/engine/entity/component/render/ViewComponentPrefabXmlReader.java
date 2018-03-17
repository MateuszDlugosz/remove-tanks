package remove.tanks.game.level.engine.entity.component.render;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.graphics.view.ViewPrefab;
import remove.tanks.game.graphics.view.ViewPrefabXmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentPrefabXmlReadException;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.SubComponentPrefabXmlReader;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class ViewComponentPrefabXmlReader implements SubComponentPrefabXmlReader<ViewComponentPrefab> {
    private final ViewPrefabXmlReader viewPrefabXmlReader;

    public ViewComponentPrefabXmlReader(ViewPrefabXmlReader viewPrefabXmlReader) {
        this.viewPrefabXmlReader = viewPrefabXmlReader;
    }

    @Override
    public ViewComponentPrefab readComponentPrefab(XmlReader.Element element) {
        try {
            return new ViewComponentPrefab(readViewPrefabs(element));
        } catch (Exception e) {
            throw new ComponentPrefabXmlReadException(element, e);
        }
    }

    private List<ViewPrefab> readViewPrefabs(XmlReader.Element element) {
        return viewPrefabXmlReader.readViewPrefabs(element.getChildByName(ViewPrefabXmlReader.VIEWS_ELEMENT));
    }

    @Override
    public ComponentType getReaderType() {
        return ComponentType.ViewComponent;
    }
}
