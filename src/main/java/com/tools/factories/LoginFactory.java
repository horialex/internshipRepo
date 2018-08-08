package com.tools.factories;

import com.tools.entities.Login;
import com.tools.entities.User;

public class LoginFactory {

    public static Login getLoginInstance() {
        Login login = new Login();
        User user = new User();
//        user.setEmail(EnvironmentConstants.USER);
//        user.setPassword(EnvironmentConstants.PASS);
//        user.setName(EnvironmentConstants.USER_NAME);
        user.setEmail("horatiu.encian@evozon.com");
        user.setPassword("testtest1");
        user.setName("Encian Horatiu");
        login.setUser(user);
        return login;
    }
}
