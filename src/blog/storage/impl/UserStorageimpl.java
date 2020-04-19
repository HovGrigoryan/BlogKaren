package blog.storage.impl;

import blog.exception.UserNotFoundException;
import blog.model.User;

public class UserStorageimpl implements UserStorage {

    private User users[] = new User[30];
    private int size;

    @Override
    public void addUser(User user) {
        if (users.length == size) {
            extend();
        }
        users[size++] = user;

    }

    private void extend() {
        User tmp[] = new User[users.length + 10];
        System.arraycopy(users, 0, tmp, 0, users.length);
        users = tmp;
    }


    @Override
    public User getUserByEmailandByPassword(String email, String password) throws UserNotFoundException {
        for (int i = 0; i < size; i++) {
            if (users[i].getEmail().equals(email) || users[i].getPassword().equals(password)) {
                return users[i];
            }
        }
        throw new UserNotFoundException(String.format("User with %s and $s not found", email, password));
    }


    public User getUserByEmail(String email) throws UserNotFoundException {
        for (int i = 0; i < size; i++) {
            if (users[i].getEmail().equals(email)) {
                return users[i];
            }
        }
        throw new UserNotFoundException(String.format("user with %s email does not exist",email));
    }

}
