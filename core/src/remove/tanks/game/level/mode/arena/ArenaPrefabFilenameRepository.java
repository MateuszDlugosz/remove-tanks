package remove.tanks.game.level.mode.arena;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class ArenaPrefabFilenameRepository {
    private final List<String> arenaPrefabFilenames;

    public ArenaPrefabFilenameRepository(List<String> arenaPrefabFilenames) {
        this.arenaPrefabFilenames = arenaPrefabFilenames;
    }

    public List<String> getArenaPrefabFilenames() {
        return arenaPrefabFilenames;
    }
}
