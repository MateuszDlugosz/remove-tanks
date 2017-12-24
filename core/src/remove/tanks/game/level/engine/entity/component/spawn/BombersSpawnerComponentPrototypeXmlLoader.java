package remove.tanks.game.level.engine.entity.component.spawn;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentPrototypeXmlLoadException;
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
        try {
            return new BombersSpawnerComponentPrototype(
                    loadPrototypeCode(element)
            );
        } catch (Exception e) {
            throw new ComponentPrototypeXmlLoadException(element, e);
        }
    }

    private String loadPrototypeCode(XmlReader.Element element) {
        return element.getChildByName(PROTOTYPE_CODE_ELEMENT).getText().trim();
    }

    @Override
    public ComponentType getLoaderType() {
        return ComponentType.BombersSpawnerComponent;
    }
}
