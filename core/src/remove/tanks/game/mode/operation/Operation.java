package remove.tanks.game.mode.operation;

import com.google.common.base.MoreObjects;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class Operation {
    private final List<String> levelPrototypeFilenames;

    public Operation(List<String> levelPrototypeFilenames) {
        if (levelPrototypeFilenames.size() == 0) {
            throw new IllegalArgumentException("Operation must contains at least one level filename.");
        }
        this.levelPrototypeFilenames = levelPrototypeFilenames;
    }

    public List<String> getLevelPrototypeFilenames() {
        return levelPrototypeFilenames;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("levelPrototypes", levelPrototypeFilenames)
                .toString();
    }
}
