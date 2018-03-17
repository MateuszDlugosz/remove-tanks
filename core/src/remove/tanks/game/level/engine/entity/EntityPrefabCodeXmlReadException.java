package remove.tanks.game.level.engine.entity;

import com.badlogic.gdx.utils.XmlReader;

/**
 * @author Mateusz Długosz
 */
public final class EntityPrefabCodeXmlReadException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot read entity prefab code from element %s.";

    public EntityPrefabCodeXmlReadException(XmlReader.Element element, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, element), cause);
    }
}
