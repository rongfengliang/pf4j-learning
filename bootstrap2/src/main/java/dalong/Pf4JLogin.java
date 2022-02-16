package dalong;

import com.dalong.UserLogin;
import org.pf4j.Extension;

@Extension
public class Pf4JLogin implements UserLogin {
    @Override
    public String token(String name, String password) {
        return String.format("%s-%s-Pf4JLogin ",name,password);
    }
}
