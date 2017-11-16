package remove.tanks.game.utility.properties;

import com.google.common.base.MoreObjects;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Mateusz Długosz
 */
public final class Properties implements Serializable {
    private final Map<String, String> properties;

    public Properties() {
        this.properties = new HashMap<>();
    }

    public Properties(Map<String, String> properties) {
        this.properties = properties;
    }

    public void putString(String key, String value) {
        properties.put(key, value);
    }

    public String getString(String key) {
        if (!properties.containsKey(key)) {
            throw new NoSuchPropertyException(key);
        }
        return properties.get(key);
    }

    public String getString(String key, String defaultValue) {
        return properties.containsKey(key) ? getString(key) : defaultValue;
    }

    public void putInt(String key, int value) {
        properties.put(key, Integer.toString(value));
    }

    public int getInt(String key) {
        if (!properties.containsKey(key)) {
            throw new NoSuchPropertyException(key);
        }
        return Integer.parseInt(properties.get(key));
    }

    public int getInt(String key, int defaultValue) {
        return properties.containsKey(key) ? getInt(key) : defaultValue;
    }

    public void putFloat(String key, float value) {
        properties.put(key, Float.toString(value));
    }

    public float getFloat(String key) {
        if (!properties.containsKey(key)) {
            throw new NoSuchPropertyException(key);
        }
        return Float.parseFloat(properties.get(key));
    }

    public float getFloat(String key, float defaultValue) {
        return properties.containsKey(key) ? getFloat(key) : defaultValue;
    }

    public void putShort(String key, short value) {
        properties.put(key, Short.toString(value));
    }

    public short getShort(String key) {
        if (!properties.containsKey(key)) {
            throw new NoSuchPropertyException(key);
        }
        return Short.parseShort(properties.get(key));
    }

    public short getShort(String key, short defaultValue) {
        return properties.containsKey(key) ? getShort(key) : defaultValue;
    }

    public void putLong(String key, long value) {
        properties.put(key, Long.toString(value));
    }

    public long getLong(String key) {
        if (!properties.containsKey(key)) {
            throw new NoSuchPropertyException(key);
        }
        return Long.parseLong(properties.get(key));
    }

    public long getLong(String key, long defaultValue) {
        return properties.containsKey(key) ? getLong(key) : defaultValue;
    }

    public void putBoolean(String key, boolean value) {
        properties.put(key, Boolean.toString(value));
    }

    public boolean getBoolean(String key) {
        if (!properties.containsKey(key)) {
            throw new NoSuchPropertyException(key);
        }
        return Boolean.parseBoolean(properties.get(key));
    }

    public boolean getBoolean(String key, boolean defaultValue) {
        return properties.containsKey(key) ? getBoolean(key) : defaultValue;
    }

    public Set<String> getKeys() {
        return properties.keySet();
    }

    public void merge(Properties newProperties) {
        newProperties.getKeys().forEach(k -> properties.put(k, newProperties.getString(k)));
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("properties", properties)
                .toString();
    }
}
