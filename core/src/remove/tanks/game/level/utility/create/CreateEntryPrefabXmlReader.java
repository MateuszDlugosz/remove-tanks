package remove.tanks.game.level.utility.create;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.EntityPrefabCodeXmlReader;
import remove.tanks.game.utility.surface.position.PositionPrefab;
import remove.tanks.game.utility.surface.position.PositionPrefabXmlReader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class CreateEntryPrefabXmlReader {
    public static final String CREATE_ENTRY_ELEMENT = "createEntry";
    public static final String CREATE_ENTRIES_ELEMENT = "createEntries";

    private final PositionPrefabXmlReader positionPrefabXmlReader;
    private final EntityPrefabCodeXmlReader entityPrefabCodeXmlReader;

    public CreateEntryPrefabXmlReader(
            PositionPrefabXmlReader positionPrefabXmlReader,
            EntityPrefabCodeXmlReader entityPrefabCodeXmlReader
    ) {
        this.positionPrefabXmlReader = positionPrefabXmlReader;
        this.entityPrefabCodeXmlReader = entityPrefabCodeXmlReader;
    }

    public List<CreateEntryPrefab> readCreateEntryPrefabs(XmlReader.Element element) {
        return Arrays.stream(element.getChildrenByName(CREATE_ENTRY_ELEMENT).toArray())
                .map(this::readCreateEntryPrefab)
                .collect(Collectors.toList());
    }

    public CreateEntryPrefab readCreateEntryPrefab(XmlReader.Element element) {
        try {
            return new CreateEntryPrefab(
                    readPrefabCode(element),
                    readPositionPrefab(element)
            );
        } catch (Exception e) {
            throw new CreateEntryPrefabXmlReadException(element, e);
        }
    }

    private String readPrefabCode(XmlReader.Element element) {
        return entityPrefabCodeXmlReader.readEntityPrefabCode(element.getChildByName(
                EntityPrefabCodeXmlReader.ENTITY_PREFAB_CODE_ELEMENT));
    }

    private PositionPrefab readPositionPrefab(XmlReader.Element element) {
        if (element.getChildByName(PositionPrefabXmlReader.POSITION_ELEMENT) == null) {
            return PositionPrefab.POSITION_PREFAB_ZERO;
        }
        return positionPrefabXmlReader.readPositionPrefab(
                element.getChildByName(PositionPrefabXmlReader.POSITION_ELEMENT));
    }
}
