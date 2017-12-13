package remove.tanks.game.graphic.effect;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
@SuppressWarnings("unchecked")
public final class EffectFactory {
    private final Map<Class<? extends EffectPrototype>, RegistrableEffectFactory> factories
            = new HashMap<>();

    public EffectFactory(RegistrableEffectFactory[] factories) {
        Arrays.stream(factories).forEach(s -> this.factories.put(s.getFactoryType(), s));
    }

    public List<Effect> createEffects(List<EffectPrototype> prototypes) {
        return prototypes.stream()
                .map(this::createEffect)
                .collect(Collectors.toList());
    }

    public Effect createEffect(EffectPrototype prototype) {
        try {
            if (!factories.containsKey(prototype.getClass())) {
                throw new EffectFactoryNotFoundException(prototype.getClass());
            }
            return factories.get(prototype.getClass()).createEffect(prototype);
        } catch (Exception e) {
            throw new EffectCreateException(prototype, e);
        }
    }
}
