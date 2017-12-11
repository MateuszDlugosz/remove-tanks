package remove.tanks.game.level.engine.entity.component;

import com.badlogic.gdx.utils.XmlReader;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class ComponentPrototypeXmlLoader {
    public static final String COMPONENT_ELEMENT = "component";
    public static final String COMPONENTS_ELEMENT = "components";

    private static final String TYPE_ATTRIBUTE = "type";

    private final Map<ComponentType, RegistrableComponentPrototypeXmlLoader> subLoaders
            = new EnumMap<>(ComponentType.class);

    public ComponentPrototypeXmlLoader(RegistrableComponentPrototypeXmlLoader[] subLoaders) {
        Arrays.stream(subLoaders).forEach(s -> this.subLoaders.put(s.getLoaderType(), s));
    }

    public List<ComponentPrototype> loadComponentsPrototypes(XmlReader.Element element) {
        return Arrays.stream(element.getChildrenByName(COMPONENT_ELEMENT).toArray())
                .map(this::loadComponentPrototype)
                .collect(Collectors.toList());
    }

    public ComponentPrototype loadComponentPrototype(XmlReader.Element element) {
        try {
            ComponentType type = ComponentType.valueOf(element.getAttribute(TYPE_ATTRIBUTE).trim());
            if (!subLoaders.containsKey(type)) {
                throw new ComponentPrototypeLoaderNotFoundException(type);
            }
            return subLoaders.get(type).loadComponentPrototype(element);
        } catch (Exception e) {
            throw new ComponentPrototypeXmlLoadException(element, e);
        }
    }
}
