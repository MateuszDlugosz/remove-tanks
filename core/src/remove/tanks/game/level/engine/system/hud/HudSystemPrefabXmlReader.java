package remove.tanks.game.level.engine.system.hud;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.EntitySystemPrefabXmlReadException;
import remove.tanks.game.level.engine.system.SubEntitySystemPrefabXmlReader;
import remove.tanks.game.level.engine.system.SystemType;
import remove.tanks.game.level.utility.stage.HudStagePrefab;
import remove.tanks.game.level.utility.stage.HudStagePrefabXmlReader;

/**
 * @author Mateusz Długosz
 */
public final class HudSystemPrefabXmlReader implements SubEntitySystemPrefabXmlReader<HudSystemPrefab> {
    private final HudStagePrefabXmlReader hudStagePrefabXmlReader;

    public HudSystemPrefabXmlReader(HudStagePrefabXmlReader hudStagePrefabXmlReader) {
        this.hudStagePrefabXmlReader = hudStagePrefabXmlReader;
    }

    @Override
    public HudSystemPrefab readEntitySystemPrefab(XmlReader.Element element, int priority) {
        try {
            return new HudSystemPrefab(
                    priority,
                    readHudStagePrefab(element)
            );
        } catch (Exception e) {
            throw new EntitySystemPrefabXmlReadException(element, e);
        }
    }

    private HudStagePrefab readHudStagePrefab(XmlReader.Element element) {
        return hudStagePrefabXmlReader.readHudStagePrefab(
                element.getChildByName(HudStagePrefabXmlReader.STAGE_ELEMENT)
        );
    }

    @Override
    public SystemType getReaderType() {
        return SystemType.HudSystem;
    }
}