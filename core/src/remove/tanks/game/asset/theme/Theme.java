package remove.tanks.game.asset.theme;

import remove.tanks.game.asset.AssetPrototype;

import java.util.List;

/**
 * @author Mateusz Długosz
 */
public final class Theme {
    private final List<AssetPrototype> assetPrototypes;

    public Theme(List<AssetPrototype> assetPrototypes) {
        this.assetPrototypes = assetPrototypes;
    }

    public List<AssetPrototype> getAssetPrototypes() {
        return assetPrototypes;
    }
}
