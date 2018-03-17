package remove.tanks.game.level.utility.stage.broker.printer;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.google.common.eventbus.EventBus;
import remove.tanks.game.audio.sound.SoundChannelName;
import remove.tanks.game.level.event.sound.PlaySoundEvent;
import remove.tanks.game.level.utility.stage.broker.message.Message;
import remove.tanks.game.locale.Locale;
import remove.tanks.game.utility.time.Timer;

/**
 * @author Mateusz Długosz
 */
public final class MessagePrinter {
    private final Sound printingSound;
    private final SoundChannelName soundChannelName;
    private final EventBus eventBus;
    private final Locale locale;
    private final Timer timer;

    public MessagePrinter(Sound printingSound, SoundChannelName soundChannelName, EventBus eventBus, Locale locale, Timer timer) {
        this.printingSound = printingSound;
        this.soundChannelName = soundChannelName;
        this.eventBus = eventBus;
        this.locale = locale;
        this.timer = timer;
    }

    public boolean printMessage(Message message, Label label, float delta) {
        if (timer.isCompleted()) {
            int currentLength = label.getText().length();
            int targetLength = locale.getSelectedTranslation().getEntry(message.getEntryKey().getName()).length();

            if (currentLength != targetLength) {
                label.setText(locale.getSelectedTranslation().getEntry(message.getEntryKey().getName())
                        .substring(0, currentLength + 1).toUpperCase());
                eventBus.post(new PlaySoundEvent(printingSound, soundChannelName));
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
