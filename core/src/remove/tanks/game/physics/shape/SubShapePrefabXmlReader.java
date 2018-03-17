package remove.tanks.game.physics.shape;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public interface SubShapePrefabXmlReader<T extends ShapePrefab> {
    T readShapePrefab(XmlReader.Element element);
    ShapeType getReaderType();
}
