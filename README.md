#RemoveTanks!
RemoveTanks! is a libGDX based game in the spirit of Battle City game.

## Libraries, frameworks and programs
The project uses the following libraries and frameworks:
* libGDX 1.9.8 [https://libgdx.badlogicgames.com/](https://libgdx.badlogicgames.com/)
* Ashley Entity Framework 1.7.3 [https://github.com/libgdx/ashley](https://github.com/libgdx/ashley)
* Box2D 1.9.8 [http://box2d.org/](http://box2d.org/)
* Box2DLights 1.4 [https://github.com/libgdx/box2dlights](https://github.com/libgdx/box2dlights)
* Gdx Freetype 1.9.8 [https://github.com/libgdx/libgdx/wiki/Gdx-freetype](https://github.com/libgdx/libgdx/wiki/Gdx-freetype)
* Guava 23.6 [https://github.com/google/guava](https://github.com/google/guava)
* Reflections 0.9.11 [https://github.com/ronmamo/reflections](https://github.com/ronmamo/reflections)
* JUnit 4.12 [https://junit.org/junit4/](https://junit.org/junit4/)
* Mockito 2.2.7 [http://site.mockito.org/](http://site.mockito.org/)

Assets was created by following programs:
* Bfxr (Website version) [https://www.bfxr.net/](https://www.bfxr.net/)
* Pyxel Edit [http://pyxeledit.com/](http://pyxeledit.com/)
* Gimp 2.8 [https://www.gimp.org/](https://www.gimp.org/)
* Tiled Map Editor 1.1.4 [http://www.mapeditor.org/](http://www.mapeditor.org/)
* Gdx Texture Packer GUI [https://github.com/crashinvaders/gdx-texture-packer-gui](https://github.com/crashinvaders/gdx-texture-packer-gui)

## Running and testing
To run or test a game use following instructions.

### Importing project in IntelliJ Idea

1. Clone or download repository.
2. Run IntelliJ Idea.
3. Go to `File -> Open` and select main game directory.
4. On `Import Project from Gradle` screen select `Use auto-import`, `Create separate module per source set` and `Use default gradle wrapper`. Click `OK` button.

### Building project in IntelliJ Idea

1. Open terminal.
2. Navigate to RemoveTanks main directory.
3. Run command `./gradlew desktop:dist`.
4. Find `.jar` file in `RemoveTanks/desktop/build/libs/desktop-1.0.jar`.

### Running tests in IntelliJ Idea

1. Open terminal.
2. Navigate to RemoveTanks main directory.
3. Run command `./gradlew test`.

### Running project in IntelliJ Idea

1. Go to `Run -> Edit Configurations`.
2. Click on `+` button and select `Application` from the list.
3. Set `Main class` to `remove.tanks.game.desktop.DesktopLauncher`.
4. Set `Working directory` to `RemoveTanks/core/assets`.
5. Set `Use classpath of module` to `desktop_main`.
6. Click `Apply`.

![](https://github.com/MateuszDlugosz/RemoveTanks/blob/master/docs/wiki/images/intellij-run-configuration-0.png)