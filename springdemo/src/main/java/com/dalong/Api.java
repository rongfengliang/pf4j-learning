package com.dalong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
public class Api {

    @GetMapping(value = {"/demoapp"})
    public Object result() {
        String token = null;
        List<UserLogin> userLoginList = Application.globalPluginManager.getExtensions(UserLogin.class);
        if (Objects.nonNull(userLoginList) && userLoginList.size() > 1) {
            token = userLoginList.get(0).token("dalong", "dalong");
        }
        return token;
    }
}
