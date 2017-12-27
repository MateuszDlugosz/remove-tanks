package remove.tanks.game.locale.translation.constant;

/**
 * @author Mateusz Długosz
 */
public enum TranslationEntryKey {
    GameLevelHudLife("game.level.hud.life"),
    GameLevelHudPoints("game.level.hud.points"),
    GameLevelHudEnemies("game.level.hud.enemies"),
    GameLevelHudPointsMultiplier("game.level.hud.points-multiplier"),
    GameLevelStateVictory("game.level.state.victory"),
    GameLevelStateDefeat("game.level.state.defeat"),
    GameLevelStatePlaying("game.level.state.playing"),
    GameLevelStateEnd("game.level.state.end"),
    GameCampaignName("game.campaign.%s"),
    GameModeCampaign("game.mode.campaign"),
    GameScreenMainMenuButtonStart("game.screen.main.menu.button.start"),
    GameScreenMainMenuButtonOptions("game.screen.main.menu.button.options"),
    GameScreenMainMenuButtonCredits("game.screen.main.menu.button.credits"),
    GameScreenMainMenuButtonExit("game.screen.main.menu.button.exit"),
    GameScreenOptionsTitle("game.screen.options.title"),
    GameScreenOptionsButtonLanguage("game.screen.options.button.language"),
    GameScreenOptionsButtonSoundVolume("game.screen.options.button.sound.volume"),
    GameScreenOptionsButtonMusicVolume("game.screen.options.button.music.volume"),
    GameScreenCreditsTitle("game.screen.credits.title"),
    GameScreenCreditsContent("game.screen.credits.content"),
    GameScreenModeSelectTitle("game.screen.mode.select.title"),
    GameScreenCampaignTitle("game.screen.campaign.title"),
    GameScreenSummaryTitle("game.screen.summary.title"),
    GameScreenSummaryCongratulations("game.screen.summary.congratulations"),
    GameScreenPauseTitle("game.screen.pause.title"),
    GameScreenPauseContent("game.screen.pause.content"),
    GameScreenButtonYes("game.screen.button.yes"),
    GameScreenButtonNo("game.screen.button.no"),
    GameScreenButtonBack("game.screen.button.back"),
    GameMessageTest("game.message-test");

    private final String name;

    TranslationEntryKey(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
