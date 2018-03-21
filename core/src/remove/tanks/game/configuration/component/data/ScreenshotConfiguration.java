package remove.tanks.game.configuration.component.data;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.application.context.configuration.ConfigurationOption;
import remove.tanks.game.data.screenshot.ScreenshotMaker;
import remove.tanks.game.data.screenshot.ScreenshotTitleGenerator;
import remove.tanks.game.data.screenshot.ScreenshotTitleNanoTimeGenerator;

/**
 * @author Mateusz Długosz
 */
public final class ScreenshotConfiguration {
    @ComponentName("ScreenshotMaker")
    public static final class ScreenshotMakerSupplier extends ComponentSupplier<ScreenshotMaker> {
        @Override
        public ScreenshotMaker supplyComponent() {
            return new ScreenshotMaker(
                    getContext().getComponent("ScreenshotDirectoryFileHandle", FileHandle.class),
                    getContext().getComponent("ScreenshotTitleGenerator", ScreenshotTitleGenerator.class)
            );
        }
    }

    @ComponentName("ScreenshotDirectoryFileHandle")
    public static final class ScreenshotDirectoryFileHandleSupplier extends ComponentSupplier<FileHandle> {
        @Override
        public FileHandle supplyComponent() {
            return Gdx.files.external(
                    getContext().getConfiguration().getOption(ConfigurationOption.GameLocalDataDirectory.getName())
            ).child(getContext().getConfiguration().getOption(ConfigurationOption.GameLocalScreenshotDirectory.getName()));
        }
    }

    @ComponentName("ScreenshotTitleGenerator")
    public static final class ScreenshotTitleGeneratorSupplier extends ComponentSupplier<ScreenshotTitleGenerator> {
        @Override
        public ScreenshotTitleGenerator supplyComponent() {
            return new ScreenshotTitleNanoTimeGenerator(
                    getContext().getConfiguration().getOption(ConfigurationOption.GameLocalScreenshotFilePrefix.getName())
            );
        }
    }
}
