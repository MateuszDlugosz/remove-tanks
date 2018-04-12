package remove.tanks.game.data.profile;

import com.badlogic.gdx.files.FileHandle;
import remove.tanks.game.utility.properties.Properties;
import remove.tanks.game.utility.xml.XmlFormatter;

/**
 * @author Mateusz Długosz
 */
public final class ProfileController {
    private final FileHandle emptyProfile;
    private final FileHandle localProfile;

    private final ProfileScanner profileScanner;
    private final ProfileInitializer profileInitializer;
    private final ProfileXmlReader profileXmlReader;
    private final ProfileXmlWriter profileXmlWriter;
    private final ProfileUpdater profileUpdater;

    private final XmlFormatter xmlFormatter;

    public ProfileController(
            FileHandle emptyProfile,
            FileHandle localProfile,
            ProfileScanner profileScanner,
            ProfileInitializer profileInitializer,
            ProfileXmlReader profileXmlReader,
            ProfileXmlWriter profileXmlWriter,
            ProfileUpdater profileUpdater,
            XmlFormatter xmlFormatter
    ) {
        this.emptyProfile = emptyProfile;
        this.localProfile = localProfile;
        this.profileScanner = profileScanner;
        this.profileInitializer = profileInitializer;
        this.profileXmlReader = profileXmlReader;
        this.profileXmlWriter = profileXmlWriter;
        this.profileUpdater = profileUpdater;
        this.xmlFormatter = xmlFormatter;
    }

    public Profile readProfile() {
        if (!profileScanner.isProfileFileExists(localProfile)) {
            profileInitializer.initializeProfile(emptyProfile, localProfile);
        }
        return profileXmlReader.readProfile(localProfile);
    }

    public void writeProfile(Profile profile, Properties levelProperties) {
        if (!profileScanner.isProfileFileExists(localProfile)) {
            profileInitializer.initializeProfile(emptyProfile, localProfile);
        }
        localProfile.writeString(xmlFormatter.formatXmlString(profileXmlWriter.writeProfile(
                profileUpdater.updateProfile(profile, levelProperties))), false);
    }

    //fixme
    public void resetProfile() {
        if (profileScanner.isProfileFileExists(localProfile)) {
            localProfile.delete();
        }
        profileInitializer.initializeProfile(emptyProfile, localProfile);
    }
}
