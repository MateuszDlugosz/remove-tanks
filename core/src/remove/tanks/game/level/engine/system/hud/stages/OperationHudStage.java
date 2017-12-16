package remove.tanks.game.level.engine.system.hud.stages;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Disposable;
import remove.tanks.game.graphic.camera.Game2DCamera;
import remove.tanks.game.level.constant.LevelProperty;
import remove.tanks.game.locale.Locale;
import remove.tanks.game.locale.translation.constant.TranslationEntryKey;
import remove.tanks.game.utility.properties.Properties;

/**
 * @author Mateusz Długosz
 */
public final class OperationHudStage implements Disposable {
    private final Locale locale;

    private Label lifesLabelText;
    private Label enemiesLabelText;
    private Label pointsLabelText;
    private Label lifeLabelValue;
    private Label enemiesLabelValue;
    private Label pointsLabelValue;

    private final Stage stage;
    private final Table table;

    public OperationHudStage(
            Locale locale,
            Game2DCamera game2DCamera,
            SpriteBatch spriteBatch,
            Skin skin
    ) {
        this.locale = locale;
        this.stage = new Stage(game2DCamera.getViewport(), spriteBatch);
        this.table = new Table();
        initLabels(skin);
        initLayout();
    }

    private void initLabels(Skin skin) {
        lifesLabelText = new Label(locale.getTranslation().getEntry(
                TranslationEntryKey.GameLevelHudLife.getName()), skin);
        enemiesLabelText = new Label(locale.getTranslation().getEntry(
                TranslationEntryKey.GameLevelHudEnemies.getName()), skin);
        pointsLabelText = new Label(locale.getTranslation().getEntry(
                TranslationEntryKey.GameLevelHudPoints.getName()), skin);
        lifeLabelValue = new Label("", skin);
        enemiesLabelValue = new Label("", skin);
        pointsLabelValue = new Label("", skin);
    }

    private void initLayout() {
        table.setFillParent(true);
        table.top();
        table.row().padTop(20);
        table.add(lifesLabelText).expandX();
        table.add(enemiesLabelText).expandX();
        table.add(pointsLabelText).expandX();
        table.row().padTop(20);
        table.add(lifeLabelValue).expandX();
        table.add(enemiesLabelValue).expandX();
        table.add(pointsLabelValue).expandX();
        table.setDebug(false);
        stage.addActor(table);
    }

    public void updateLabelValues(Properties properties) {
        pointsLabelText.setText(locale.getTranslation().getFormattedEntry(
                TranslationEntryKey.GameLevelHudPoints.getName(),
                properties.getString(LevelProperty.LevelPointsMultiplier.getName())).toUpperCase());
        lifesLabelText.setText(locale.getTranslation().getEntry(
                TranslationEntryKey.GameLevelHudLife.getName()).toUpperCase());
        enemiesLabelText.setText(locale.getTranslation().getFormattedEntry(
                TranslationEntryKey.GameLevelHudEnemies.getName()).toUpperCase());
        lifeLabelValue.setText(
                properties.getString(LevelProperty.LevelLifes.getName()));
        enemiesLabelValue.setText(
                properties.getString(LevelProperty.LevelEnemies.getName()));
        pointsLabelValue.setText(
                properties.getString(LevelProperty.LevelPoints.getName()));
    }

    public Stage getStage() {
        return stage;
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
