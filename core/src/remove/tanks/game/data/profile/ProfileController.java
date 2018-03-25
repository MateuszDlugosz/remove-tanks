package remove.tanks.game.data.profile;

import com.badlogic.gdx.files.FileHandle;
import remove.tanks.game.utility.properties.Properties;

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

    public ProfileController(
            FileHandle emptyProfile,
            FileHandle localProfile,
            ProfileScanner profileScanner,
            ProfileInitializer profileInitializer,
            ProfileXmlReader profileXmlReader,
            ProfileXmlWriter profileXmlWriter,
            ProfileUpdater profileUpdater
    ) {
        this.emptyProfile = emptyProfile;
        this.localProfile = localProfile;
        this.profileScanner = profileScanner;
        this.profileInitializer = profileInitializer;
        this.profileXmlReader = profileXmlReader;
        this.profileXmlWriter = profileXmlWriter;
        this.profileUpdater = profileUpdater;
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
        localProfile.writeString(profileXmlWriter.writeProfile(
                profileUpdater.updateProfile(profile, levelProperties)), false);
    }

    public void resetProfile() {
        if (profileScanner.isProfileFileExists(localProfile)) {
            localProfile.delete();
        }
        profileInitializer.initializeProfile(emptyProfile, localProfile);
    }
}
