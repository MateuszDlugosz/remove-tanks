package remove.tanks.game.level.event.weather;

import remove.tanks.game.level.event.Event;

/**
 * @author Mateusz Długosz
 */
public final class RemoveWeatherEffectEvent implements Event {
    private final String id;

    public RemoveWeatherEffectEvent(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
