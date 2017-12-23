package remove.tanks.game.asset.theme;

import com.badlogic.gdx.utils.XmlReader;
import org.junit.Before;
import org.junit.Test;
import remove.tanks.game.LibGDXTest;
import remove.tanks.game.asset.AssetPrototypeXmlLoader;
import remove.tanks.game.asset.parameter.ParametersPrototypeXmlLoader;

import static org.junit.Assert.*;

/**
 * @author Mateusz Długosz
 */
public class ThemeXmlLoaderTest extends LibGDXTest {
    private static final String CORRECT_THEME_FILE = "asset/theme/theme-correct.xml";
    private static final String INCORRECT_THEME_FILE = "asset/theme/theme-incorrect.xml";

    private ThemeXmlLoader themeXmlLoader;

    @Before
    public void initTestObjects() {
        themeXmlLoader = new ThemeXmlLoader(
                new XmlReader(),
                new AssetPrototypeXmlLoader(
                        new ParametersPrototypeXmlLoader()
                )
        );
    }

    @Test
    public void when_ElementIsCorrectlyFormatted_Then_LoadTheme() {
        Theme theme = themeXmlLoader.loadTheme(CORRECT_THEME_FILE);

        assertEquals("testId0", theme.getAssetPrototypes().get(0).getId());
        assertEquals("testId1", theme.getAssetPrototypes().get(1).getId());
    }

    @Test(expected = ThemeXmlLoadException.class)
    public void when_ElementIsCorrectlyFormatted_Then_ThrowException() {
        themeXmlLoader.loadTheme(INCORRECT_THEME_FILE);
    }
}