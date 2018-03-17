package remove.tanks.game.level.engine.entity.component.combat;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentPrefabXmlReadException;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.SubComponentPrefabXmlReader;
import remove.tanks.game.level.utility.direction.Direction;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class AmmoComponentPrefabXmlReader implements SubComponentPrefabXmlReader<AmmoComponentPrefab> {
    private static final String AMMO_ELEMENT = "ammo";
    private static final String BULLET_ELEMENT = "bullet";
    private static final String DIRECTION_ATTRIBUTE = "direction";
    private static final String CURRENT_LEVEL_ELEMENT = "currentLevel";
    private static final String MAX_LEVEL_ELEMENT = "maxLevel";
    private static final String LEVEL_ATTRIBUTE = "level";

    @Override
    public AmmoComponentPrefab readComponentPrefab(XmlReader.Element element) {
        try {
            return new AmmoComponentPrefab(
                    readCurrentLevel(element),
                    readMaxLevel(element),
                    readPrefabCodes(element)
            );
        } catch (Exception e) {
            throw new ComponentPrefabXmlReadException(element, e);
        }
    }

    private int readCurrentLevel(XmlReader.Element element) {
        return Integer.valueOf(element.getChildByName(CURRENT_LEVEL_ELEMENT).getText().trim());
    }

    private int readMaxLevel(XmlReader.Element element) {
        return Integer.valueOf(element.getChildByName(MAX_LEVEL_ELEMENT).getText().trim());
    }

    private Map<Integer, Map<Direction, String>> readPrefabCodes(XmlReader.Element element) {
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
    public ComponentType getReaderType() {
        return ComponentType.AmmoComponent;
    }
}
