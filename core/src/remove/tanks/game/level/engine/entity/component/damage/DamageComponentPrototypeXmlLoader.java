package remove.tanks.game.level.engine.entity.component.damage;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class DamageComponentPrototypeXmlLoader
        implements RegistrableComponentPrototypeXmlLoader<DamageComponentPrototype>
{
    private static final String DAMAGE_ELEMENT = "damage";

    @Override
    public DamageComponentPrototype loadComponentPrototype(XmlReader.Element element) {
        return new DamageComponentPrototype(
                Integer.valueOf(element.getChildByName(DAMAGE_ELEMENT).getText().trim())
        );
    }

    @Override
    public ComponentType getLoaderType() {
        return ComponentType.DamageComponent;
    }
}
