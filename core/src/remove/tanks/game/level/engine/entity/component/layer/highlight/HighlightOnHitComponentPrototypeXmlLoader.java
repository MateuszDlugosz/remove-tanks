package remove.tanks.game.level.engine.entity.component.layer.highlight;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class HighlightOnHitComponentPrototypeXmlLoader
        implements RegistrableComponentPrototypeXmlLoader<HighlightOnHitComponentPrototype>
{
    @Override
    public HighlightOnHitComponentPrototype loadComponentPrototype(XmlReader.Element element) {
        return new HighlightOnHitComponentPrototype();
    }

    @Override
    public ComponentType getLoaderType() {
        return ComponentType.HighlightOnHitComponent;
    }
}
