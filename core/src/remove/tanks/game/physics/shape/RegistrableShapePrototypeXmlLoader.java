package remove.tanks.game.physics.shape;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public interface RegistrableShapePrototypeXmlLoader<T extends ShapePrototype> {
    T loadShapePrototype(XmlReader.Element element);
    ShapeType getLoaderType();
}
