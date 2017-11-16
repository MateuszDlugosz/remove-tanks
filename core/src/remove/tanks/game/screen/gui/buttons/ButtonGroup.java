package remove.tanks.game.screen.gui.buttons;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class ButtonGroup {
    private final List<Button> buttons;
    private int activeButtonIndex;

    public ButtonGroup(List<Button> buttons) {
        if (buttons.size() == 0) {
            throw new IllegalArgumentException("Cannot create button group with empty list of buttons.");
        }
        this.buttons = buttons;
        this.activeButtonIndex = 0;
        reset();
    }

    public void activatePreviousButton() {
        buttons.get(activeButtonIndex).deactivate();
        if (activeButtonIndex == 0 && buttons.size() > 1) {
            activeButtonIndex = buttons.size() - 1;
        } else {
            activeButtonIndex--;
        }
        buttons.get(activeButtonIndex).activate();
    }

    public void activateNextButton() {
        buttons.get(activeButtonIndex).deactivate();
        if (activeButtonIndex == buttons.size() - 1) {
            activeButtonIndex = 0;
        } else {
            activeButtonIndex++;
        }
        buttons.get(activeButtonIndex).activate();
    }

    public Button getActiveButton() {
        return buttons.get(activeButtonIndex);
    }

    public void lockButtons() {
        buttons.forEach(b -> b.setLocked(true));
    }

    public void unlockButtons() {
        buttons.forEach(b -> b.setLocked(false));
    }

    public void reset() {
        unlockButtons();
        buttons.forEach(Button::deactivate);
        buttons.get(0).activate();
        activeButtonIndex = 0;
    }
}
