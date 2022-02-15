package com.dalong;

import org.pf4j.DefaultExtensionFinder;
import org.pf4j.DefaultPluginManager;
import org.pf4j.ExtensionFinder;
import org.pf4j.PluginManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    private final  static Logger log = LoggerFactory.getLogger(Application.class);
    public  static PluginManager globalPluginManager;
    @Bean
    public CommandLineRunner commandLineRunner(){
        return  new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                PluginManager pluginManager = new DefaultPluginManager(){
                    @Override
                    protected ExtensionFinder createExtensionFinder() {
                        DefaultExtensionFinder extensionFinder= (DefaultExtensionFinder) super.createExtensionFinder();
                        extensionFinder.addServiceProviderExtensionFinder();
                        return extensionFinder;
                    }
                };
                pluginManager.loadPlugins();
                pluginManager.startPlugins();
                globalPluginManager = pluginManager;
                log.info("plugin loaded");
            }
        };
    }
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
