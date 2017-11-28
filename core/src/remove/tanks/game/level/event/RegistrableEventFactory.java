package remove.tanks.game.level.event;

/**
 * @author Mateusz Długosz
 */
public interface RegistrableEventFactory<T extends Event, U extends EventPrototype> {
    T createEvent(U prototype);
    Class<U> getFactoryType();
}
