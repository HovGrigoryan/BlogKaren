package blog.storage.impl;

import blog.exception.UserNotFoundException;
import blog.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserStorageimpl implements UserStorage {

    private List<User> users;

    public UserStorageimpl(int length) {
        users = new ArrayList<>(length);
    }

    public UserStorageimpl() {
        users = new ArrayList<>();
    }


    public void addUser(User user) {
            users.add(user);

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


    public User getUserByEmail(String email) throws UserNotFoundException {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getEmail().equals(email)) {
                return users.get(i);
            }
        }
        throw new UserNotFoundException(String.format("user with %s email does not exist", email));
    }

}
