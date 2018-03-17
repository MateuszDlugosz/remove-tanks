package remove.tanks.game.configuration.component.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.application.context.configuration.ConfigurationOption;

/**
 * @author Mateusz Długosz
 */
public final class SkinConfiguration {
    @ComponentName("UISkin")
    public static final class UISkinSupplier extends ComponentSupplier<Skin> {
        @Override
        public Skin supplyComponent() {
            Pixmap pixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
            pixmap.setColor(0, 0, 0, 0.4f);
            pixmap.fill();
            Texture backgroundMenu = new Texture(pixmap);

            pixmap.setColor(0, 0, 0, 0);
            pixmap.fill();
            Texture backgroundTransparent = new Texture(pixmap);

            pixmap.dispose();

            Skin skin = new Skin();
            skin.add("font-default",
                    getContext().getComponent("DefaultBitmapFont", BitmapFont.class));
            skin.add("background-menu", backgroundMenu);
            skin.add("background-transparent", backgroundTransparent);
            skin.load(Gdx.files.internal(getContext().getConfiguration()
                    .getOption(ConfigurationOption.GameSkinFilename.getName())));

            return skin;
        }
    }
}
