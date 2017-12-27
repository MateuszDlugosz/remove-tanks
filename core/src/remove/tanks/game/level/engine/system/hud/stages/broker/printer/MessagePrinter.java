package remove.tanks.game.level.engine.system.hud.stages.broker.printer;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.google.common.eventbus.EventBus;
import remove.tanks.game.audio.sound.event.PlaySoundEvent;
import remove.tanks.game.level.engine.system.hud.stages.broker.message.Message;
import remove.tanks.game.locale.Locale;
import remove.tanks.game.utility.time.Timer;

/**
 * @author Mateusz Długosz
 */
public final class MessagePrinter {
    private final Sound printingSound;
    private final EventBus eventBus;
    private final Locale locale;
    private final Timer timer;

    public MessagePrinter(Sound printingSound, EventBus eventBus, Locale locale, Timer timer) {
        this.printingSound = printingSound;
        this.eventBus = eventBus;
        this.locale = locale;
        this.timer = timer;
    }

    public boolean printMessage(Message message, Label label, float delta) {
        if (timer.isCompleted()) {
            int currentLength = label.getText().length();
            int targetLength = locale.getTranslation().getEntry(message.getEntryKey().getName()).length();

            if (currentLength != targetLength) {
                label.setText(locale.getTranslation().getEntry(message.getEntryKey().getName())
                        .substring(0, currentLength + 1).toUpperCase());
                eventBus.post(new PlaySoundEvent(printingSound));
                timer.reset();
            } else {
                return true;
            }
        } else {
            timer.update(delta);
        }

        return false;
    }
}
