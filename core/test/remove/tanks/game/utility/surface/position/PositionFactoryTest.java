package remove.tanks.game.utility.surface.position;

import org.junit.Before;
import org.junit.Test;
import remove.tanks.game.utility.scale.DividingScale;
import remove.tanks.game.utility.scale.MultiplyingScale;

import java.util.ArrayList;
import java.util.List;

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
    public void Should_ReturnScaledPosition_When_GivenPrefabAndMultiplyingScale() {
        PositionPrefab prefab = new PositionPrefab(20, 10);
        Position position = positionFactory.createPosition(prefab, multiplyingScale);

        assertEquals(40, position.getX(), 0.001f);
        assertEquals(20, position.getY(), 0.001f);
    }

    @Test
    public void Should_ReturnScaledPosition_When_GivenPrefabAndDividingScale() {
        PositionPrefab prefab = new PositionPrefab(20, 10);
        Position position = positionFactory.createPosition(prefab, dividingScale);

        assertEquals(10, position.getX(), 0.001f);
        assertEquals(5, position.getY(), 0.001f);
    }

    @Test
    public void Should_ReturnScaledPositions_When_GivenPrefabsAndScale() {
        List<PositionPrefab> prefabs = new ArrayList<>();
        prefabs.add(new PositionPrefab(10, 20));
        prefabs.add(new PositionPrefab(2, 3));

        List<Position> positions_m = positionFactory.createPositions(prefabs, multiplyingScale);
        List<Position> positions_d = positionFactory.createPositions(prefabs, dividingScale);

        assertEquals(20, positions_m.get(0).getX(), 0.001f);
        assertEquals(40, positions_m.get(0).getY(), 0.001f);
        assertEquals(4, positions_m.get(1).getX(), 0.001f);
        assertEquals(6, positions_m.get(1).getY(), 0.001f);

        assertEquals(5, positions_d.get(0).getX(), 0.001f);
        assertEquals(10, positions_d.get(0).getY(), 0.001f);
        assertEquals(1, positions_d.get(1).getX(), 0.001f);
        assertEquals(1.5f, positions_d.get(1).getY(), 0.001f);
    }
}
