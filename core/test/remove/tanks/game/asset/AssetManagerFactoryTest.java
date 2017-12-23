package remove.tanks.game.asset;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.AssetLoader;
import com.badlogic.gdx.assets.loaders.ShaderProgramLoader;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import org.junit.Test;
import remove.tanks.game.LibGDXTest;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author Mateusz Długosz
 */
public class AssetManagerFactoryTest extends LibGDXTest {
    @Test
    public void when_CustomAssetLoaderAdded_Then_AssetLoaderIsAvailableInAssetManager() {
        Map<Class<?>, AssetLoader> assetLoaders = new HashMap<>();
        assetLoaders.put(ShaderProgram.class, new ShaderProgramLoader(new InternalFileHandleResolver()));
        AssetManagerFactory assetManagerFactory = new AssetManagerFactory(assetLoaders);
        AssetManager assetManager = assetManagerFactory.createAssetManager();

        assertTrue(ShaderProgramLoader.class.equals(
                assetManager.getLoader(ShaderProgram.class).getClass()));
    }
}