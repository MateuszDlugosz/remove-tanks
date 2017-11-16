package remove.tanks.game.level.engine.system.damage;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.level.engine.system.RegistrableEntitySystemPrototypeXmlLoader;
import remove.tanks.game.level.engine.system.SystemType;

/**
 * @author Mateusz Długosz
 */
public final class DamageSystemPrototypeXmlLoader
        extends RegistrableEntitySystemPrototypeXmlLoader<DamageSystemPrototype>
{
    private static final String HIT_HIGHLIGHT_TIME = "hitHighlightTime";

    @Override
    protected DamageSystemPrototype loadEntitySystemPrototype(XmlReader.Element element, int priority) {
        return new DamageSystemPrototype(
                Float.valueOf(element.getChildByName(HIT_HIGHLIGHT_TIME).getText().trim()),
                priority
        );
    }

    @Override
    public SystemType getLoaderType() {
        return SystemType.DamageSystem;
    }
}
