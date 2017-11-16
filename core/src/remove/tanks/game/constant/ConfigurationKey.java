package remove.tanks.game.constant;

/**
 * @author Mateusz Długosz
 */
public enum ConfigurationKey {
    GameLevelWorldScale("game.level.world.scale"),
    GameDisplayScale("game.display.scale"),
    GameDisplayWidth("game.display.width"),
    GameDisplayHeight("game.display.height");

    private final String key;

    ConfigurationKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
