package remove.tanks.game.application.context.configuration;

import remove.tanks.game.application.context.ApplicationContext;

/**
 * @author Mateusz Długosz
 */
public enum ConfigurationOption {
    GameWorldScale("game.world.scale"),
    GameWorldUpdateTimeStep("game.world.update.time.step"),
    GameWorldUpdateVelocityIterations("game.world.update.velocity.iterations"),
    GameWorldUpdatePositionIterations("game.world.update.position.iterations"),
    GameWorldLightNumberOfRays("game.number.of.rays"),
    GameUIScale("game.ui.scale"),
    GameDisplayWidth("game.display.width"),
    GameDisplayHeight("game.display.height"),
    GameMainAssetPrefabRepositoryFilename("game.main.asset.prefab.repository.filename"),
    GameEntityPrefabRepositoryFilename("game.entity.prefab.repository.filename"),
    GameTranslationRepositoryFilename("game.translation.repository.filename"),
    GameLocaleFilename("game.locale.filename"),
    GameComponentConfigurationPackage(ApplicationContext.COMPONENT_CONFIGURATION_PACKAGE_OPTION),
    GameLocation("game.location"),
    GameLevelPresenterPrefabFilename("game.level.presenter.prefab.filename"),
    GameSkinFilename("game.skin.filename"),
    GameFontTTFFilename("game.font.ttf.filename"),
    GameProfileEmptyFilename("game.profile.empty.filename"),
    GameProfileLocalFilename("game.profile.player.filename"),
    GameAchievementPrefabRepositoryFilename("game.achievement.prefab.repository.filename"),
    GameLocalDataDirectory("game.local.data.directory"),
    GameLocalScreenshotDirectory("game.local.screenshot.directory"),
    GameLocalScreenshotFilePrefix("game.local.screenshot.file.prefix"),
    GameEmptyConfigurationDirectory("game.empty.configuration.directory"),
    GameLocalConfigurationDirectory("game.local.configuration.directory"),
    GameAudioConfigurationSoundDirectory("game.audio.configuration.sound.directory"),
    GameAudioConfigurationMusicDirectory("game.audio.configuration.music.directory"),
    GamePreferencesFilename("game.preferences.filename"),
    GameDefaultLanguage("game.default.language"),
    GameCampaignPrefabFilenameRepositoryFilename("game.campaign.prefab.filename.repository.filename"),
    GameOperationPrefabFilenameRepositoryFilename("game.operation.prefab.filename.repository.filename");

    private final String name;

    ConfigurationOption(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
