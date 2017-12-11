package remove.tanks.game.level.engine.system;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.XmlReader;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class EntitySystemPrototypeXmlLoader {
    public static final String SYSTEM_ELEMENT = "system";
    public static final String SYSTEMS_ELEMENT = "systems";

    private static final String TYPE_ATTRIBUTE = "type";

    private final Map<SystemType, RegistrableEntitySystemPrototypeXmlLoader> subLoaders
            = new EnumMap<>(SystemType.class);

    public EntitySystemPrototypeXmlLoader(RegistrableEntitySystemPrototypeXmlLoader[] subLoaders) {
        Arrays.stream(subLoaders).forEach(s -> this.subLoaders.put(s.getLoaderType(), s));
    }

    public List<EntitySystemPrototype> loadEntitySystemPrototypes(Array<XmlReader.Element> elements) {
        return Arrays.stream(elements.toArray())
                .map(this::loadEntitySystemPrototype)
                .collect(Collectors.toList());
    }

    public EntitySystemPrototype loadEntitySystemPrototype(XmlReader.Element element) {
        try {
            SystemType type = SystemType.valueOf(element.getAttribute(TYPE_ATTRIBUTE).trim());
            if (!subLoaders.containsKey(type)) {
                throw new EntitySystemLoaderNotFoundException(type);
            }
            return subLoaders.get(type).loadEntitySystemPrototype(element, type.getPriority());
        } catch (Exception e) {
            throw new EntitySystemPrototypeXmlLoadException(element, e);
        }
    }
}
