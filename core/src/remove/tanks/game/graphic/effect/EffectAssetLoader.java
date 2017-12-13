package remove.tanks.game.graphic.effect;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.SynchronousAssetLoader;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;

/**
 * @author Mateusz Długosz
 */
public final class EffectAssetLoader extends SynchronousAssetLoader<Effect, EffectAssetLoader.EffectParameter> {
    private final EffectPrototypeXmlLoader effectPrototypeXmlLoader;
    private final EffectFactory effectFactory;

    public EffectAssetLoader(
            FileHandleResolver resolver,
            EffectPrototypeXmlLoader effectPrototypeXmlLoader,
            EffectFactory effectFactory
    ) {
        super(resolver);
        this.effectPrototypeXmlLoader = effectPrototypeXmlLoader;
        this.effectFactory = effectFactory;
    }

    @Override
    public Array<AssetDescriptor> getDependencies(String fileName, FileHandle file, EffectParameter parameter) {
        return null;
    }

    @Override
    public Effect load(AssetManager assetManager, String fileName, FileHandle file, EffectParameter parameter) {
        return effectFactory.createEffect(
                effectPrototypeXmlLoader.loadEffectPrototype(fileName)
        );
    }

    public static final class EffectParameter extends AssetLoaderParameters<Effect> {
        public EffectParameter() {
        }
    }
}
