package remove.tanks.game.level;

import remove.tanks.game.constant.LevelProperty;
import remove.tanks.game.utility.properties.Properties;

import java.util.Arrays;

/**
 * @author Mateusz Długosz
 */
public final class LevelPropertiesInitializer {
    public Properties initializeLevelProperties(Properties properties) {
        Properties levelProperties = new Properties();
        Arrays.stream(LevelProperty.values())
                .forEach(p -> levelProperties.putString(p.getName(), p.getDefaultValue()));
        levelProperties.merge(properties);
        return levelProperties;
    }
}
