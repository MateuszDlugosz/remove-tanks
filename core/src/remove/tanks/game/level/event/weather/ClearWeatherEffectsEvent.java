package remove.tanks.game.level.event.weather;

import remove.tanks.game.level.event.Event;

/**
 * @author Mateusz Długosz
 */
public final class ClearWeatherEffectsEvent implements Event {
    public static final ClearWeatherEffectsEvent INSTANCE = new ClearWeatherEffectsEvent();

    private ClearWeatherEffectsEvent() {}
}
