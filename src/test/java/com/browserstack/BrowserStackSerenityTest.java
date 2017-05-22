package com.browserstack;

import com.browserstack.local.Local;

import java.util.HashMap;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;


public class BrowserStackSerenityTest {
    static Local bsLocal;

    @BeforeClass
    public static void setUp() throws Exception {
        EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();

        String accessKey = System.getenv("AJ2qL2UKCVPxC7pu8t6y");
        if(accessKey == null) {
            accessKey = (String) environmentVariables.getProperty("browserstack.key");
        }

        String environment = System.getProperty("environment");
        String key = "browserstack.local";
        boolean is_local = environmentVariables.getProperty(key) != null && environmentVariables.getProperty(key).equals("true");

        if(environment != null && !is_local){
            key = "environment."+environment+".browserstack.local";
            is_local = environmentVariables.getProperty(key) != null && environmentVariables.getProperty(key).equals("true");
        }

        if(is_local){
            bsLocal = new Local();
            Map<String, String> bsLocalArgs = new HashMap<String, String>();
            bsLocalArgs.put("key", accessKey);
            bsLocal.start(bsLocalArgs);
        }
    }

    @AfterClass
    public static void tearDown() throws Exception {
        if(bsLocal != null) {
            bsLocal.stop();
        }
    }
}