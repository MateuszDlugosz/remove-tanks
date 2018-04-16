package remove.tanks.game.desktop.display;

import com.badlogic.gdx.Graphics;

import java.awt.*;
import java.util.Map;

/**
 * @author Mateusz Długosz
 */
public final class DisplayDimensionResolver {
    private final Dimension defaultDimension;
    private final Map<Double, Dimension> dimensionMap;

    public DisplayDimensionResolver(Dimension defaultDimension, Map<Double, Dimension> dimensionMap) {
        this.defaultDimension = defaultDimension;
        this.dimensionMap = dimensionMap;
    }

    public Dimension resolveDimension(Graphics.DisplayMode displayMode) {
        try {
            double ratio = (double) displayMode.width / (double) displayMode.height;
            if (dimensionMap.containsKey(ratio)) {
                return  dimensionMap.get(ratio);
            }
            return defaultDimension;
        } catch (Exception e) {
            throw new DisplayDimensionResolveException(displayMode, e);
        }
    }
}
