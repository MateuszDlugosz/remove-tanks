package remove.tanks.game.asset;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.XmlReader;
import org.junit.Before;
import org.junit.Test;
import remove.tanks.game.LibGDXTest;
import remove.tanks.game.asset.parameter.ParametersPrototypeXmlLoader;

import static org.junit.Assert.*;

/**
 * @author Mateusz Długosz
 */
public class AssetPrototypeXmlLoaderTest extends LibGDXTest {
    private static final String CORRECT_ASSET_PROTOTYPE_FILE
            = "asset/asset-correct-prototype.xml";
    private static final String INCORRECT_ASSET_PROTOTYPE_FILE
            = "asset/asset-incorrect-prototype.xml";

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
        assertEquals("remove/tanks/game/graphics/textures/atlases/test-atlas-file.pack",
                prototype.getFilename());
        assertFalse(prototype.getParametersPrototype().isPresent());
    }

    @Test(expected = AssetPrototypeXmlLoadException.class)
    public void when_ElementIsIncorrectlyFormatted_Then_ThrowException() {
        assetPrototypeXmlLoader.loadAssetPrototype(xmlReader.parse(
                Gdx.files.internal(INCORRECT_ASSET_PROTOTYPE_FILE)));
    }
}