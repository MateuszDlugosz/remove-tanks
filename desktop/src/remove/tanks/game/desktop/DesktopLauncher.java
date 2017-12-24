package remove.tanks.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import remove.tanks.game.GameApplication;
import remove.tanks.game.application.context.ApplicationContext;
import remove.tanks.game.application.context.component.provider.ComponentProviderInitializer;
import remove.tanks.game.application.context.configuration.Configuration;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class DesktopLauncher {
	public static void main (String[] arg) {
		configureLoggers();

		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 1280;
		config.height = 720;
		config.fullscreen = false;
		config.resizable = false;
		config.forceExit = true;
		config.title = GameApplication.TITLE + " - " + GameApplication.VERSION;

		Map<String, String> configuration = new HashMap<>();
		configuration.put("game.level.world.scale", "32");
		configuration.put("game.display.scale", "1");
		configuration.put("game.display.width", "320");
		configuration.put("game.display.height", "175");

		List<String> scanPackages = new ArrayList<>();
		scanPackages.add("remove.tanks.game.configuration");

		new LwjglApplication(new GameApplication(new Configuration(configuration, scanPackages)), config);
	}

	private static void configureLoggers() {
		ConsoleHandler consoleHandler = new ConsoleHandler();
		consoleHandler.setFormatter(new Formatter() {
			@Override
			public String format(LogRecord record) {
				return new StringBuilder()
						.append("[").append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(record.getMillis()))).append("] ")
						.append("[").append(record.getLevel()).append("] ")
						.append("- ").append(record.getMessage()).append("\r\n")
						.toString();
			}
		});
		Logger.getLogger("").setUseParentHandlers(false);
		Logger.getLogger(ApplicationContext.class.getName()).setUseParentHandlers(false);
		Logger.getLogger(ComponentProviderInitializer.class.getName()).setUseParentHandlers(false);
		Logger.getLogger(ApplicationContext.class.getName()).addHandler(consoleHandler);
		Logger.getLogger(ComponentProviderInitializer.class.getName()).addHandler(consoleHandler);
	}
}
