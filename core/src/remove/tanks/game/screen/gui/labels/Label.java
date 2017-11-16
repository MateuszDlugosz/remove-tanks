package remove.tanks.game.screen.gui.labels;

import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

/**
 * @author Mateusz Długosz
 */
public final class Label extends TextButton {
    private static final String BEFORE_TEXT = "- ";
    private static final String AFTER_TEXT = " -";

    public Label(String text, Skin skin) {
        super(BEFORE_TEXT + text + AFTER_TEXT, skin);
        this.setTouchable(Touchable.disabled);
    }

    @Override
    public void setText(String text) {
        super.setText(BEFORE_TEXT + text + AFTER_TEXT);
    }
}
