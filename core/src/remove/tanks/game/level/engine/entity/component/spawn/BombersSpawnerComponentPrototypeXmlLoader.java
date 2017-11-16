package remove.tanks.game.level.engine.entity.component.spawn;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class BombersSpawnerComponentPrototypeXmlLoader
        implements RegistrableComponentPrototypeXmlLoader<BombersSpawnerComponentPrototype>
{
    private static final String PROTOTYPE_CODE_ELEMENT = "prototypeCode";

    @Override
    public BombersSpawnerComponentPrototype loadComponentPrototype(XmlReader.Element element) {
        return new BombersSpawnerComponentPrototype(
                element.getChildByName(PROTOTYPE_CODE_ELEMENT).getText().trim()
        );
    }

    @Override
    public ComponentType getLoaderType() {
        return ComponentType.BombersSpawnerComponent;
    }
}
