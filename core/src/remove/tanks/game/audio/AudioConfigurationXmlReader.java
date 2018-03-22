package remove.tanks.game.audio;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.XmlReader;
import com.google.common.eventbus.EventBus;
import remove.tanks.game.utility.properties.Properties;
import remove.tanks.game.utility.properties.PropertiesXmlReader;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class AudioConfigurationXmlReader {
    public static final String AUDIO_CONFIGURATION_ELEMENT = "audioConfiguration";

    private final XmlReader xmlReader;
    private final PropertiesXmlReader propertiesXmlReader;

    public AudioConfigurationXmlReader(XmlReader xmlReader, PropertiesXmlReader propertiesXmlReader) {
        this.xmlReader = xmlReader;
        this.propertiesXmlReader = propertiesXmlReader;
    }

    public AudioConfiguration readAudioConfiguration(FileHandle fileHandle) {
        try {
            XmlReader.Element element = xmlReader.parse(fileHandle);
            return new AudioConfiguration(
                    readAudioConfigurationOptionsMap(element),
                    createNewEventBus()
            );
        } catch (Exception e) {
            throw new AudioConfigurationXmlReadException(fileHandle, e);
        }
    }

    private Map<AudioConfiguration.Option, Integer> readAudioConfigurationOptionsMap(XmlReader.Element element) {
        Properties properties = propertiesXmlReader.readProperties(
                element.getChildByName(PropertiesXmlReader.PROPERTIES_ELEMENT));

        fillPropertiesWithDefaultValues(properties);
        erasePropertiesUnusableKeys(properties);

        return properties.getProperties().entrySet().stream()
                .collect(Collectors.toMap(
                        e -> AudioConfiguration.Option.valueOf(e.getKey()),
                        e -> Integer.valueOf(e.getValue())
                ));
    }

    private void fillPropertiesWithDefaultValues(Properties properties) {
        for (AudioConfiguration.Option option : AudioConfiguration.Option.values()) {
            if (!properties.hasProperty(option.name())) {
                properties.putInt(option.name(), option.getDefaultValue());
            }
        }
    }

    private void erasePropertiesUnusableKeys(Properties properties) {
        Set<String> allowedProperties = Arrays.stream(AudioConfiguration.Option.values())
                .map(Enum::name).collect(Collectors.toSet());
        Set<String> propertiesToErase = new HashSet<>();
        properties.getProperties().keySet().forEach(k -> {
            if (!allowedProperties.contains(k)) {
                propertiesToErase.add(k);
            }
        });
        propertiesToErase.forEach(properties::removeProperty);
    }

    private EventBus createNewEventBus() {
        return new EventBus();
    }
}
