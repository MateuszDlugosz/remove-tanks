package remove.tanks.game.constant;

/**
 * @author Mateusz Długosz
 */
public enum TranslationEntryKey {
    GameLevelHudLifes("game.level.hud.lifes"),
    GameLevelHudPoints("game.level.hud.points"),
    GameLevelHudEnemies("game.level.hud.enemies"),
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
    GameScreenButtonBack("game.screen.button.back"),
    GameScreenOperationTitle("game.screen.operation.title"),
    GameScreenOperationSummaryTitle("game.screen.operation.summary.title"),
    GameScreenOperationSummaryCongratulations("game.screen.operation.summary.congratulations"),
    GameOperationEarlyMorning("game.operation.early-morning"),
    GameOperationWetWater("game.operation.wet-water"),
    GameOperationColdWinter("game.operation.cold-winter"),
    GameOperationGreenForest("game.operation.green-forest"),
    GameOperationLateEvening("game.operation.late-evening"),
    GameLevelStatusVictory("game.level.status.victory"),
    GameLevelStatusDefeat("game.level.status.defeat"),
    GameModeOperation("game.mode.operation"),
    GameModeArena("game.mode.arena"),
    GameModeCampaign("game.mode.campaign");

    private final String name;

    TranslationEntryKey(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
