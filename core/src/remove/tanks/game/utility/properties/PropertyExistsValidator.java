package remove.tanks.game.utility.properties;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class PropertyExistsValidator {
    private final List<String> requiredProperties;

    public PropertyExistsValidator(String[] requiredProperties) {
        this.requiredProperties = Arrays.asList(requiredProperties);
    }

    public PropertyExistsValidator(List<String> requiredProperties) {
        this.requiredProperties = requiredProperties;
    }

    public void validateProperties(Properties properties) throws NoSuchPropertiesKeysValidationException {
        List<String> propertiesNotFound = new ArrayList<>();
        requiredProperties.forEach(k -> {
            if (!properties.getKeys().contains(k)) {
                propertiesNotFound.add(k);
            }
        });
        if (propertiesNotFound.size() > 0) {
            throw new NoSuchPropertiesKeysValidationException(propertiesNotFound);
        }
    }
}
