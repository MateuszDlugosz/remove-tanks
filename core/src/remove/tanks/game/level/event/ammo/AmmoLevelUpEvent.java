package remove.tanks.game.level.event.ammo;

import remove.tanks.game.level.event.Event;

/**
 * @author Mateusz Długosz
 */
public final class AmmoLevelUpEvent implements Event {
    public static final AmmoLevelUpEvent INSTANCE = new AmmoLevelUpEvent();

    private AmmoLevelUpEvent() {}
}
