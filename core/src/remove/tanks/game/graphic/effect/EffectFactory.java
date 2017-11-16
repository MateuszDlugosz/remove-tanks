package remove.tanks.game.graphic.effect;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class EffectFactory {
    private final Map<Class<? extends EffectPrototype>, RegistrableEffectFactory> subFactories
            = new HashMap<>();

    public EffectFactory(RegistrableEffectFactory[] subFactories) {
        Arrays.stream(subFactories).forEach(s -> this.subFactories.put(s.getFactoryType(), s));
    }

    public List<Effect> createEffects(List<EffectPrototype> prototypes) {
        return prototypes.stream()
                .map(this::createEffect)
                .collect(Collectors.toList());
    }

    public Effect createEffect(EffectPrototype prototype) {
        Class<? extends EffectPrototype> prototypeClass = prototype.getClass();
        if (!subFactories.containsKey(prototypeClass)) {
            throw new EffectFactoryNotFoundException(prototypeClass.toString());
        }
        return subFactories.get(prototypeClass).createEffect(prototype);
    }
}
