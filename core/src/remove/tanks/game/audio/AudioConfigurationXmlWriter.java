package remove.tanks.game.audio;

import com.badlogic.gdx.utils.XmlWriter;
import remove.tanks.game.utility.properties.PropertiesXmlWriter;

import java.io.StringWriter;

/**
 * @author Mateusz Długosz
 */
public final class AudioConfigurationXmlWriter {
    private static final String AUDIO_CONFIGURATION_ELEMENT = "audioConfiguration";

    private final PropertiesXmlWriter propertiesXmlWriter;
    private final AudioConfigurationToPropertiesConverter audioConfigurationToPropertiesConverter;

    public AudioConfigurationXmlWriter(
            PropertiesXmlWriter propertiesXmlWriter,
            AudioConfigurationToPropertiesConverter audioConfigurationToPropertiesConverter
    ) {
        this.propertiesXmlWriter = propertiesXmlWriter;
        this.audioConfigurationToPropertiesConverter = audioConfigurationToPropertiesConverter;
    }

    public String writeAudioConfiguration(AudioConfiguration audioConfiguration) {
        try {
            StringWriter stringWriter = new StringWriter();
            XmlWriter xmlWriter = new XmlWriter(stringWriter);

            xmlWriter.text("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
            xmlWriter.element(AUDIO_CONFIGURATION_ELEMENT);
            xmlWriter.text(propertiesXmlWriter.writeProperties(
                    audioConfigurationToPropertiesConverter.convertAudioConfiguration(audioConfiguration)));
            xmlWriter.pop();
            xmlWriter.close();

            return stringWriter.toString();
        } catch (Exception e) {
            throw new AudioConfigurationXmlWriteException(e);
        }
    }
}
