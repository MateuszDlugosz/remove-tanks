package remove.tanks.game.screen.gui.button;

import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import remove.tanks.game.screen.gui.listener.KeyListener;

import java.util.Optional;

/**
 * @author Mateusz Długosz
 */
public class Button extends TextButton {
    private boolean locked;
    private KeyListener keyListener;

    public Button(String text, Skin skin) {
        super(text, skin);
        this.locked = false;
        setTouchable(Touchable.disabled);
    }

    public void activate() {
        setChecked(true);
    }

    public void deactivate() {
        setChecked(false);
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public void setKeyListener(KeyListener keyListener) {
        this.keyListener = keyListener;
    }

    public Optional<KeyListener> getKeyListener() {
        KeyListener listener = locked ? null : keyListener;
        return Optional.ofNullable(listener);
    }
}
