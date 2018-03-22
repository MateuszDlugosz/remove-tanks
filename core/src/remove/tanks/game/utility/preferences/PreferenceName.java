package remove.tanks.game.utility.preferences;

/**
 * @author Mateusz Długosz
 */
public enum PreferenceName {
    LanguagePreference("language");

    private final String name;

    PreferenceName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
