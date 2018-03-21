package remove.tanks.game.data.profile;

import com.badlogic.gdx.files.FileHandle;

/**
 * @author Mateusz Długosz
 */
public final class ProfileScanner {
    public boolean isProfileFileExists(FileHandle fileHandle) {
        try {
            return fileHandle.exists();
        } catch (Exception e) {
            throw new ProfileScanningException(e);
        }
    }
}
