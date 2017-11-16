package remove.tanks.game.level.engine.entity.component.bonus;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class BonusComponentPrototypeXmlLoader
        implements RegistrableComponentPrototypeXmlLoader<BonusComponentPrototype>
{
    private static final String BONUS_TYPE_ELEMENT = "bonusType";

    @Override
    public BonusComponentPrototype loadComponentPrototype(XmlReader.Element element) {
        return new BonusComponentPrototype(
                BonusType.valueOf(element.getChildByName(BONUS_TYPE_ELEMENT).getText().trim())
        );
    }

    @Override
    public ComponentType getLoaderType() {
        return ComponentType.BonusComponent;
    }
}
