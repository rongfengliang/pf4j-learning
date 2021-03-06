package dalong;

import com.dalong.UserLogin;
import org.pf4j.*;

import java.util.List;
import java.util.function.Consumer;

public class Application {
    public static void main(String[] args) {
        PluginManager pluginManager = new DefaultPluginManager(){
            @Override
            protected ExtensionFinder createExtensionFinder() {
                DefaultExtensionFinder extensionFinder= (DefaultExtensionFinder) super.createExtensionFinder();
                extensionFinder.addServiceProviderExtensionFinder();
                return extensionFinder;
            }

            @Override
            protected ExtensionFactory createExtensionFactory() {
                return super.createExtensionFactory();
            }
        };
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
