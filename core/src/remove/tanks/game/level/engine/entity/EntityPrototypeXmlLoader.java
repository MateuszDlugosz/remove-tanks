package remove.tanks.game.level.engine.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentPrototype;
import remove.tanks.game.level.engine.entity.component.ComponentPrototypeXmlLoader;

import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class EntityPrototypeXmlLoader {
    private final XmlReader xmlReader;
    private final ComponentPrototypeXmlLoader componentPrototypeXmlLoader;

    public EntityPrototypeXmlLoader(
            XmlReader xmlReader,
            ComponentPrototypeXmlLoader componentPrototypeXmlLoader
    ) {
        this.xmlReader = xmlReader;
        this.componentPrototypeXmlLoader = componentPrototypeXmlLoader;
    }

    public EntityPrototype loadEntityPrototype(String filename) {
        try {
            XmlReader.Element element = xmlReader.parse(Gdx.files.internal(filename));
            return new EntityPrototype(
                    filename,
                    componentPrototypeXmlLoader.loadComponentsPrototypes(
                            element.getChildByName(ComponentPrototypeXmlLoader.COMPONENTS_ELEMENT)
                    ).stream().collect(Collectors.toMap(ComponentPrototype::getClass, c -> c))
            );
        } catch (Exception e) {
            throw new EntityPrototypeXmlLoadException(filename, e);
        }
    }
}
