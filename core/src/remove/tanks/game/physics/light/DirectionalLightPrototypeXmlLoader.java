package remove.tanks.game.physics.light;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.graphic.color.ColorPrototype;
import remove.tanks.game.graphic.color.ColorPrototypeXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class DirectionalLightPrototypeXmlLoader implements RegistrableLightPrototypeXmlLoader<DirectionalLightPrototype> {
    private static final String DIRECTION_DEGREE_ELEMENT = "directionDegree";
    private static final String X_RAY_ELEMENT = "xRay";

    private final ColorPrototypeXmlLoader colorPrototypeXmlLoader;

    public DirectionalLightPrototypeXmlLoader(ColorPrototypeXmlLoader colorPrototypeXmlLoader) {
        this.colorPrototypeXmlLoader = colorPrototypeXmlLoader;
    }

    @Override
    public DirectionalLightPrototype loadLightPrototype(XmlReader.Element element) {
        try {
            return new DirectionalLightPrototype(
                    loadColorPrototype(element),
                    loadDirectionDegree(element),
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

    private float loadDirectionDegree(XmlReader.Element element) {
        return Float.valueOf(element.getChildByName(DIRECTION_DEGREE_ELEMENT).getText().trim());
    }

    private boolean loadXRay(XmlReader.Element element) {
        return Boolean.valueOf(element.getChildByName(X_RAY_ELEMENT).getText().trim());
    }

    @Override
    public LightType getLoaderType() {
        return LightType.DirectionalLight;
    }
}
