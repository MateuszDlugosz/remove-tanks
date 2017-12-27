package remove.tanks.game.level.engine.system.hud.stages;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.hud.stages.broker.MessageBarPrototype;
import remove.tanks.game.level.engine.system.hud.stages.broker.MessageBarPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.hud.stages.state.StateBarPrototype;
import remove.tanks.game.level.engine.system.hud.stages.state.StateBarPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.hud.stages.widget.WidgetPrototype;
import remove.tanks.game.level.engine.system.hud.stages.widget.WidgetPrototypeXmlLoader;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class HudStagePrototypeXmlLoader {
    public static final String STAGE_ELEMENT = "stage";

    private final WidgetPrototypeXmlLoader widgetPrototypeXmlLoader;
    private final StateBarPrototypeXmlLoader stateBarPrototypeXmlLoader;
    private final MessageBarPrototypeXmlLoader messageBarPrototypeXmlLoader;

    public HudStagePrototypeXmlLoader(
            WidgetPrototypeXmlLoader widgetPrototypeXmlLoader,
            StateBarPrototypeXmlLoader stateBarPrototypeXmlLoader,
            MessageBarPrototypeXmlLoader messageBarPrototypeXmlLoader
    ) {
        this.widgetPrototypeXmlLoader = widgetPrototypeXmlLoader;
        this.stateBarPrototypeXmlLoader = stateBarPrototypeXmlLoader;
        this.messageBarPrototypeXmlLoader = messageBarPrototypeXmlLoader;
    }

    public HudStagePrototype loadHudStagePrototype(XmlReader.Element element) {
        try {
            return new HudStagePrototype(
                    loadWidgetPrototypes(element),
                    loadStateBarPrototype(element),
                    loadMessageBarPrototype(element)
            );
        } catch (Exception e) {
            throw new HudStagePrototypeXmlLoadException(element, e);
        }
    }

    private List<WidgetPrototype> loadWidgetPrototypes(XmlReader.Element element) {
        return widgetPrototypeXmlLoader.loadWidgetPrototypes(
                element.getChildByName(WidgetPrototypeXmlLoader.WIDGETS_ELEMENT)
        );
    }

    private StateBarPrototype loadStateBarPrototype(XmlReader.Element element) {
        return stateBarPrototypeXmlLoader.loadStateBarPrototype(
                element.getChildByName(StateBarPrototypeXmlLoader.STATE_BAR_ELEMENT)
        );
    }

    private MessageBarPrototype loadMessageBarPrototype(XmlReader.Element element) {
        return messageBarPrototypeXmlLoader.loadMessageBarPrototype(
                element.getChildByName(MessageBarPrototypeXmlLoader.MESSAGE_BAR_ELEMENT)
        );
    }
}
