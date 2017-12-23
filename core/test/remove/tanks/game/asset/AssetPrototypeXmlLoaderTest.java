package remove.tanks.game.asset;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.loaders.ParticleEffectLoader;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.XmlReader;
import org.junit.Before;
import org.junit.Test;
import remove.tanks.game.LibGDXTest;
import remove.tanks.game.asset.parameter.ParametersPrototypeXmlLoader;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Mateusz Długosz
 */
public class AssetPrototypeXmlLoaderTest extends LibGDXTest {
    private static final String CORRECT_ASSET_PROTOTYPE_FILE
            = "asset/asset-correct-prototype.xml";
    private static final String CORRECT_ASSET_PROTOTYPE_FILE_WITH_PARAMETERS
            = "asset/asset-correct-prototype-with-parameters.xml";
    private static final String INCORRECT_ASSET_PROTOTYPE_FILE
            = "asset/asset-incorrect-prototype.xml";
    private static final String CORRECT_ASSET_PROTOTYPES_FILE
            = "asset/asset-correct-prototypes.xml";
    private static final String INCORRECT_ASSET_PROTOTYPES_FILE
            = "asset/asset-incorrect-prototypes.xml";

    private XmlReader xmlReader;
    private AssetPrototypeXmlLoader assetPrototypeXmlLoader;

    @Before
    public void initTestObjects() {
        xmlReader = new XmlReader();
        assetPrototypeXmlLoader = new AssetPrototypeXmlLoader(
                new ParametersPrototypeXmlLoader()
        );
    }

    @Test
    public void when_ElementIsCorrectlyFormatted_Then_LoadAssetPrototype() {
        AssetPrototype prototype = assetPrototypeXmlLoader.loadAssetPrototype(xmlReader.parse(
                Gdx.files.internal(CORRECT_ASSET_PROTOTYPE_FILE)));

        assertEquals(TextureAtlas.class, prototype.getClassName());
        assertEquals("sampleId", prototype.getId());
        assertEquals("graphics/textures/atlases/test-atlas-file.pack",
                prototype.getFilename());
        assertFalse(prototype.getParametersPrototype().isPresent());
    }

    @Test
    public void when_ElementIsCorrectlyFormatted_Then_LoadAssetPrototypeWithParameters() {
        AssetPrototype prototype = assetPrototypeXmlLoader.loadAssetPrototype(xmlReader.parse(
                Gdx.files.internal(CORRECT_ASSET_PROTOTYPE_FILE_WITH_PARAMETERS)));

        assertEquals(TextureAtlas.class, prototype.getClassName());
        assertEquals("sampleId", prototype.getId());
        assertEquals("graphics/textures/atlases/test-atlas-file.pack",
                prototype.getFilename());
        assertTrue(prototype.getParametersPrototype().isPresent());
        assertEquals(ParticleEffectLoader.ParticleEffectParameter.class,
                prototype.getParametersPrototype().get().getClassName());
    }

    @Test(expected = AssetPrototypeXmlLoadException.class)
    public void when_ElementIsIncorrectlyFormatted_Then_ThrowException() {
        assetPrototypeXmlLoader.loadAssetPrototype(xmlReader.parse(
                Gdx.files.internal(INCORRECT_ASSET_PROTOTYPE_FILE)));
    }

    @Test
    public void when_ElementIsCorrectlyFormatted_Then_LoadAssetPrototypes() {
        List<AssetPrototype> prototypes = assetPrototypeXmlLoader.loadAssetPrototypes(xmlReader.parse(
                Gdx.files.internal(CORRECT_ASSET_PROTOTYPES_FILE)));

        assertEquals(2, prototypes.size());
        assertEquals("testId0", prototypes.get(0).getId());
        assertEquals("testId1", prototypes.get(1).getId());
    }

    @Test(expected = AssetPrototypeXmlLoadException.class)
    public void when_ElementsAreIncorrectlyFormatted_Then_ThrowException() {
        assetPrototypeXmlLoader.loadAssetPrototypes(xmlReader.parse(
                Gdx.files.internal(INCORRECT_ASSET_PROTOTYPES_FILE)));
    }
}