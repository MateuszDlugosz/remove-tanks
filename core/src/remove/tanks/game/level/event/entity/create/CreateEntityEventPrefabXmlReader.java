package remove.tanks.game.level.event.entity.create;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.event.EntityEventPrefabXmlReadException;
import remove.tanks.game.level.event.EntityEventType;
import remove.tanks.game.level.event.SubEntityEventPrefabXmlReader;
import remove.tanks.game.level.utility.create.CreateEntryPrefab;
import remove.tanks.game.level.utility.create.CreateEntryPrefabXmlReader;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class CreateEntityEventPrefabXmlReader implements SubEntityEventPrefabXmlReader<CreateEntityEventPrefab> {
    private final CreateEntryPrefabXmlReader createEntryPrefabXmlReader;

    public CreateEntityEventPrefabXmlReader(CreateEntryPrefabXmlReader createEntryPrefabXmlReader) {
        this.createEntryPrefabXmlReader = createEntryPrefabXmlReader;
    }

    @Override
    public CreateEntityEventPrefab readEntityEventPrefab(XmlReader.Element element) {
        try {
            return new CreateEntityEventPrefab(readCreateEntryPrefabs(element));
        } catch (Exception e) {
            throw new EntityEventPrefabXmlReadException(element, e);
        }
    }

    private List<CreateEntryPrefab> readCreateEntryPrefabs(XmlReader.Element element) {
        return createEntryPrefabXmlReader.readCreateEntryPrefabs(
                element.getChildByName(CreateEntryPrefabXmlReader.CREATE_ENTRIES_ELEMENT));
    }

    @Override
    public EntityEventType getReaderType() {
        return EntityEventType.CreateEntityEvent;
    }
}
