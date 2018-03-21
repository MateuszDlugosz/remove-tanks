package remove.tanks.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import remove.tanks.game.GameApplication;
import remove.tanks.game.application.context.ApplicationContext;
import remove.tanks.game.application.context.component.provider.ComponentProviderInitializer;
import remove.tanks.game.application.context.configuration.Configuration;
import remove.tanks.game.application.context.configuration.ConfigurationOption;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/**
 * @author Mateusz Długosz
 */
public final class DesktopLauncher {
    public static void main (String[] arg) {
        configureLoggers();

        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = 1280;
        config.height = 720;
        config.fullscreen = false;
        config.resizable = false;
        config.forceExit = true;
        config.title = GameApplication.TITLE + " - " + GameApplication.VERSION;

        new LwjglApplication(new GameApplication(createConfiguration()), config);
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

    private static Configuration createConfiguration() {
        Map<String, String> configuration = new HashMap<>();
        configuration.put(ConfigurationOption.GameComponentConfigurationPackage.getName(),
                "remove.tanks.game.configuration.component");
        configuration.put(ConfigurationOption.GameMainAssetPrefabRepositoryFilename.getName(),
                "themes/main-asset-prefab-repository.xml");
        configuration.put(ConfigurationOption.GameTranslationRepositoryFilename.getName(),
                "translations/translation-repository.xml");
        configuration.put(ConfigurationOption.GameLocaleFilename.getName(), "locale/locale.xml");
        configuration.put(ConfigurationOption.GameWorldScale.getName(), "32");
        configuration.put(ConfigurationOption.GameWorldLightNumberOfRays.getName(), "100");
        configuration.put(ConfigurationOption.GameUIScale.getName(), "2");
        configuration.put(ConfigurationOption.GameWorldUpdateTimeStep.getName(), String.valueOf(1f/45f));
        configuration.put(ConfigurationOption.GameWorldUpdatePositionIterations.getName(), "2");
        configuration.put(ConfigurationOption.GameWorldUpdateVelocityIterations.getName(), "6");
        configuration.put(ConfigurationOption.GameDisplayWidth.getName(), "320");
        configuration.put(ConfigurationOption.GameDisplayHeight.getName(), "175");
        configuration.put(ConfigurationOption.GameLocation.getName(),
                DesktopLauncher.class.getProtectionDomain().getCodeSource().getLocation().toString());
        configuration.put(ConfigurationOption.GameLevelPresenterPrefabFilename.getName(),
                "prefabs/levels/presentations/level-presenter-prefab.xml");
        configuration.put(ConfigurationOption.GameSkinFilename.getName(), "skins/ui-skin.json");
        configuration.put(ConfigurationOption.GameFontTTFFilename.getName(), "fonts/PressStart2P-Regular.ttf");
        configuration.put(ConfigurationOption.GameProfileEmptyFilename.getName(), "profile/empty-profile.xml");
        configuration.put(ConfigurationOption.GameAchievementPrefabRepositoryFilename.getName(), "achievements/achievement-prefab-repository.xml");
        configuration.put(ConfigurationOption.GameProfileLocalFilename.getName(), "profile.xml");
        configuration.put(ConfigurationOption.GameLocalDataDirectory.getName(), "RemoveTanks");
        configuration.put(ConfigurationOption.GameLocalScreenshotDirectory.getName(), "screenshots");
        configuration.put(ConfigurationOption.GameLocalScreenshotFilePrefix.getName(), "screenshot-");

        return new Configuration(configuration);
    }
}
