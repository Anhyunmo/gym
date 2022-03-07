package com.example.gym.util;

import org.mindrot.jbcrypt.BCrypt;

public class EncryptHelperImpl implements EncryptHelper{

    @Override
    public String encrypt(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    @Override
    public boolean isMatch(String password, String hashed) {
        return BCrypt.checkpw(password, hashed);
    }
}
