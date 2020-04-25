package blog.storage.impl;

import blog.exception.UserNotFoundException;
import blog.model.User;

import java.util.ArrayList;

public class UserStorageimpl<T> implements UserStorage<T> {

    ArrayList<User> users = new ArrayList<>();


    public void addUser(T user) {
        for (int i = 0; i < users.size(); i++) {
            users.add((User) user);
        }
    }

    @Override
    public User getUserByEmailandByPassword(String email, String password) throws UserNotFoundException {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getEmail().equals(email) || users.get(i).getPassword().equals(password)) {
                return users.get(i);
            }
        }
        throw new UserNotFoundException(String.format("User with %s and $s not found", email, password));
    }


    public T getUserByEmail(String email) throws UserNotFoundException {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getEmail().equals(email)) {
                return (T) users.get(i);
            }
        }
        throw new UserNotFoundException(String.format("user with %s email does not exist", email));
    }

}
