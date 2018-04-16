package remove.tanks.game.audio.sound;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Mateusz Długosz
 */
public class SoundPrefabTest {
    @Test
    public void Should_ReturnAssignedValues() {
        assertEquals("file/name", new SoundPrefab("file/name").getFilename());
    }

    @Test
    public void Should_ReturnFormattedStringRepresentation() {
        assertEquals("SoundPrefab{filename=file/name}", new SoundPrefab("file/name").toString());
    }
}