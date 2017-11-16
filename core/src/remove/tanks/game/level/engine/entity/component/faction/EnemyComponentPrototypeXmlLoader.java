package remove.tanks.game.level.engine.entity.component.faction;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class EnemyComponentPrototypeXmlLoader
        implements RegistrableComponentPrototypeXmlLoader<EnemyComponentPrototype>
{
    @Override
    public EnemyComponentPrototype loadComponentPrototype(XmlReader.Element element) {
        return new EnemyComponentPrototype();
    }

    @Override
    public ComponentType getLoaderType() {
        return ComponentType.EnemyComponent;
    }
}
