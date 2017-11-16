package remove.tanks.game.level.engine.entity.component.spawn;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.entity.component.ComponentType;
import remove.tanks.game.level.engine.entity.component.RegistrableComponentPrototypeXmlLoader;
import remove.tanks.game.level.engine.utility.letter.NATOLetter;

/**
 * @author Mateusz Długosz
 */
public final class AutoSpawnerComponentPrototypeXmlLoader
        implements RegistrableComponentPrototypeXmlLoader<AutoSpawnerComponentPrototype>
{
    private static final String LETTER_ELEMENT = "letter";

    @Override
    public AutoSpawnerComponentPrototype loadComponentPrototype(XmlReader.Element element) {
        return new AutoSpawnerComponentPrototype(
                NATOLetter.valueOf(element.getChildByName(LETTER_ELEMENT).getText().trim())
        );
    }

    @Override
    public ComponentType getLoaderType() {
        return ComponentType.AutoSpawnerComponent;
    }
}
