package blog.storage.impl;

import blog.exception.UserNotFoundException;
import blog.model.User;

import java.util.*;

public class UserStorageimpl implements UserStorage {

    private Map<String, User> users = new HashMap();


    public void addUser(User user) {
        users.put(user.getEmail(), user);

    }

    @Override
    public User getUserByEmailandByPassword(String email, String password) throws UserNotFoundException {
        for (User user : users.values()) {
            if (user.getEmail().equals(email) || user.getPassword().equals(password)) {
                return user;
            }
        }
        throw new UserNotFoundException(String.format("User with %s and $s not found", email, password));
    }


    public User getUserByEmail(String email) throws UserNotFoundException {
        for (User user : users.values()) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        throw new UserNotFoundException(String.format("user with %s email does not exist", email));
    }
}






