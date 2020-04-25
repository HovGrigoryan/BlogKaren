package blog.storage.impl;

import blog.exception.UserNotFoundException;
import blog.model.User;

public interface UserStorage<T> {
    User getUserByEmailandByPassword(String email, String password) throws UserNotFoundException;

    void addUser(User user);



}
