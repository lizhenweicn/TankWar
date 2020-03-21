package me.will.tank;

import java.io.IOException;
import java.util.Properties;

/**
 * @author : zhenweiLi
 * @date :2019-05-12 00:12
 * DESC : 配置文件管理类
 */
public class PropertyManager {

    private static final Properties PROPERTY = new Properties();

    private PropertyManager() {
    }

    static {
        try {
            PROPERTY.load(PropertyManager.class.getClassLoader().getResourceAsStream("config"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object get(String key) {
        return PROPERTY.get(key);
    }

    static int getAsInt(String key, int defInt) {
        String value = (String) get(key);
        if (null == value || value.isEmpty()) {
            return defInt;
        }
        return Integer.parseInt(value);
    }

}
