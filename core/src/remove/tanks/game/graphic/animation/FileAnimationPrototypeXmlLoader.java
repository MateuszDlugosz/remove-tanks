package remove.tanks.game.graphic.animation;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.XmlReader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class FileAnimationPrototypeXmlLoader implements RegistrableAnimationPrototypeXmlLoader<FileAnimationPrototype> {
    private static final String FRAME_ELEMENT = "frame";
    private static final String FILENAME_ATTRIBUTE = "filename";
    private static final String FRAME_DURATION_ATTRIBUTE = "frameDuration";
    private static final String PLAY_MODE_ATTRIBUTE = "playMode";
    private static final String FLIP_X_ATTRIBUTE = "flipX";
    private static final String FLIP_Y_ATTRIBUTE = "flipY";

    private static final boolean FLIP_X_DEFAULT_VALUE = false;
    private static final boolean FLIP_Y_DEFAULT_VALUE = false;

    @Override
    public FileAnimationPrototype loadAnimationPrototype(XmlReader.Element element) {
        try {
            return new FileAnimationPrototype(
                    loadFilenames(element.getChildrenByName(FRAME_ELEMENT)),
                    loadFrameDuration(element),
                    loadPlayMode(element),
                    loadFlipX(element),
                    loadFlipY(element)
            );
        } catch (Exception e) {
            throw new AnimationPrototypeXmlLoadException(element, e);
        }
    }

    private List<String> loadFilenames(Array<XmlReader.Element> elements) {
        return Arrays.stream(elements.toArray())
                .map(e -> e.getAttribute(FILENAME_ATTRIBUTE).trim())
                .collect(Collectors.toList());
    }

    private float loadFrameDuration(XmlReader.Element element) {
        return Float.valueOf(element.getAttribute(FRAME_DURATION_ATTRIBUTE));
    }

    private Animation.PlayMode loadPlayMode(XmlReader.Element element) {
        return Animation.PlayMode.valueOf(element.getAttribute(PLAY_MODE_ATTRIBUTE));
    }

    private boolean loadFlipX(XmlReader.Element element) {
        return element.getBoolean(FLIP_X_ATTRIBUTE, FLIP_X_DEFAULT_VALUE);
    }

    private boolean loadFlipY(XmlReader.Element element) {
        return element.getBoolean(FLIP_Y_ATTRIBUTE, FLIP_Y_DEFAULT_VALUE);
    }

    @Override
    public AnimationType getLoaderType() {
        return AnimationType.FileAnimation;
    }
}
