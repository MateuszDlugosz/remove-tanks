package remove.tanks.game.input;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Mateusz Długosz
 */
public class InputMapperTest {
    private InputMapper inputMapper;

    @Before
    public void initTestObjects() {
        inputMapper = new InputMapper(
                Arrays.stream(InputKey.values())
                        .collect(Collectors.toMap(
                                v -> v,
                                v -> false
                        ))
        );
    }

    @Test
    public void Should_ReturnTrue_When_KeysArePressed() {
        inputMapper.keyUpAll();
        inputMapper.keyDown(InputKey.Left);
        inputMapper.keyDown(InputKey.Right);

        assertTrue(inputMapper.isKeyPressed(InputKey.Left));
        assertTrue(inputMapper.isKeyPressed(InputKey.Right));
    }

    @Test
    public void Should_ReturnFalse_When_KeysAreNotPressed() {
        inputMapper.keyUpAll();

        assertFalse(inputMapper.isKeyPressed(InputKey.Left));
        assertFalse(inputMapper.isKeyPressed(InputKey.Right));
    }
}