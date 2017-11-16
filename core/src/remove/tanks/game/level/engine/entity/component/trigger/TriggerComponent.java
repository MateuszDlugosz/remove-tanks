package remove.tanks.game.level.engine.entity.component.trigger;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;
import remove.tanks.game.level.engine.utility.letter.NATOLetter;

/**
 * @author Mateusz Długosz
 */
public final class TriggerComponent implements Component {
    public static final ComponentMapper<TriggerComponent> MAPPER
            = ComponentMapper.getFor(TriggerComponent.class);

    private final NATOLetter letter;

    public TriggerComponent(NATOLetter letter) {
        this.letter = letter;
    }

    public NATOLetter getLetter() {
        return letter;
    }
}
