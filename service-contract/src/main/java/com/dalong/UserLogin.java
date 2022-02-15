package com.dalong;

import org.pf4j.ExtensionPoint;

/**
 * @author dalong
 * userlogin service contract
 */
public interface UserLogin extends  ExtensionPoint {
    /**
     * userlogin service contract
     * @param name name
     * @param password password
     * @return token
     */
    String token(String name,String password);
}
