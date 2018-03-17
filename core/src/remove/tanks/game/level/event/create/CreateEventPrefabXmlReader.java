package remove.tanks.game.level.event.create;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.event.EventPrefabXmlReadException;
import remove.tanks.game.level.event.EventType;
import remove.tanks.game.level.event.SubEventPrefabXmlReader;
import remove.tanks.game.level.utility.create.CreateEntryPrefab;
import remove.tanks.game.level.utility.create.CreateEntryPrefabXmlReader;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class CreateEventPrefabXmlReader implements SubEventPrefabXmlReader<CreateEventPrefab> {
    private final CreateEntryPrefabXmlReader createEntryPrefabXmlReader;

    public CreateEventPrefabXmlReader(CreateEntryPrefabXmlReader createEntryPrefabXmlReader) {
        this.createEntryPrefabXmlReader = createEntryPrefabXmlReader;
    }

    @Override
    public CreateEventPrefab readEventPrefab(XmlReader.Element element) {
        try {
            return new CreateEventPrefab(readCreateEntryPrefab(element));
        } catch (Exception e) {
            throw new EventPrefabXmlReadException(element, e);
        }
    }

    private List<CreateEntryPrefab> readCreateEntryPrefab(XmlReader.Element element) {
        return createEntryPrefabXmlReader.readCreateEntryPrefabs(element.getChildByName(CreateEntryPrefabXmlReader.CREATE_ENTRIES_ELEMENT));
    }

    @Override
    public EventType getReaderType() {
        return EventType.CreateEvent;
    }
}
