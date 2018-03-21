package remove.tanks.game.data.profile;

import com.badlogic.gdx.files.FileHandle;

/**
 * @author Mateusz Długosz
 */
public final class ProfileInitializer {
    public void initializeProfile(FileHandle emptyProfile, FileHandle localProfile) {
        try {
            emptyProfile.copyTo(localProfile);
        } catch (Exception e) {
            throw new ProfileInitializeException(e);
        }
    }
}
