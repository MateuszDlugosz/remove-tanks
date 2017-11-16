package remove.tanks.game.physics.light;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.graphic.color.ColorPrototype;
import remove.tanks.game.graphic.color.ColorPrototypeXmlLoader;
import remove.tanks.game.utility.position.PositionPrototype;
import remove.tanks.game.utility.position.PositionPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class PointLightPrototypeXmlLoader implements RegistrableLightPrototypeXmlLoader<PointLightPrototype> {
    private static final String DISTANCE_ELEMENT = "distance";
    private static final String X_RAY_ELEMENT = "xRay";

    private final PositionPrototypeXmlLoader positionPrototypeXmlLoader;
    private final ColorPrototypeXmlLoader colorPrototypeXmlLoader;

    public PointLightPrototypeXmlLoader(
            PositionPrototypeXmlLoader positionPrototypeXmlLoader,
            ColorPrototypeXmlLoader colorPrototypeXmlLoader
    ) {
        this.positionPrototypeXmlLoader = positionPrototypeXmlLoader;
        this.colorPrototypeXmlLoader = colorPrototypeXmlLoader;
    }

    @Override
    public PointLightPrototype loadLightPrototype(XmlReader.Element element) {
        try {
            return new PointLightPrototype(
                    loadColorPrototype(element),
                    loadLightPositionPrototype(element),
                    loadDistance(element),
                    loadXRay(element)
            );
        } catch (Exception e) {
            throw new LightPrototypeXmlLoadException(element, e);
        }
    }

    private ColorPrototype loadColorPrototype(XmlReader.Element element) {
        return colorPrototypeXmlLoader.loadColorPrototype(
                element.getChildByName(ColorPrototypeXmlLoader.COLOR_ELEMENT)
        );
    }

    private PositionPrototype loadLightPositionPrototype(XmlReader.Element element) {
        return element.getChildByName(PositionPrototypeXmlLoader.POSITION_ELEMENT) == null
                ? new PositionPrototype(0,0)
                : positionPrototypeXmlLoader.loadPositionPrototype(
                element.getChildByName(PositionPrototypeXmlLoader.POSITION_ELEMENT)
        );
    }

    private float loadDistance(XmlReader.Element element) {
        return Float.valueOf(element.getChildByName(DISTANCE_ELEMENT).getText().trim());
    }

    private boolean loadXRay(XmlReader.Element element) {
        return Boolean.valueOf(element.getChildByName(X_RAY_ELEMENT).getText().trim());
    }

    @Override
    public LightType getLoaderType() {
        return LightType.PointLight;
    }
}
