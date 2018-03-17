package remove.tanks.game.asset.parameter;

import com.badlogic.gdx.assets.loaders.ParticleEffectLoader;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * @author Mateusz Długosz
 */
public class ParametersPrefabTest {
    @Test
    public void Should_ReturnAssignedValues() {
        Map<String, String> parametersMap = new HashMap<>();
        parametersMap.put("testParameter", "testValue");
        ParametersPrefab prefab = new ParametersPrefab(ParticleEffectLoader.ParticleEffectParameter.class, parametersMap);

        assertEquals(ParticleEffectLoader.ParticleEffectParameter.class, prefab.getClassName());
        assertEquals("testValue", prefab.getParameters().get("testParameter"));
    }

    @Test
    public void Should_ReturnFormattedStringRepresentation() {
        Map<String, String> parametersMap = new HashMap<>();
        parametersMap.put("testParameter", "testValue");
        ParametersPrefab prefab = new ParametersPrefab(ParticleEffectLoader.ParticleEffectParameter.class, parametersMap);

        assertEquals(
                "ParametersPrefab{className=class com.badlogic.gdx.assets.loaders." +
                        "ParticleEffectLoader$ParticleEffectParameter, parameters={testParameter=testValue}}",
                prefab.toString()
        );
    }
}