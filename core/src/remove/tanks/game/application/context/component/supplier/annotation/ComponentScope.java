package remove.tanks.game.application.context.component.supplier.annotation;

import remove.tanks.game.application.context.component.Scope;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Mateusz Długosz
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ComponentScope {
    Scope value();
}
