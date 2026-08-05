package base;


import config.ConfigReader;

public class BaseTest {

    public static void main(String[] args) {
        System.out.println(ConfigReader.getBrowser());
        System.out.println(ConfigReader.getBaseUrl());
        System.out.println(ConfigReader.getUsername());
        System.out.println(ConfigReader.getPassword());
        System.out.println(ConfigReader.getTimeout());
    }

}
