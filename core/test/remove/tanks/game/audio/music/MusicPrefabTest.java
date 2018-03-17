package remove.tanks.game.audio.music;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Mateusz Długosz
 */
public class MusicPrefabTest {
    @Test
    public void Should_ReturnAssignedValues() {
        assertEquals("file/name", new MusicPrefab("file/name").getFilename());
    }

    @Test
    public void Should_ReturnFormattedStringRepresentation() {
        assertEquals("MusicPrefab{filename=file/name}", new MusicPrefab("file/name").toString());
    }
}