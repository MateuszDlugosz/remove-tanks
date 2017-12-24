package remove.tanks.game.configuration.physics;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public enum MaskBit {
    SceneryMask((short) 0),
    PlayerVehicleMask((short) (
            CategoryBit.PlayerVehicleCategory.getBit() |
                    CategoryBit.PlayerVehicleBlockadeCategory.getBit() |
                    CategoryBit.EnemyBulletCategory.getBit() |
                    CategoryBit.EnemyVehicleCategory.getBit() |
                    CategoryBit.NeutralBulletCategory.getBit() |
                    CategoryBit.ObstacleCategory.getBit() |
                    CategoryBit.AllVehicleBlockadeCategory.getBit()
    )),
    PlayerBulletMask((short) (
            CategoryBit.EnemyVehicleCategory.getBit() |
                    CategoryBit.ObstacleCategory.getBit()
    )),
    PlayerVehicleBlockadeMask((
            CategoryBit.PlayerVehicleCategory.getBit()
    )),
    EnemyVehicleMask((short) (
            CategoryBit.EnemyVehicleCategory.getBit() |
                    CategoryBit.EnemyVehicleBlockadeCategory.getBit() |
                    CategoryBit.PlayerVehicleCategory.getBit() |
                    CategoryBit.PlayerBulletCategory.getBit() |
                    CategoryBit.NeutralBulletCategory.getBit() |
                    CategoryBit.ObstacleCategory.getBit() |
                    CategoryBit.AllVehicleBlockadeCategory.getBit()
    )),
    EnemyBulletMask((short) (
            CategoryBit.ObstacleCategory.getBit() |
                    CategoryBit.PlayerVehicleCategory.getBit()
    )),
    EnemyVehicleBlockadeMask((
            CategoryBit.EnemyVehicleCategory.getBit()
    )),
    NeutralBulletMask((short) (
            CategoryBit.EnemyVehicleCategory.getBit() |
                    CategoryBit.PlayerVehicleCategory.getBit() |
                    CategoryBit.ObstacleCategory.getBit()
    )),
    ObstacleMask((short) (
            CategoryBit.EnemyVehicleCategory.getBit() |
                    CategoryBit.EnemyBulletCategory.getBit() |
                    CategoryBit.PlayerVehicleCategory.getBit() |
                    CategoryBit.PlayerBulletCategory.getBit() |
                    CategoryBit.NeutralBulletCategory.getBit()
    )),
    AllVehicleBlockadeMask((short) (
            CategoryBit.EnemyVehicleCategory.getBit() |
                    CategoryBit.PlayerVehicleCategory.getBit()
    )),
    ActorMask(CategoryBit.ActorCategory.getBit());

    private final short bit;

    MaskBit(short bit) {
        this.bit = bit;
    }

    public short getBit() {
        return bit;
    }

    public static Map<String, Short> getMaskBitMap() {
        return Arrays.stream(values())
                .collect(Collectors.toMap(
                        Enum::toString,
                        MaskBit::getBit
                ));
    }
}
