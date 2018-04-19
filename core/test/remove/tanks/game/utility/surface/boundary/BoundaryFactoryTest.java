package remove.tanks.game.utility.surface.boundary;

import org.junit.Before;
import org.junit.Test;
import remove.tanks.game.utility.scale.DividingImmutableScale;
import remove.tanks.game.utility.scale.MultiplyingImmutableScale;
import remove.tanks.game.utility.scale.Scale;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Mateusz Długosz
 */
public class BoundaryFactoryTest {
    private Scale multiplyingScale;
    private Scale dividingScale;
    private BoundaryFactory boundaryFactory;

    @Before
    public void initTestObjects() {
        multiplyingScale = new MultiplyingImmutableScale(2);
        dividingScale = new DividingImmutableScale(2);
        boundaryFactory = new BoundaryFactory();
    }

    @Test
    public void Should_ReturnScaledBoundary_When_GivenPrefabAndMultiplyingScale() {
        BoundaryPrefab prefab = new BoundaryPrefab(1, 3, 0, 5);
        Boundary boundary = boundaryFactory.createBoundary(prefab, multiplyingScale);

        assertEquals(2, boundary.getMinX(), 0.001f);
        assertEquals(6, boundary.getMaxX(), 0.001f);
        assertEquals(0, boundary.getMinY(), 0.001f);
        assertEquals(10, boundary.getMaxY(), 0.001f);
    }

    @Test
    public void Should_ReturnScaledBoundary_When_GivenPrefabAndDividingScale() {
        BoundaryPrefab prefab = new BoundaryPrefab(1, 3, 0, 5);
        Boundary boundary = boundaryFactory.createBoundary(prefab, dividingScale);

        assertEquals(0.5f, boundary.getMinX(), 0.001f);
        assertEquals(1.5f, boundary.getMaxX(), 0.001f);
        assertEquals(0, boundary.getMinY(), 0.001f);
        assertEquals(2.5f, boundary.getMaxY(), 0.001f);
    }

    @Test
    public void Should_ReturnScaledBoundaries_When_GivenIsListOfPrefabsAndScale() {
        List<BoundaryPrefab> prefabs = new ArrayList<>();
        prefabs.add(new BoundaryPrefab(0, 1, 2, 3));
        prefabs.add(new BoundaryPrefab(10, 20, 30, 40));

        List<Boundary> boundaries = boundaryFactory.createBoundaries(prefabs, multiplyingScale);

        assertEquals(0, boundaries.get(0).getMinX(), 0.001f);
        assertEquals(2, boundaries.get(0).getMaxX(), 0.001f);
        assertEquals(4, boundaries.get(0).getMinY(), 0.001f);
        assertEquals(6, boundaries.get(0).getMaxY(), 0.001f);

        assertEquals(20, boundaries.get(1).getMinX(), 0.001f);
        assertEquals(40, boundaries.get(1).getMaxX(), 0.001f);
        assertEquals(60, boundaries.get(1).getMinY(), 0.001f);
        assertEquals(80, boundaries.get(1).getMaxY(), 0.001f);
    }

    @Test(expected = BoundaryCreateException.class)
    public void Should_ThrowException_When_GivenIsListOfPrefabsAndScaleWithIncorrectBoundaryValue() {
        List<BoundaryPrefab> prefabs = new ArrayList<>();
        prefabs.add(new BoundaryPrefab(0, 1, 2, 3));
        prefabs.add(new BoundaryPrefab(10, 1, 20, 2));

        boundaryFactory.createBoundaries(prefabs, dividingScale);
    }

    @Test(expected = BoundaryCreateException.class)
    public void Should_ThrowException_When_GivenPrefabHasIncorrectData() {
        BoundaryPrefab prefab = new BoundaryPrefab(5, 1, 4, 2);

        boundaryFactory.createBoundary(prefab, multiplyingScale);
    }
}