package remove.tanks.game.screen.gui.buttons;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;

/**
 * @author Mateusz Długosz
 */
public final class HorizontalButton extends Button {
    public static final String TEXT_TEMPLATE = "< %s >";

    public HorizontalButton(String text, Skin skin) {
        super(String.format(TEXT_TEMPLATE, text), skin);
    }

    @Override
    public void setText(String text) {
        super.setText(String.format(TEXT_TEMPLATE, text));
    }
}
