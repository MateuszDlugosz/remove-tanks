package remove.tanks.game.level;

import remove.tanks.game.level.resource.ResourceType;
import remove.tanks.game.utility.properties.Properties;

/**
 * @author Mateusz Długosz
 */
public final class LevelTransferablePropertiesExtractor {
    public Properties extractProperties(Level level) {
        Properties levelProperties = level.getResourceRegistry()
                .getResource(ResourceType.LevelPropertiesResource, Properties.class);
        Properties properties = new Properties();
        properties.putString(LevelProperty.LevelEnemiesDestroyed.getName(),
                levelProperties.getString(LevelProperty.LevelEnemiesDestroyed.getName()));
        properties.putString(LevelProperty.LevelPoints.getName(),
                levelProperties.getString(LevelProperty.LevelPoints.getName()));
        properties.putString(LevelProperty.LevelLifes.getName(),
                levelProperties.getString(LevelProperty.LevelLifes.getName()));
        return properties;
    }
}
