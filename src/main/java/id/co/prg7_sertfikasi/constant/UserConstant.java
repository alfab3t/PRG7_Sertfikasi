package id.co.prg7_sertfikasi.constant;

import id.co.prg7_sertfikasi.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserConstant {

    public static List<User> users;

    static {
        users = new ArrayList<>();
        users.add(new User(1, "Roni Prasetyo", "roni.p", "password123", "roni@gmail.com", "Admin", 1));
        users.add(new User(2, "Sisia Dika", "sisia.dika", "password456", "sisia@gmail.com", "Admin", 1));
        users.add(new User(3, "Ning Ratwastuti", "ning.r", "password789", "ning@gmail.com", "Admin", 1));
        users.add(new User(4, "Elora Manuella", "elora.a", "password101", "elora@gmail.com", "Admin", 1));
    }

    public static final String mNotFound = "User not found";
    public static final String mCreateSuccess = "User created successfully";
    public static final String mUpdateSuccess = "User updated successfully";
    public static final String mDeleteSuccess = "User deleted successfully";
    public static final String mAlreadyRegistered = "Username or Email has been registered";
}
