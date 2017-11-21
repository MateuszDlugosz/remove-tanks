package remove.tanks.game.level.event.property;

import remove.tanks.game.level.Level;
import remove.tanks.game.level.constant.LevelResource;
import remove.tanks.game.level.event.RegistrableEventExecutor;
import remove.tanks.game.utility.properties.Properties;

/**
 * @author Mateusz Długosz
 */
public final class ModifyPropertyEventExecutor implements RegistrableEventExecutor<ModifyPropertyEvent> {
    @Override
    public void executeEvent(ModifyPropertyEvent event, Level level) {
        level.getResourceRegistry().getResource(LevelResource.Properties.toString(), Properties.class)
                .putString(event.getLevelProperty().getName(), event.getNewValue());
    }

    @Override
    public Class<ModifyPropertyEvent> getExecutorType() {
        return ModifyPropertyEvent.class;
    }
}
