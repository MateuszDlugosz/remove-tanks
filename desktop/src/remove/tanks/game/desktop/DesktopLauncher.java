package remove.tanks.game.desktop;

import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import remove.tanks.game.GameApplication;
import remove.tanks.game.application.context.ApplicationContext;
import remove.tanks.game.application.context.component.provider.ComponentProviderInitializer;
import remove.tanks.game.application.context.configuration.Configuration;
import remove.tanks.game.application.context.configuration.ConfigurationOption;
import remove.tanks.game.desktop.display.DisplayDimensionResolverXmlReader;

import java.awt.*;
import java.io.File;
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
    private static final String DISPLAY_DIMENSIONS_FILENAME = "/display-dimensions.xml";

    public static void main (String[] arg) {
        configureLoggers();

        Graphics.DisplayMode desktopDisplayMode = LwjglApplicationConfiguration.getDesktopDisplayMode();
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

        config.width = 1280;
        config.height = 720;
        config.fullscreen = false;
        config.resizable = false;
        config.forceExit = true;
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
        Map<String, String> configuration = new HashMap<>();
        Dimension dimension = new DisplayDimensionResolverXmlReader().readDisplayDimensionResolver(
                new File(DesktopLauncher.class.getResource(DISPLAY_DIMENSIONS_FILENAME).getFile()),
                new Dimension(320, 180)
        ).resolveDimension(displayMode);

        configuration.put(ConfigurationOption.GameDisplayWidth.getName(),
                String.valueOf(dimension.getWidth()));
        configuration.put(ConfigurationOption.GameDisplayHeight.getName(),
                String.valueOf(dimension.getHeight()));

        configuration.put(ConfigurationOption.GameComponentConfigurationPackage.getName(),
                "remove.tanks.game.configuration.component");

        configuration.put(ConfigurationOption.GameUIScale.getName(), "2");
        configuration.put(ConfigurationOption.GameWorldScale.getName(), "32");
        configuration.put(ConfigurationOption.GameWorldLightNumberOfRays.getName(), "100");
        configuration.put(ConfigurationOption.GameWorldUpdateTimeStep.getName(), String.valueOf(1f/45f));
        configuration.put(ConfigurationOption.GameWorldUpdatePositionIterations.getName(), "2");
        configuration.put(ConfigurationOption.GameWorldUpdateVelocityIterations.getName(), "6");

        configuration.put(ConfigurationOption.GameLocation.getName(),
                DesktopLauncher.class.getProtectionDomain().getCodeSource().getLocation().toString());
        configuration.put(ConfigurationOption.GameSkinFilename.getName(), "skins/ui-skin.json");
        configuration.put(ConfigurationOption.GameProfileLocalFilename.getName(), "profile.xml");
        configuration.put(ConfigurationOption.GameLocalDataDirectory.getName(), "RemoveTanks");
        configuration.put(ConfigurationOption.GameLocalScreenshotDirectory.getName(), "screenshots");
        configuration.put(ConfigurationOption.GameLocalScreenshotFilePrefix.getName(), "screenshot-");
        configuration.put(ConfigurationOption.GameEmptyConfigurationDirectory.getName(), "data/configuration");
        configuration.put(ConfigurationOption.GameLocalConfigurationDirectory.getName(), "configuration");
        configuration.put(ConfigurationOption.GameAudioConfigurationSoundDirectory.getName(), "sound");
        configuration.put(ConfigurationOption.GameAudioConfigurationMusicDirectory.getName(), "music");
        configuration.put(ConfigurationOption.GamePreferencesFilename.getName(), "RemoveTanks");
        configuration.put(ConfigurationOption.GameDefaultLanguage.getName(), "EN");

        configuration.put(ConfigurationOption.GameLocaleFilename.getName(),
                "locale/locale.xml");
        configuration.put(ConfigurationOption.GameMainAssetPrefabRepositoryFilename.getName(),
                "themes/main-asset-prefab-repository.xml");
        configuration.put(ConfigurationOption.GameTranslationRepositoryFilename.getName(),
                "translations/translation-repository.xml");
        configuration.put(ConfigurationOption.GameFontTTFFilename.getName(),
                "fonts/PressStart2P-Regular.ttf");
        configuration.put(ConfigurationOption.GameProfileEmptyFilename.getName(),
                "data/profile/default-profile.xml");
        configuration.put(ConfigurationOption.GameCampaignPrefabFilenameRepositoryFilename.getName(),
                "prefabs/campaigns/campaigns-prefab-filename-repository.xml");
        configuration.put(ConfigurationOption.GameOperationPrefabFilenameRepositoryFilename.getName(),
                "prefabs/operations/operations-prefab-filename-repository.xml");
        configuration.put(ConfigurationOption.GameArenaPrefabFilenameRepositoryFilename.getName(),
                "prefabs/arenas/arenas-prefab-filename-repository.xml");
        configuration.put(ConfigurationOption.GameAchievementPrefabRepositoryFilename.getName(),
                "achievements/achievement-prefab-repository.xml");
        configuration.put(ConfigurationOption.GameLevelPresenterPrefabFilename.getName(),
                "prefabs/levels/presentations/level-presenter-prefab.xml");

        return new Configuration(configuration);
    }
}
