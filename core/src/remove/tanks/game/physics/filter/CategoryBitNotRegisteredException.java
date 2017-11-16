package remove.tanks.game.physics.filter;

/**
 * @author Mateusz Długosz
 */
public final class CategoryBitNotRegisteredException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Category bit %s is not registered in loader.";

    public CategoryBitNotRegisteredException(String categoryName) {
        super(String.format(MESSAGE_TEMPLATE, categoryName));
    }
}
