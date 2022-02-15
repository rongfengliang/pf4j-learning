package com.dalong;

import org.pf4j.DefaultPluginManager;
import org.pf4j.PluginManager;
import org.pf4j.PluginWrapper;

import java.util.List;
import java.util.function.Consumer;

public class Application {
    public static void main(String[] args) {
        PluginManager pluginManager = new DefaultPluginManager();
        pluginManager.loadPlugins();
        pluginManager.startPlugins();
        pluginManager.getPlugins().forEach(new Consumer<PluginWrapper>() {
            @Override
            public void accept(PluginWrapper pluginWrapper) {
                System.out.println("load plugin:"+pluginWrapper.getPluginId()+pluginWrapper.getPluginState());
            }
        });
        List<UserLogin> userLoginList=  pluginManager.getExtensions(UserLogin.class);
        userLoginList.forEach(new Consumer<UserLogin>() {
            @Override
            public void accept(UserLogin userLogin) {
                System.out.println(userLogin.token("name","dalong"));
            }
        });
    }
}
