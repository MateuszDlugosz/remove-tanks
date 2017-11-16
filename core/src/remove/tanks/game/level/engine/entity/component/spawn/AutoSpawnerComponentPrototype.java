package remove.tanks.game.level.engine.entity.component.spawn;

import com.google.common.base.MoreObjects;
import remove.tanks.game.level.engine.entity.component.ComponentPrototype;
import remove.tanks.game.level.engine.utility.letter.NATOLetter;

/**
 * @author Mateusz Długosz
 */
public final class AutoSpawnerComponentPrototype implements ComponentPrototype {
    private final NATOLetter letter;

    public AutoSpawnerComponentPrototype(NATOLetter letter) {
        this.letter = letter;
    }

    public NATOLetter getLetter() {
        return letter;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("letter", letter)
                .toString();
    }
}
