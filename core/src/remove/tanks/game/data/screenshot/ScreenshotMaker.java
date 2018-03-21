package remove.tanks.game.data.screenshot;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.PixmapIO;
import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.ScreenUtils;

/**
 * @author Mateusz Długosz
 */
public final class ScreenshotMaker {
    private final FileHandle screenshotDirectory;
    private final ScreenshotTitleGenerator screenshotTitleGenerator;

    public ScreenshotMaker(
            FileHandle screenshotDirectory,
            ScreenshotTitleGenerator screenshotTitleGenerator
    ) {
        this.screenshotDirectory = screenshotDirectory;
        this.screenshotTitleGenerator = screenshotTitleGenerator;
    }

    public void makeScreenshot() {
        byte[] pixels = ScreenUtils.getFrameBufferPixels(
                0, 0, Gdx.graphics.getBackBufferWidth(), Gdx.graphics.getBackBufferHeight(), true);

        for(int i = 4; i < pixels.length; i += 4) {
            pixels[i - 1] = (byte) 255;
        }

        Pixmap pixmap = new Pixmap(Gdx.graphics.getBackBufferWidth(),
                Gdx.graphics.getBackBufferHeight(), Pixmap.Format.RGBA8888);
        BufferUtils.copy(pixels, 0, pixmap.getPixels(), pixels.length);

        PixmapIO.writePNG(screenshotDirectory.child(screenshotTitleGenerator.generateTitle()), pixmap);
        pixmap.dispose();
    }
}
