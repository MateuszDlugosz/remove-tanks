package remove.tanks.game.level.engine.system.hud;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.EntitySystemPrototypeXmlLoadException;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.SystemType;
import remove.tanks.game.level.engine.system.hud.stages.HudStagePrototype;
import remove.tanks.game.level.engine.system.hud.stages.HudStagePrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class HudSystemPrototypeXmlLoader
        implements RegistrableEntitySystemPrototypeXmlLoader<HudSystemPrototype>
{
    private final HudStagePrototypeXmlLoader hudStagePrototypeXmlLoader;

    public HudSystemPrototypeXmlLoader(HudStagePrototypeXmlLoader hudStagePrototypeXmlLoader) {
        this.hudStagePrototypeXmlLoader = hudStagePrototypeXmlLoader;
    }

    @Override
    public HudSystemPrototype loadEntitySystemPrototype(XmlReader.Element element, int priority) {
        try {
            return new HudSystemPrototype(
                    priority,
                    loadHudStagePrototype(element)
            );
        } catch (Exception e) {
            throw new EntitySystemPrototypeXmlLoadException(element, e);
        }
    }

    private HudStagePrototype loadHudStagePrototype(XmlReader.Element element) {
        return hudStagePrototypeXmlLoader.loadHudStagePrototype(
                element.getChildByName(HudStagePrototypeXmlLoader.STAGE_ELEMENT)
        );
    }

    @Override
    public SystemType getLoaderType() {
        return SystemType.HudSystem;
    }
}
