package remove.tanks.game.desktop;

import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import remove.tanks.game.GameApplication;
import remove.tanks.game.application.context.ApplicationContext;
import remove.tanks.game.application.context.component.provider.ComponentProviderInitializer;
import remove.tanks.game.application.context.configuration.Configuration;
import remove.tanks.game.application.context.configuration.ConfigurationOption;
import remove.tanks.game.application.context.configuration.ConfigurationXmlReader;
import remove.tanks.game.desktop.display.DisplayDimensionResolverXmlReader;

import java.awt.*;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/**
 * @author Mateusz Długosz
 */
public final class DesktopLauncher {
    private static final String DISPLAY_DIMENSIONS_FILENAME = "/display-dimensions.xml";
    private static final String CONFIGURATION_FILENAME = "/configuration.xml";

    public static void main (String[] arg) {
        configureLoggers();

        Graphics.DisplayMode desktopDisplayMode = LwjglApplicationConfiguration.getDesktopDisplayMode();
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

        config.width = 1280;
        config.height = 720;
        config.fullscreen = false;
        config.resizable = false;
        config.forceExit = true;
        config.vSyncEnabled = true;
        config.title = String.format("%s - %s", GameApplication.TITLE, GameApplication.VERSION);

        new LwjglApplication(new GameApplication(createConfiguration(desktopDisplayMode)), config);
    }

    private static void configureLoggers() {
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setFormatter(new Formatter() {
            @Override
            public String format(LogRecord record) {
                return "[" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(record.getMillis())) + "] " +
                        "[" + record.getLevel() + "] " +
                        "- " + record.getMessage() + "\r\n";
            }
        });
        Logger.getLogger("").setUseParentHandlers(false);
        Logger.getLogger(ApplicationContext.class.getName()).setUseParentHandlers(false);
        Logger.getLogger(ComponentProviderInitializer.class.getName()).setUseParentHandlers(false);
        Logger.getLogger(ApplicationContext.class.getName()).addHandler(consoleHandler);
        Logger.getLogger(ComponentProviderInitializer.class.getName()).addHandler(consoleHandler);
    }

    private static Configuration createConfiguration(Graphics.DisplayMode displayMode) {
        Configuration configuration = new ConfigurationXmlReader()
                .readConfiguration(new File(DesktopLauncher.class.getResource(CONFIGURATION_FILENAME).getFile()));

        Dimension dimension = new DisplayDimensionResolverXmlReader().readDisplayDimensionResolver(
                new File(DesktopLauncher.class.getResource(DISPLAY_DIMENSIONS_FILENAME).getFile()),
                new Dimension(320, 180)
        ).resolveDimension(displayMode);

        configuration.setOption(ConfigurationOption.GameDisplayWidth.getName(),
                String.valueOf(dimension.getWidth()));
        configuration.setOption(ConfigurationOption.GameDisplayHeight.getName(),
                String.valueOf(dimension.getHeight()));

        return configuration;
    }
}
