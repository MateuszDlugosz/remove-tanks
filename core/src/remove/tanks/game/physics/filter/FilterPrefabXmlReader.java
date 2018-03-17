package remove.tanks.game.physics.filter;

import com.badlogic.gdx.utils.XmlReader;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mateusz Długosz
 */
public final class FilterPrefabXmlReader {
    public static final String FILTER_ELEMENT = "filter";
    public static final String FILTERS_ELEMENT = "filters";

    private static final String CATEGORY_BIT_ELEMENT = "categoryBit";
    private static final String MASK_BIT_ELEMENT = "maskBit";

    private final Map<String, Short> categoryBits;
    private final Map<String, Short> maskBits;

    public FilterPrefabXmlReader(
            Map<String, Short> categoryBits,
            Map<String, Short> maskBits
    ) {
        this.categoryBits = categoryBits;
        this.maskBits = maskBits;
    }

    public List<FilterPrefab> readFilterPrefabs(XmlReader.Element element) {
        return Arrays.stream(element.getChildrenByName(FILTER_ELEMENT).toArray())
                .map(this::readFilterPrefab)
                .collect(Collectors.toList());
    }

    public FilterPrefab readFilterPrefab(XmlReader.Element element) {
        try {
            String categoryName = element.getChildByName(CATEGORY_BIT_ELEMENT).getText().trim();
            String maskName = element.getChildByName(MASK_BIT_ELEMENT).getText().trim();

            if (!categoryBits.containsKey(categoryName)) {
                throw new CategoryBitNotRegisteredException(categoryName);
            }

            if (!maskBits.containsKey(maskName)) {
                throw new MaskBitNotRegisteredException(maskName);
            }

            return new FilterPrefab(
                    categoryBits.get(categoryName),
                    maskBits.get(maskName)
            );
        } catch (Exception e) {
            throw new FilterPrefabXmlReadException(element, e);
        }
    }
}
