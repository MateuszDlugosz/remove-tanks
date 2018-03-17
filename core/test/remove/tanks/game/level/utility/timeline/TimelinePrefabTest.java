package remove.tanks.game.level.utility.timeline;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Mateusz Długosz
 */
public class TimelinePrefabTest {
    @Test
    public void Should_ReturnAssignedValues() {
        List<TimelineEntryPrefab> prefabs = new ArrayList<>();
        prefabs.add(new TimelineEntryPrefab(1f, new ArrayList<>()));
        prefabs.add(new TimelineEntryPrefab(2f, new ArrayList<>()));

        TimelinePrefab prefab = new TimelinePrefab(prefabs);

        assertEquals(2, prefab.getTimelineEntryPrefabs().size());
        assertEquals(1f, prefab.getTimelineEntryPrefabs().get(0).getTime(), 0.001f);
        assertEquals(2f, prefab.getTimelineEntryPrefabs().get(1).getTime(), 0.001f);
    }

    @Test
    public void Should_ReturnFormattedStringRepresentation() {
        List<TimelineEntryPrefab> prefabs = new ArrayList<>();
        prefabs.add(new TimelineEntryPrefab(1f, new ArrayList<>()));
        prefabs.add(new TimelineEntryPrefab(2f, new ArrayList<>()));

        TimelinePrefab prefab = new TimelinePrefab(prefabs);

        assertEquals("TimelinePrefab{timelineEntryPrefabs=[TimelineEntryPrefab{time=1.0, eventPrefabs=[]}," +
                " TimelineEntryPrefab{time=2.0, eventPrefabs=[]}]}", prefab.toString());
    }
}