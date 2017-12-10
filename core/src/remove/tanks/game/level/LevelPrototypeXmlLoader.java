package remove.tanks.game.level;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.EnginePrototypeXmlLoader;
import remove.tanks.game.utility.properties.PropertiesXmlLoader;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class LevelPrototypeXmlLoader {
    public static final String LEVEL_PROTOTYPE_ELEMENT = "levelPrototype";
    public static final String LEVEL_PROTOTYPES_ELEMENT = "levelPrototypes";

    private final XmlReader xmlReader;
    private final EnginePrototypeXmlLoader enginePrototypeXmlLoader;
    private final PropertiesXmlLoader propertiesXmlLoader;

    public LevelPrototypeXmlLoader(
            XmlReader xmlReader,
            EnginePrototypeXmlLoader enginePrototypeXmlLoader,
            PropertiesXmlLoader propertiesXmlLoader
    ) {
        this.xmlReader = xmlReader;
        this.enginePrototypeXmlLoader = enginePrototypeXmlLoader;
        this.propertiesXmlLoader = propertiesXmlLoader;
    }

    public List<LevelPrototype> loadLevelPrototypes(List<String> filenames) {
        return filenames.stream()
                .map(this::loadLevelPrototype)
                .collect(Collectors.toList());
    }

    public LevelPrototype loadLevelPrototype(String filename) {
        try {
            XmlReader.Element element = xmlReader.parse(Gdx.files.internal(filename));
            return new LevelPrototype(
                    enginePrototypeXmlLoader.loadEnginePrototype(
                            element.getChildByName(EnginePrototypeXmlLoader.ENGINE_ELEMENT)
                    ),
                    propertiesXmlLoader.loadProperties(
                            element.getChildByName(PropertiesXmlLoader.PROPERTIES_ELEMENT)
                    )
            );
        } catch (Exception e) {
            throw new LevelPrototypeXmlLoadException(e);
        }
    }
}
