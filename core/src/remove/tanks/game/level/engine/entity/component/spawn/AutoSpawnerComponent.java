package remove.tanks.game.level.engine.entity.component.spawn;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;
import remove.tanks.game.level.engine.utility.letter.NATOLetter;

/**
 * @author Mateusz Długosz
 */
public final class AutoSpawnerComponent implements Component {
    public static final ComponentMapper<AutoSpawnerComponent> MAPPER
            = ComponentMapper.getFor(AutoSpawnerComponent.class);

    private final NATOLetter letter;

    public AutoSpawnerComponent(NATOLetter letter) {
        this.letter = letter;
    }

    public NATOLetter getLetter() {
        return letter;
    }
}
