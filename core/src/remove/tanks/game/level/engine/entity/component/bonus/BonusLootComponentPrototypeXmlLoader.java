package remove.tanks.game.level.engine.entity.component.bonus;

import com.badlogic.gdx.utils.XmlReader;
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
        return new BonusLootComponentPrototype();
    }

    @Override
    public ComponentType getLoaderType() {
        return ComponentType.BonusLootComponent;
    }
}
