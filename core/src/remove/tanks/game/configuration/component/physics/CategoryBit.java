package remove.tanks.game.configuration.component.physics;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public enum CategoryBit {
    SceneryCategory((short) 1),
    PlayerVehicleCategory((short) 2),
    PlayerBulletCategory((short) 4),
    PlayerVehicleBlockadeCategory((short) 8),
    EnemyVehicleCategory((short) 16),
    EnemyBulletCategory((short) 32),
    EnemyVehicleBlockadeCategory((short) 64),
    NeutralBulletCategory((short) 128),
    ObstacleCategory((short) 256),
    AllVehicleBlockadeCategory((short) 512),
    ActorCategory((short) 1024);

    private final short bit;

    CategoryBit(short bit) {
        this.bit = bit;
    }

    public short getBit() {
        return bit;
    }

    public static Map<String, Short> getCategoryBitMap() {
        return Arrays.stream(values())
                .collect(Collectors.toMap(
                        Enum::toString,
                        CategoryBit::getBit
                ));
    }
}
