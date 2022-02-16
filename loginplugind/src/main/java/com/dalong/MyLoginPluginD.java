package com.dalong;

import org.hashids.Hashids;
import org.pf4j.Extension;
import org.pf4j.Plugin;
import org.pf4j.PluginWrapper;

/**
 * login plugin d
 */
public class MyLoginPluginD extends Plugin {
    public MyLoginPluginD(PluginWrapper wrapper) {
        super(wrapper);
    }

    @Override
    public void delete() {
        super.delete();
        System.out.println("plugind  delete");
    }

    @Override
    public void stop() {
        super.stop();
        System.out.println("plugind  stop");

    }

    @Override
    public void start() {
        super.start();
        System.out.println("plugind  start");

    }
    @Extension
    public  static  class MyLoginD implements UserLogin {
        Hashids hashids = new Hashids("demo");
        @Override
        public String token(String name, String password) {
            return String.format("%s-%s-%s-plugin d",name,password,hashids.encode(1000));
        }
    }
}
