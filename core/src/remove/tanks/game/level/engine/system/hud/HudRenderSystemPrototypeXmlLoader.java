package remove.tanks.game.level.engine.system.hud;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.SystemType;
import remove.tanks.game.level.engine.system.hud.stages.HudStagePrototype;
import remove.tanks.game.level.engine.system.hud.stages.HudStagePrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class HudRenderSystemPrototypeXmlLoader
        implements RegistrableEntitySystemPrototypeXmlLoader<HudRenderSystemPrototype>
{
    private final HudStagePrototypeXmlLoader hudStagePrototypeXmlLoader;

    public HudRenderSystemPrototypeXmlLoader(HudStagePrototypeXmlLoader hudStagePrototypeXmlLoader) {
        this.hudStagePrototypeXmlLoader = hudStagePrototypeXmlLoader;
    }

    @Override
    public HudRenderSystemPrototype loadEntitySystemPrototype(XmlReader.Element element, int priority) {
        return new HudRenderSystemPrototype(
                priority,
                loadHudStagePrototype(element)
        );
    }

    private HudStagePrototype loadHudStagePrototype(XmlReader.Element element) {
        return hudStagePrototypeXmlLoader.loadHudStagePrototype(
                element.getChildByName(HudStagePrototypeXmlLoader.STAGE_ELEMENT)
        );
    }

    @Override
    public SystemType getLoaderType() {
        return SystemType.HudRenderSystem;
    }
}
