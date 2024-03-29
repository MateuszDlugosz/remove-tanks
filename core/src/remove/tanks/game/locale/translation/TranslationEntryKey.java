package remove.tanks.game.locale.translation;

/**
 * @author Mateusz Długosz
 */
public enum TranslationEntryKey {
    Simple("test"),
    GameLevelHudLife("game.level.hud.life"),
    GameLevelHudPoints("game.level.hud.points"),
    GameLevelHudEnemiesLeft("game.level.hud.enemies.left"),
    GameLevelHudPointsMultiplier("game.level.hud.points-multiplier"),
    GameLevelHudTimeLeft("game.level.hud.time-left"),

    GameScreenMainMenuButtonStart("game.screen.main.menu.button.start"),
    GameScreenMainMenuButtonOptions("game.screen.main.menu.button.options"),
    GameScreenMainMenuButtonCredits("game.screen.main.menu.button.credits"),
    GameScreenMainMenuButtonProfile("game.screen.main.menu.button.profile"),
    GameScreenMainMenuButtonExit("game.screen.main.menu.button.exit"),

    GameScreenOptionsTitle("game.screen.options.title"),
    GameScreenOptionsButtonLanguage("game.screen.options.button.language"),
    GameScreenOptionsButtonSoundEffectVolume("game.screen.options.button.sound.effect.volume"),
    GameScreenOptionsButtonSoundUIEffectVolume("game.screen.options.button.sound.ui.effect.volume"),
    GameScreenOptionsButtonMusicVolume("game.screen.options.button.music.volume"),

    GameScreenProfileTitle("game.screen.profile.title"),
    GameScreenProfileLabelProfilePoints("game.screen.profile.label.profile.points"),
    GameScreenProfileLabelProfileVersion("game.screen.profile.label.profile.version"),
    GameScreenProfileLabelProfileDestroyedEnemies("game.screen.profile.label.profile.destroyed.enemies"),
    GameScreenProfileLabelProfileMapsEnded("game.screen.profile.label.profile.maps.ended"),

    GameScreenCreditsTitle("game.screen.credits.title"),
    GameScreenCreditsContent0("game.screen.credits.content.0"),

    GameScreenSummaryTitle("game.screen.summary.title"),
    GameScreenSummaryContent("game.screen.summary.content"),

    GameScreenPauseTitle("game.screen.pause.title"),
    GameScreenPauseContent("game.screen.pause.content"),

    GameScreenModeSelectTitle("game.screen.mode.select.title"),
    GameScreenModeSelectButtonArena("game.screen.mode.select.button.arena"),
    GameScreenModeSelectButtonOperation("game.screen.mode.select.button.operation"),
    GameScreenModeSelectButtonCampaign("game.screen.mode.select.button.campaign"),

    GameScreenOperationSelectTitle("game.screen.operation.select.title"),

    GameLevelSequenceTitleTemplate("game.level.sequence.title.%s"),

    GameScreenButtonYes("game.screen.button.yes"),
    GameScreenButtonNo("game.screen.button.no"),
    GameScreenButtonBack("game.screen.button.back"),

    GameLevelMessage("game.level.message.%s"),;

    private final String name;

    TranslationEntryKey(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
