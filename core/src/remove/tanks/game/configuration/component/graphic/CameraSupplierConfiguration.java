package remove.tanks.game.configuration.component.graphic;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.constant.ConfigurationKey;
import remove.tanks.game.graphic.camera.Game2DCamera;
import remove.tanks.game.utility.scale.Scale;

/**
 * @author Mateusz Długosz
 */
public final class CameraSupplierConfiguration {
    @ComponentName("GameCamera")
    public static final class GameCameraSupplier extends ComponentSupplier<Game2DCamera> {
        @Override
        public Game2DCamera supplyComponent() {
            return create2DCamera(
                    getContext().getComponent("DisplayScale", Scale.class),
                    getContext().getComponent("WorldScale", Scale.class)
            );
        }

        private Game2DCamera create2DCamera(Scale displayScale, Scale worldScale) {
            float displayWidth
                    = displayScale.scaleValue(Float.valueOf(getContext().getConfiguration().getOption(
                    ConfigurationKey.GameDisplayWidth.getKey())));
            float displayHeight
                    = displayScale.scaleValue(Float.valueOf(getContext().getConfiguration().getOption(
                    ConfigurationKey.GameDisplayHeight.getKey())));
            OrthographicCamera camera = createOrthographicCamera(displayWidth, displayHeight, worldScale);
            Viewport viewport = createViewport(displayWidth, displayHeight, worldScale, camera);
            return new Game2DCamera(camera, viewport);
        }

        private OrthographicCamera createOrthographicCamera(float width, float height, Scale worldScale) {
            OrthographicCamera camera = new OrthographicCamera();
            camera.setToOrtho(
                    false,
                    worldScale.scaleValue(width),
                    worldScale.scaleValue(height)
            );
            camera.position.set(0,0,0);
            camera.update();
            return camera;
        }

        private Viewport createViewport(float width, float height, Scale worldScale, OrthographicCamera camera) {
            return new FitViewport(
                    worldScale.scaleValue(width),
                    worldScale.scaleValue(height),
                    camera
            );
        }
    }

    @ComponentName("HudCamera")
    public static final class HudCameraSupplier extends ComponentSupplier<Game2DCamera> {
        @Override
        public Game2DCamera supplyComponent() {
            OrthographicCamera camera = new OrthographicCamera(
                    Float.valueOf(getContext().getConfiguration().getOption(ConfigurationKey.GameDisplayWidth.getKey())),
                    Float.valueOf(getContext().getConfiguration().getOption(ConfigurationKey.GameDisplayHeight.getKey()))
            );
            camera.setToOrtho(
                    false,
                    Float.valueOf(getContext().getConfiguration().getOption(ConfigurationKey.GameDisplayWidth.getKey())) * 0.5f,
                    Float.valueOf(getContext().getConfiguration().getOption(ConfigurationKey.GameDisplayHeight.getKey())) * 0.5f
            );
            Viewport viewport = new ScreenViewport(camera);
            return new Game2DCamera(camera, viewport);
        }
    }

    @ComponentName("MenuCamera")
    public static final class MenuCameraSupplier extends ComponentSupplier<Game2DCamera> {
        @Override
        public Game2DCamera supplyComponent() {
            OrthographicCamera camera = new OrthographicCamera(
                    Float.valueOf(getContext().getConfiguration().getOption(ConfigurationKey.GameDisplayWidth.getKey())),
                    Float.valueOf(getContext().getConfiguration().getOption(ConfigurationKey.GameDisplayHeight.getKey()))
            );
            camera.setToOrtho(
                    false,
                    Float.valueOf(getContext().getConfiguration().getOption(ConfigurationKey.GameDisplayWidth.getKey())) * 0.5f,
                    Float.valueOf(getContext().getConfiguration().getOption(ConfigurationKey.GameDisplayHeight.getKey())) * 0.5f
            );
            Viewport viewport = new ScreenViewport(camera);
            return new Game2DCamera(camera, viewport);
        }
    }
}
