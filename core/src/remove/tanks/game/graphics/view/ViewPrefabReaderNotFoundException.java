package remove.tanks.game.graphics.view;

/**
 * @author Mateusz Długosz
 */
public final class ViewPrefabReaderNotFoundException extends RuntimeException {
    private final static String MESSAGE_TEMPLATE = "View prefab reader of %s not found.";

    public ViewPrefabReaderNotFoundException(ViewType viewType) {
        super(String.format(MESSAGE_TEMPLATE, viewType));
    }
}
