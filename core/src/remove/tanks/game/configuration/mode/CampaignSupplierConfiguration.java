package remove.tanks.game.configuration.mode;

import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.level.LevelSequenceXmlLoader;
import remove.tanks.game.mode.campaign.CampaignXmlLoader;

/**
 * @author Mateusz Długosz
 */
public final class CampaignSupplierConfiguration {
    @ComponentName("CampaignXmlLoader")
    public static final class CampaignXmlLoaderSupplier extends ComponentSupplier<CampaignXmlLoader> {
        @Override
        public CampaignXmlLoader supplyComponent() {
            return new CampaignXmlLoader(
                    getContext().getComponent("XmlReader", XmlReader.class),
                    getContext().getComponent("LevelSequenceXmlLoader", LevelSequenceXmlLoader.class)
            );
        }
    }
}
