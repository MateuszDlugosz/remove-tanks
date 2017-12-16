package remove.tanks.game.configuration.component.mode;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.level.LevelSequenceXmlLoader;
import remove.tanks.game.mode.arena.ArenaXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class ArenaSupplierConfiguration {
    @ComponentName("ArenaXmlLoader")
    public static final class ArenaXmlLoaderSupplier extends ComponentSupplier<ArenaXmlLoader> {
        @Override
        public ArenaXmlLoader supplyComponent() {
            return new ArenaXmlLoader(
                    getContext().getComponent("XmlReader", XmlReader.class),
                    getContext().getComponent("LevelSeqenceXmlLoader", LevelSequenceXmlLoader.class)
            );
        }
    }
}
