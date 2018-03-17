package remove.tanks.game.level.engine.entity.component.lifecycle;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentPrefabXmlReadException;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.SubComponentPrefabXmlReader;
import remove.tanks.game.level.utility.create.CreateEntryPrefab;
import remove.tanks.game.level.utility.create.CreateEntryPrefabXmlReader;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class RandomCreateComponentPrefabXmlReader implements SubComponentPrefabXmlReader<RandomCreateComponentPrefab> {
    private static final String MIN_CREATE_FREQUENCY_ELEMENT = "minCreateFrequency";
    private static final String MAX_CREATE_FREQUENCY_ELEMENT = "maxCreateFrequency";

    private final CreateEntryPrefabXmlReader createEntryPrefabXmlReader;

    public RandomCreateComponentPrefabXmlReader(CreateEntryPrefabXmlReader createEntryPrefabXmlReader) {
        this.createEntryPrefabXmlReader = createEntryPrefabXmlReader;
    }

    @Override
    public RandomCreateComponentPrefab readComponentPrefab(XmlReader.Element element) {
        try {
            return new RandomCreateComponentPrefab(
                    readMinCreateFrequency(element),
                    readMaxCreateFrequency(element),
                    readCreateEntryPrefabs(element)
            );
        } catch (Exception e) {
            throw new ComponentPrefabXmlReadException(element, e);
        }
    }

    private float readMinCreateFrequency(XmlReader.Element element) {
        return Float.valueOf(element.getChildByName(MIN_CREATE_FREQUENCY_ELEMENT).getText().trim());
    }

    private float readMaxCreateFrequency(XmlReader.Element element) {
        return Float.valueOf(element.getChildByName(MAX_CREATE_FREQUENCY_ELEMENT).getText().trim());
    }

    private List<CreateEntryPrefab> readCreateEntryPrefabs(XmlReader.Element element) {
        return createEntryPrefabXmlReader.readCreateEntryPrefabs(
                element.getChildByName(CreateEntryPrefabXmlReader.CREATE_ENTRIES_ELEMENT));
    }

    @Override
    public ComponentType getReaderType() {
        return ComponentType.RandomCreateComponent;
    }
}
