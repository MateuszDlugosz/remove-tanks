package remove.tanks.game.configuration.component.graphics;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.application.context.configuration.ConfigurationOption;
import remove.tanks.game.graphics.camera.Game2DCamera;
import remove.tanks.game.graphics.camera.effect.CameraEffectFactory;
import remove.tanks.game.graphics.camera.effect.CameraEffectPrefabXmlReader;
import remove.tanks.game.graphics.camera.effect.SubCameraEffectFactory;
import remove.tanks.game.graphics.camera.effect.SubCameraEffectPrefabXmlReader;
import remove.tanks.game.graphics.camera.effect.rotate.ContinuousRotateCameraEffectFactory;
import remove.tanks.game.graphics.camera.effect.rotate.ContinuousRotateCameraEffectPrefabXmlReader;
import remove.tanks.game.graphics.camera.effect.rotate.RotateCameraEffectFactory;
import remove.tanks.game.graphics.camera.effect.rotate.RotateCameraEffectPrefabXmlReader;
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
                    Float.valueOf(getContext().getConfiguration().getOption(ConfigurationOption.GameDisplayWidth.getName())),
                    Float.valueOf(getContext().getConfiguration().getOption(ConfigurationOption.GameDisplayHeight.getName())),
                    getContext().getComponent("WorldScale", Scale.class)
            );
        }
    }

    @ComponentName("UICamera")
    public static final class HudCameraSupplier extends ComponentSupplier<Game2DCamera> {
        @Override
        public Game2DCamera supplyComponent() {
            return create2DCamera(
                    Float.valueOf(getContext().getConfiguration().getOption(ConfigurationOption.GameDisplayWidth.getName())),
                    Float.valueOf(getContext().getConfiguration().getOption(ConfigurationOption.GameDisplayHeight.getName())),
                    getContext().getComponent("UIScale", Scale.class)
            );
        }
    }

    @ComponentName("MenuCamera")
    public static final class MenuCameraSupplier extends ComponentSupplier<Game2DCamera> {
        @Override
        public Game2DCamera supplyComponent() {
            return create2DCamera(
                    Float.valueOf(getContext().getConfiguration().getOption(ConfigurationOption.GameDisplayWidth.getName())),
                    Float.valueOf(getContext().getConfiguration().getOption(ConfigurationOption.GameDisplayHeight.getName())),
                    getContext().getComponent("UIScale", Scale.class)
            );
        }
    }

    private static Game2DCamera create2DCamera(float displayWidth, float displayHeight, Scale scale) {
        OrthographicCamera camera = createOrthographicCamera(displayWidth, displayHeight, scale);
        Viewport viewport = createViewport(displayWidth, displayHeight, scale, camera);
        return new Game2DCamera(camera, viewport);
    }

    private static OrthographicCamera createOrthographicCamera(float width, float height, Scale scale) {
        OrthographicCamera camera = new OrthographicCamera();
        camera.setToOrtho(
                false,
                scale.scaleValue(width),
                scale.scaleValue(height)
        );
        camera.position.set(0,0,0);
        camera.update();
        return camera;
    }

    private static Viewport createViewport(float width, float height, Scale scale, OrthographicCamera camera) {
        return new FitViewport(
                scale.scaleValue(width),
                scale.scaleValue(height),
                camera
        );
    }

    @ComponentName("CameraEffectPrefabXmlReader")
    public static final class CameraEffectPrefabXmlReaderSupplier extends ComponentSupplier<CameraEffectPrefabXmlReader> {
        @Override
        public CameraEffectPrefabXmlReader supplyComponent() {
            return new CameraEffectPrefabXmlReader(
                    new SubCameraEffectPrefabXmlReader[] {
                            new ShakeCameraEffectPrefabXmlReader(),
                            new ContinuousRotateCameraEffectPrefabXmlReader(),
                            new RotateCameraEffectPrefabXmlReader()
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
                            ),
                            new ContinuousRotateCameraEffectFactory(),
                            new RotateCameraEffectFactory()
                    }
            );
        }
    }
}
