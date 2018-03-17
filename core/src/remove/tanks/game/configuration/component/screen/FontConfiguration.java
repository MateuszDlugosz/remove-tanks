package remove.tanks.game.configuration.component.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.application.context.configuration.ConfigurationOption;

/**
 * @author Mateusz Długosz
 */
public final class FontConfiguration {
    @ComponentName("DefaultBitmapFont")
    public static final class RegularBitMapFontSupplier extends ComponentSupplier<BitmapFont> {
        @Override
        public BitmapFont supplyComponent() {
            FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(getContext()
                    .getConfiguration().getOption(ConfigurationOption.GameFontTTFFilename.getName())));
            FreeTypeFontGenerator.FreeTypeFontParameter parameter
                    = new FreeTypeFontGenerator.FreeTypeFontParameter();

            parameter.size = 20;
            parameter.color = Color.WHITE;
            parameter.borderColor = Color.BLACK;
            parameter.borderWidth = 2;
            parameter.shadowOffsetX = 3;
            parameter.shadowOffsetY = -3;
            parameter.characters = FreeTypeFontGenerator.DEFAULT_CHARS + "ŁłŚśĆćĘęŻżŹźÓóĄąŃń";
            BitmapFont font = generator.generateFont(parameter);
            generator.dispose();
            return font;
        }
    }
}
