package com.kakao.firebaseapplication.models;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by User on 2016. 8. 3..
 */
@IgnoreExtraProperties
public class User {

    public String email;
    public String device;

    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String email, String device) {
        this.email = email;
        this.device = device;
    }

}
