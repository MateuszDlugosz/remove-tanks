package remove.tanks.game.configuration.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;

/**
 * @author Mateusz Długosz
 */
public final class FontSupplierConfiguration {
    @ComponentName("DefaultBitmapFont")
    public static final class RegularBitMapFontSupplier extends ComponentSupplier<BitmapFont> {
        @Override
        public BitmapFont supplyComponent() {
            FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("ui/fonts/PressStart2P-Regular.ttf"));
            FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
            parameter.size = 24;
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
