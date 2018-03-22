package remove.tanks.game.audio;

import remove.tanks.game.utility.properties.Properties;

import java.util.Arrays;

/**
 * @author Mateusz Długosz
 */
public final class AudioConfigurationToPropertiesConverter {
    public Properties convertAudioConfiguration(AudioConfiguration audioConfiguration) {
        try {
            Properties properties = new Properties();
            Arrays.stream(AudioConfiguration.Option.values())
                    .forEach(v -> properties.putInt(v.name(), audioConfiguration.getOptionValueAsInt(v)));
            return properties;
        } catch (Exception e) {
            throw new AudioConfigurationConvertException(e);
        }
    }
}
