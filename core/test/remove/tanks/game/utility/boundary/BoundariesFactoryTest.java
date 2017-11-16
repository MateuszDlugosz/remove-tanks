package remove.tanks.game.utility.boundary;

import org.junit.Before;
import org.junit.Test;
import remove.tanks.game.utility.scale.DividingScale;
import remove.tanks.game.utility.scale.MultiplyingScale;
import remove.tanks.game.utility.scale.Scale;

import static org.junit.Assert.assertEquals;

/**
 * @author Mateusz Długosz
 */
public class BoundariesFactoryTest {
    private Scale multiplyingScale;
    private Scale dividingScale;
    private BoundariesFactory boundariesFactory;

    @Before
    public void initTestObjects() {
        multiplyingScale = new MultiplyingScale(2);
        dividingScale = new DividingScale(2);
        boundariesFactory = new BoundariesFactory();
    }

    @Test
    public void when_PrototypeHasCorrectData_Then_CreateBoundariesObjectWithMultiplyingScale() {
        BoundariesPrototype prototype = new BoundariesPrototype(1, 3, 0, 5);
        Boundaries boundaries = boundariesFactory.createBoundaries(prototype, multiplyingScale);

        assertEquals(2, boundaries.getMinX(), 0.001f);
        assertEquals(6, boundaries.getMaxX(), 0.001f);
        assertEquals(0, boundaries.getMinY(), 0.001f);
        assertEquals(10, boundaries.getMaxY(), 0.001f);
    }

    @Test
    public void when_PrototypeHasCorrectData_Then_CreateBoundariesObjectWithDividingScale() {
        BoundariesPrototype prototype = new BoundariesPrototype(1, 3, 0, 5);
        Boundaries boundaries = boundariesFactory.createBoundaries(prototype, dividingScale);

        assertEquals(0.5f, boundaries.getMinX(), 0.001f);
        assertEquals(1.5f, boundaries.getMaxX(), 0.001f);
        assertEquals(0, boundaries.getMinY(), 0.001f);
        assertEquals(2.5f, boundaries.getMaxY(), 0.001f);
    }

    @Test(expected = BoundariesCreateException.class)
    public void when_PrototypeHasIncorrectData_Then_ThrowsException() {
        BoundariesPrototype prototype = new BoundariesPrototype(5, 1, 4, 2);

        boundariesFactory.createBoundaries(prototype, multiplyingScale);
    }
}