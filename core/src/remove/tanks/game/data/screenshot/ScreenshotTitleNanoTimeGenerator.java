package remove.tanks.game.data.screenshot;

/**
 * @author Mateusz Długosz
 */
public final class ScreenshotTitleNanoTimeGenerator implements ScreenshotTitleGenerator {
    private final String prefix;

    public ScreenshotTitleNanoTimeGenerator(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public String generateTitle() {
        return prefix + String.valueOf(System.nanoTime()) + ".png";
    }
}
