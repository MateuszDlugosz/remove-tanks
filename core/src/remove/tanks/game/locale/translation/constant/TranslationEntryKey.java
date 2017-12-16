package remove.tanks.game.locale.translation.constant;

/**
 * @author Mateusz Długosz
 */
public enum TranslationEntryKey {
    GameLevelHudLife("game.level.hud.life"),
    GameLevelHudPoints("game.level.hud.points"),
    GameLevelHudEnemies("game.level.hud.enemies"),
    GameLevelStatusVictory("game.level.status.victory"),
    GameLevelStatusDefeat("game.level.status.defeat"),
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
    GameScreenButtonBack("game.screen.button.back"),
    GameScreenSummaryTitle("game.screen.summary.title"),
    GameScreenSummaryCongratulations("game.screen.summary.congratulations");

    private final String name;

    TranslationEntryKey(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
