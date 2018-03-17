package remove.tanks.game.configuration.component.graphics;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.application.context.configuration.ConfigurationOption;
import remove.tanks.game.graphics.camera.Game2DCamera;
import remove.tanks.game.graphics.camera.effect.CameraEffectFactory;
import remove.tanks.game.graphics.camera.effect.CameraEffectPrefabXmlReader;
import remove.tanks.game.graphics.camera.effect.SubCameraEffectFactory;
import remove.tanks.game.graphics.camera.effect.SubCameraEffectPrefabXmlReader;
import remove.tanks.game.graphics.camera.effect.shake.ShakeCameraEffectFactory;
import remove.tanks.game.graphics.camera.effect.shake.ShakeCameraEffectPrefabXmlReader;
import remove.tanks.game.utility.scale.Scale;

import java.util.Random;

/**
 * @author Mateusz Długosz
 */
public final class CameraConfiguration {
    @ComponentName("GameCamera")
    public static final class GameCameraSupplier extends ComponentSupplier<Game2DCamera> {
        @Override
        public Game2DCamera supplyComponent() {
            return create2DCamera(
                    getContext().getComponent("WorldScale", Scale.class)
            );
        }

        private Game2DCamera create2DCamera(Scale worldScale) {
            float displayWidth
                    = Float.valueOf(getContext().getConfiguration().getOption(
                    ConfigurationOption.GameDisplayWidth.getName()));
            float displayHeight
                    = Float.valueOf(getContext().getConfiguration().getOption(
                    ConfigurationOption.GameDisplayHeight.getName()));
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

    @ComponentName("UICamera")
    public static final class HudCameraSupplier extends ComponentSupplier<Game2DCamera> {
        @Override
        public Game2DCamera supplyComponent() {
            OrthographicCamera camera = new OrthographicCamera(
                    Float.valueOf(getContext().getConfiguration().getOption(
                            ConfigurationOption.GameDisplayWidth.getName())),
                    Float.valueOf(getContext().getConfiguration().getOption(
                            ConfigurationOption.GameDisplayHeight.getName()))
            );
            camera.setToOrtho(
                    false,
                    Float.valueOf(getContext().getConfiguration().getOption(
                            ConfigurationOption.GameDisplayWidth.getName())) * 0.5f,
                    Float.valueOf(getContext().getConfiguration().getOption(
                            ConfigurationOption.GameDisplayHeight.getName())) * 0.5f
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
                    Float.valueOf(getContext().getConfiguration().getOption(
                            ConfigurationOption.GameDisplayWidth.getName())),
                    Float.valueOf(getContext().getConfiguration().getOption(
                            ConfigurationOption.GameDisplayHeight.getName()))
            );
            camera.setToOrtho(
                    false,
                    Float.valueOf(getContext().getConfiguration().getOption(
                            ConfigurationOption.GameDisplayWidth.getName())) * 0.5f,
                    Float.valueOf(getContext().getConfiguration().getOption(
                            ConfigurationOption.GameDisplayHeight.getName())) * 0.5f
            );
            Viewport viewport = new ScreenViewport(camera);
            return new Game2DCamera(camera, viewport);
        }
    }

    @ComponentName("CameraEffectPrefabXmlReader")
    public static final class CameraEffectPrefabXmlReaderSupplier extends ComponentSupplier<CameraEffectPrefabXmlReader> {
        @Override
        public CameraEffectPrefabXmlReader supplyComponent() {
            return new CameraEffectPrefabXmlReader(
                    new SubCameraEffectPrefabXmlReader[] {
                            new ShakeCameraEffectPrefabXmlReader()
                    }
            );
        }
    }

    @ComponentName("CameraEffectFactory")
    public static final class CameraEffectFactorySupplier extends ComponentSupplier<CameraEffectFactory> {
        @Override
        public CameraEffectFactory supplyComponent() {
            return new CameraEffectFactory(
                    new SubCameraEffectFactory[] {
                            new ShakeCameraEffectFactory(
                                    getContext().getComponent("Random", Random.class)
                            )
                    }
            );
        }
    }
}
