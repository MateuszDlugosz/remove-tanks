package remove.tanks.game.level.engine.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.XmlReader;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class EntityPrototypeRepositoryXmlLoader {
    public static final String PROTOTYPE_ELEMENT = "prototype";
    public static final String PROTOTYPES_ELEMENT = "prototypes";

    private static final String CODE_ATTRIBUTE = "code";

    private final XmlReader xmlReader;
    private final EntityPrototypeXmlLoader entityPrototypeXmlLoader;

    public EntityPrototypeRepositoryXmlLoader(
            XmlReader xmlReader,
            EntityPrototypeXmlLoader entityPrototypeXmlLoader
    ) {
        this.xmlReader = xmlReader;
        this.entityPrototypeXmlLoader = entityPrototypeXmlLoader;
    }

    public EntityPrototypeRepository loadPrototypeRepository(String filename) {
        try {
            XmlReader.Element element = xmlReader.parse(Gdx.files.internal(filename));
            return new EntityPrototypeRepository(Arrays.stream(
                    element.getChildByName(PROTOTYPES_ELEMENT)
                            .getChildrenByName(PROTOTYPE_ELEMENT).toArray())
                    .collect(Collectors.toMap(
                            e -> e.getAttribute(CODE_ATTRIBUTE).trim(),
                            e -> entityPrototypeXmlLoader.loadEntityPrototype(e.getText())
                    ))
            );
        } catch (IOException e) {
            throw new EntityPrototypeRepositoryFileNotFoundException(filename);
        }
    }
}
