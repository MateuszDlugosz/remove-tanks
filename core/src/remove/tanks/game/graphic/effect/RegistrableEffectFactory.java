package remove.tanks.game.graphic.effect;

/**
 * @author Mateusz Długosz
 */
public interface RegistrableEffectFactory<T extends Effect, U extends EffectPrototype> {
    T createEffect(U prototype);
    Class<U> getFactoryType();
}
