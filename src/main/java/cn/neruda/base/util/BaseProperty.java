package cn.neruda.base.util;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Created by baiguomin on 2017/5/4.
 */
public class BaseProperty {
    public static Map<String,Object> configMap = new HashMap<>();

    static {
        Properties prop = new Properties();
        try {
            InputStream in =
                    ClassLoader.getSystemResourceAsStream("application.properties");
            prop.load(in);
            in.close();
            Set<Object> objects = prop.keySet();
            for(Object key : objects){
                configMap.put((String)key,prop.getProperty((String)key));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object get(String key){
        Object result = configMap.get(key);
        if(result != null){
            return result;
        }else{
            throw new RuntimeException("application.properties has no this key");
        }
    }
}
