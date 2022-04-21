package utils;

import java.io.*;
import java.util.Properties;

public class PropertyLoader {

    public static String loadProperty(final String key) {
        Properties prop = getAllPropFromFile("project.properties");
        return prop.getProperty(key);
    }

    public static String loadProperty(final String key, String path) {
        Properties prop = getAllPropFromFile(path);
        return prop.getProperty(key);
    }


    public static Properties getAllPropFromFile(final String path) {

        Properties prop = new Properties();
        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader = null;

        try {
            try {
                fileInputStream = new FileInputStream("src/main/resources/" + path);
                inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            } catch (FileNotFoundException | UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            try {
                prop.load(inputStreamReader);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return prop;
    }
}
