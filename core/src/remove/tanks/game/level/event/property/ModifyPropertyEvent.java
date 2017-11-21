package remove.tanks.game.level.event.property;

import remove.tanks.game.level.constant.LevelProperty;

/**
 * @author Mateusz Długosz
 */
public final class ModifyPropertyEvent {
    private final LevelProperty levelProperty;
    private final String newValue;

    public ModifyPropertyEvent(LevelProperty levelProperty, String newValue) {
        this.levelProperty = levelProperty;
        this.newValue = newValue;
    }

    public LevelProperty getLevelProperty() {
        return levelProperty;
    }

    public String getNewValue() {
        return newValue;
    }
}
