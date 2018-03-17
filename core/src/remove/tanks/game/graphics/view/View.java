package remove.tanks.game.graphics.view;

import remove.tanks.game.graphics.effect.Effect;
import remove.tanks.game.utility.surface.position.Position;

import java.util.Optional;

/**
 * @author Mateusz Długosz
 */
public interface View {
    String getId();
    Position getPosition();
    Optional<Effect> getEffect();
    void setEffect(Effect effect);
}
