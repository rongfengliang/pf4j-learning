package com.dalong;

import org.pf4j.Extension;
import org.pf4j.Plugin;
import org.pf4j.PluginWrapper;

/**
 * login plugin b
 */
public class MyFLoginPluginB extends Plugin {
    public MyFLoginPluginB(PluginWrapper wrapper) {
        super(wrapper);
        System.out.println("pluginB");
    }

    @Override
    public void start() {
        super.start();
        System.out.println("pluginB  start");
    }

    @Override
    public void stop() {
        super.stop();
        System.out.println("pluginB  stop");
    }

    @Override
    public void delete() {
        super.delete();
        System.out.println("pluginB  delete");
    }
    @Extension
    public static  class MyLoginB implements  UserLogin{

        @Override
        public String token(String name, String password) {
            return String.format("%s-%s-plugin b",name,password);
        }
    }
}
