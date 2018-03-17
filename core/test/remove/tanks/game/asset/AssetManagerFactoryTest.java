package remove.tanks.game.asset;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.loaders.AssetLoader;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author Mateusz Długosz
 */
public class AssetManagerFactoryTest {
    private AssetManagerFactory assetManagerFactory;

    @Before
    public void initTestObjects() {
        Map<Class<?>, AssetLoader> assetLoaders = new HashMap<>();
        assetLoaders.put(TestAsset0.class, new TestAsset0Loader(new InternalFileHandleResolver()));

        assetManagerFactory = new AssetManagerFactory(assetLoaders);
    }

    @Test
    public void Should_ContainAssetLoader() {
        assertEquals(TestAsset0Loader.class, assetManagerFactory.createAssetManager().getLoader(TestAsset0.class).getClass());
    }

    @Test
    public void Should_NotContainAssetLoader() {
        assertNull(assetManagerFactory.createAssetManager().getLoader(TestAsset1.class));
    }

    private static final class TestAsset0 {}
    private static final class TestAsset1 {}
    private static final class TestAsset0Loader extends AssetLoader<TestAsset0, TestAsset0Loader.TestAssetLoaderParameters> {
        public TestAsset0Loader(FileHandleResolver resolver) { super(resolver); }
        @Override
        public Array<AssetDescriptor> getDependencies(String fileName, FileHandle file, TestAssetLoaderParameters parameter) { return null; }
        public static final class TestAssetLoaderParameters extends AssetLoaderParameters<TestAsset0> { }
    }
}