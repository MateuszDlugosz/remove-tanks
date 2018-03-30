package remove.tanks.game.level.mode.campaign;

import com.badlogic.gdx.files.FileHandle;

/**
 * @author Mateusz Długosz
 */
public final class CampaignPrefabXmlReadException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Cannot read campaign prefab from file %s.";

    public CampaignPrefabXmlReadException(FileHandle fileHandle, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, fileHandle), cause);
    }
}
