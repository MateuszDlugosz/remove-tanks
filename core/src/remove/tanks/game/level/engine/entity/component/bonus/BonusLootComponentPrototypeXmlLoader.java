package remove.tanks.game.level.engine.entity.component.bonus;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentPrototypeXmlLoadException;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class BonusLootComponentPrototypeXmlLoader
        implements RegistrableComponentPrototypeXmlLoader<BonusLootComponentPrototype>
{
    @Override
    public BonusLootComponentPrototype loadComponentPrototype(XmlReader.Element element) {
        try {
            return new BonusLootComponentPrototype();
        } catch (Exception e) {
            throw new ComponentPrototypeXmlLoadException(element, e);
        }
    }

    @Override
    public ComponentType getLoaderType() {
        return ComponentType.BonusLootComponent;
    }
}
