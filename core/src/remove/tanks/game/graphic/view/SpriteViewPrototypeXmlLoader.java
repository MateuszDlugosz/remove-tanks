package remove.tanks.game.graphic.view;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.graphic.sprite.SpritePrototype;
import remove.tanks.game.graphic.sprite.SpritePrototypeXmlLoader;
import remove.tanks.game.utility.position.PositionPrototype;
import remove.tanks.game.utility.position.PositionPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class SpriteViewPrototypeXmlLoader
        implements RegistrableViewPrototypeXmlLoader<SpriteViewPrototype>
{
    private static final String ID_ATTRIBUTE = "id";

    private final PositionPrototypeXmlLoader positionPrototypeXmlLoader;
    private final SpritePrototypeXmlLoader spritePrototypeXmlLoader;

    public SpriteViewPrototypeXmlLoader(
            PositionPrototypeXmlLoader positionPrototypeXmlLoader,
            SpritePrototypeXmlLoader spritePrototypeXmlLoader
    ) {
        this.positionPrototypeXmlLoader = positionPrototypeXmlLoader;
        this.spritePrototypeXmlLoader = spritePrototypeXmlLoader;
    }

    @Override
    public SpriteViewPrototype loadViewPrototype(XmlReader.Element element) {
        try {
            return new SpriteViewPrototype(
                    loadId(element),
                    loadViewPositionPrototype(element),
                    loadSpritePrototype(element)
            );
        } catch (Exception e) {
            throw new ViewPrototypeXmlLoadException(element, e);
        }
    }

    private String loadId(XmlReader.Element element) {
        return element.getAttribute(ID_ATTRIBUTE);
    }

    private PositionPrototype loadViewPositionPrototype(XmlReader.Element element) {
        return element.getChildByName(PositionPrototypeXmlLoader.POSITION_ELEMENT) == null
                ? new PositionPrototype(0,0)
                : positionPrototypeXmlLoader.loadPositionPrototype(
                element.getChildByName(PositionPrototypeXmlLoader.POSITION_ELEMENT)
        );
    }

    private SpritePrototype loadSpritePrototype(XmlReader.Element element) {
        return spritePrototypeXmlLoader.loadSpritePrototype(
                element.getChildByName(SpritePrototypeXmlLoader.SPRITE_ELEMENT)
        );
    }

    @Override
    public ViewType getLoaderType() {
        return ViewType.SpriteView;
    }
}
