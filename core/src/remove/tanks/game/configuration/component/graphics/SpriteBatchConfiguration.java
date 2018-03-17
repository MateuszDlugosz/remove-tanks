package remove.tanks.game.configuration.component.graphics;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;

/**
 * @author Mateusz Długosz
 */
public final class SpriteBatchConfiguration {
    @ComponentName("SpriteBatch")
    public static final class SpriteBatchSupplier extends ComponentSupplier<SpriteBatch> {
        @Override
        public SpriteBatch supplyComponent() {
            return new SpriteBatch();
        }
    }
}
