package br.com.ayr.qa.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestData {

    private static Properties properties = new Properties();

    static {
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/testdata.properties");
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar testdata.properties", e);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
