package remove.tanks.game.utility.position;

import org.junit.Before;
import org.junit.Test;
import remove.tanks.game.utility.scale.DividingScale;
import remove.tanks.game.utility.scale.MultiplyingScale;

import static org.junit.Assert.assertEquals;

/**
 * @author Mateusz Długosz
 */
public class PositionFactoryTest {
    private DividingScale dividingScale;
    private MultiplyingScale multiplyingScale;
    private PositionFactory positionFactory;

    @Before
    public void initTestObjects() {
        dividingScale = new DividingScale(2);
        multiplyingScale = new MultiplyingScale(2);
        positionFactory = new PositionFactory();
    }

    @Test
    public void when_PrototypeHasCorrectData_Then_CreatePositionObjectWithMultiplyingScale() {
        PositionPrototype prototype = new PositionPrototype(20, 10);
        Position position = positionFactory.createPosition(prototype, multiplyingScale);

        assertEquals(40, position.getX(), 0.001f);
        assertEquals(20, position.getY(), 0.001f);
    }

    @Test
    public void when_PrototypeHasCorrectData_Then_CreatePositionObjectWithDividingScale() {
        PositionPrototype prototype = new PositionPrototype(20, 10);
        Position position = positionFactory.createPosition(prototype, dividingScale);

        assertEquals(10, position.getX(), 0.001f);
        assertEquals(5, position.getY(), 0.001f);
    }
}
