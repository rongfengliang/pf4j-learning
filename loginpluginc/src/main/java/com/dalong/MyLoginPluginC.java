package com.dalong;

import org.pf4j.Extension;
import org.pf4j.Plugin;
import org.pf4j.PluginWrapper;

/**
 * login plugin c
 */
public class MyLoginPluginC extends Plugin {
    public MyLoginPluginC(PluginWrapper wrapper) {
        super(wrapper);
    }

    @Override
    public void delete() {
        super.delete();
        System.out.println("pluginc  delete");
    }

    @Override
    public void stop() {
        super.stop();
        System.out.println("pluginc  stop");

    }

    @Override
    public void start() {
        super.start();
        System.out.println("pluginc  start");

    }
    @Extension
    public  static  class MyLoginC implements  UserLogin {

        @Override
        public String token(String name, String password) {
            return String.format("%s-%s-plugin c",name,password);
        }
    }
}
