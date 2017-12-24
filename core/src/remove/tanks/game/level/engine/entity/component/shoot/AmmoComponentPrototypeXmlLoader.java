package remove.tanks.game.level.engine.entity.component.shoot;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentPrototypeXmlLoadException;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentPrototypeXmlLoader;
import remove.tanks.game.level.engine.utility.direction.Direction;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class AmmoComponentPrototypeXmlLoader
        implements RegistrableComponentPrototypeXmlLoader<AmmoComponentPrototype>
{
    private static final String AMMO_ELEMENT = "ammo";
    private static final String BULLET_ELEMENT = "bullet";
    private static final String DIRECTION_ATTRIBUTE = "direction";
    private static final String CURRENT_LEVEL_ELEMENT = "currentLevel";
    private static final String MAX_LEVEL_ELEMENT = "maxLevel";
    private static final String LEVEL_ATTRIBUTE = "level";

    @Override
    public AmmoComponentPrototype loadComponentPrototype(XmlReader.Element element) {
        try {
            return new AmmoComponentPrototype(
                    loadCurrentLevel(element),
                    loadMaxLevel(element),
                    loadPrototypeCodes(element)
            );
        } catch (Exception e) {
            throw new ComponentPrototypeXmlLoadException(element, e);
        }
    }

    private int loadCurrentLevel(XmlReader.Element element) {
        return Integer.valueOf(element.getChildByName(CURRENT_LEVEL_ELEMENT).getText().trim());
    }

    private int loadMaxLevel(XmlReader.Element element) {
        return Integer.valueOf(element.getChildByName(MAX_LEVEL_ELEMENT).getText().trim());
    }

    private Map<Integer, Map<Direction, String>> loadPrototypeCodes(XmlReader.Element element) {
        return Arrays.stream(element.getChildrenByName(AMMO_ELEMENT).toArray())
                .collect(Collectors.toMap(
                        e -> Integer.valueOf(e.getAttribute(LEVEL_ATTRIBUTE).trim()),
                        e -> Arrays.stream(e.getChildrenByName(BULLET_ELEMENT).toArray())
                                .collect(Collectors.toMap(
                                        ec -> Direction.valueOf(ec.getAttribute(DIRECTION_ATTRIBUTE).trim()),
                                        ec -> ec.getText().trim()
                                ))
                ));
    }

    @Override
    public ComponentType getLoaderType() {
        return ComponentType.AmmoComponent;
    }
}
