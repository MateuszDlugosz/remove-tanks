package remove.tanks.game.configuration.component.data;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.XmlReader;
import remove.tanks.game.application.context.component.Scope;
import remove.tanks.game.application.context.component.supplier.ComponentSupplier;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentName;
import remove.tanks.game.application.context.component.supplier.annotation.ComponentScope;
import remove.tanks.game.application.context.configuration.ConfigurationOption;
import remove.tanks.game.data.profile.*;
import remove.tanks.game.data.profile.achievement.AchievementAvailabilityChecker;
import remove.tanks.game.data.profile.achievement.AchievementTypeXmlReader;
import remove.tanks.game.data.profile.achievement.AchievementTypeXmlWriter;
import remove.tanks.game.utility.properties.PropertiesXmlReader;
import remove.tanks.game.utility.properties.PropertiesXmlWriter;
import remove.tanks.game.utility.xml.XmlFormatter;

/**
 * @author Mateusz Długosz
 */
public final class ProfileConfiguration {
    @ComponentName("Profile")
    @ComponentScope(Scope.Prototype)
    public static final class PlayerProfileSupplier extends ComponentSupplier<Profile> {
        @Override
        public Profile supplyComponent() {
            return getContext().getComponent("ProfileController", ProfileController.class)
                    .readProfile();
        }
    }

    @ComponentName("ProfileXmlReader")
    public static final class ProfileXmlReaderSupplier extends ComponentSupplier<ProfileXmlReader> {
        @Override
        public ProfileXmlReader supplyComponent() {
            return new ProfileXmlReader(
                    getContext().getComponent("XmlReader", XmlReader.class),
                    getContext().getComponent("PropertiesXmlReader", PropertiesXmlReader.class),
                    getContext().getComponent("AchievementTypeXmlReader", AchievementTypeXmlReader.class)
            );
        }
    }

    @ComponentName("ProfileXmlWriter")
    public static final class ProfileXmlWriterSupplier extends ComponentSupplier<ProfileXmlWriter> {
        @Override
        public ProfileXmlWriter supplyComponent() {
            return new ProfileXmlWriter(
                    getContext().getComponent("PropertiesXmlWriter", PropertiesXmlWriter.class),
                    getContext().getComponent("AchievementTypeXmlWriter", AchievementTypeXmlWriter.class)
            );
        }
    }

    @ComponentName("ProfileInitializer")
    public static final class ProfileInitializerSupplier extends ComponentSupplier<ProfileInitializer> {
        @Override
        public ProfileInitializer supplyComponent() {
            return new ProfileInitializer();
        }
    }

    @ComponentName("ProfileScanner")
    public static final class ProfileScannerSupplier extends ComponentSupplier<ProfileScanner> {
        @Override
        public ProfileScanner supplyComponent() {
            return new ProfileScanner();
        }
    }

    @ComponentName("ProfileController")
    public static final class ProfileControllerSupplier extends ComponentSupplier<ProfileController> {
        @Override
        public ProfileController supplyComponent() {
            return new ProfileController(
                    getContext().getComponent("EmptyProfileFileHandle", FileHandle.class),
                    getContext().getComponent("LocalProfileFileHandle", FileHandle.class),
                    getContext().getComponent("ProfileScanner", ProfileScanner.class),
                    getContext().getComponent("ProfileInitializer", ProfileInitializer.class),
                    getContext().getComponent("ProfileXmlReader", ProfileXmlReader.class),
                    getContext().getComponent("ProfileXmlWriter", ProfileXmlWriter.class),
                    getContext().getComponent("ProfileUpdater", ProfileUpdater.class),
                    getContext().getComponent("XmlFormatter", XmlFormatter.class)
            );
        }
    }

    @ComponentName("ProfileUpdater")
    public static final class ProfileUpdaterSupplier extends ComponentSupplier<ProfileUpdater> {
        @Override
        public ProfileUpdater supplyComponent() {
            return new ProfileUpdater(
                    getContext().getComponent("AchievementAvailabilityChecker", AchievementAvailabilityChecker.class)
            );
        }
    }

    @ComponentName("EmptyProfileFileHandle")
    public static final class EmptyProfileFileHandleSupplier extends ComponentSupplier<FileHandle> {
        @Override
        public FileHandle supplyComponent() {
            return Gdx.files.internal(
                    getContext().getConfiguration().getOption(ConfigurationOption.GameProfileEmptyFilename.getName())
            );
        }
    }

    @ComponentName("LocalProfileFileHandle")
    public static final class LocalProfileFileHandleSupplier extends ComponentSupplier<FileHandle> {
        @Override
        public FileHandle supplyComponent() {
            return Gdx.files.external(
                    getContext().getConfiguration().getOption(ConfigurationOption.GameLocalDataDirectory.getName())
            ).child(getContext().getConfiguration().getOption(ConfigurationOption.GameProfileLocalFilename.getName()));
        }
    }
}
