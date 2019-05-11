package me.will.tank;

import java.io.IOException;
import java.util.Properties;

/**
 * @author : zhenweiLi
 * @date :2019-05-12 00:12
 * DESC : 配置文件管理类
 */
public class PropertyManager {

    public static Properties property = new Properties();

    static {
        try {
            property.load(PropertyManager.class.getClassLoader().getResourceAsStream("config"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object get(String key) {

        if (property == null) {
            return null;
        }

        return property.get(key);
    }

    public static int getAsInt(String key, int defInt) {

        if (property == null) {
            return defInt;
        }

        String value = (String) property.get(key);

        if (null == value || value.isEmpty()) {
            return defInt;
        }

        return Integer.parseInt(value);
    }

}
