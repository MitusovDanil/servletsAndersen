package service;

import entity.Role;
import entity.User;
import repository.UserRepositoryImpl;

public class UserService {

    UserRepositoryImpl userRepository = new UserRepositoryImpl();

    public boolean validateUser(String login, String password) {
        User user = userRepository.getUserByLogin(login);
        return user != null && user.getPassword().equals(password);
    }

    public Role getRoleOfUser(String login, String password) {
        Role role = null;
        if (validateUser(login, password)) {
            if (userRepository.getUserByLogin(login)
                    .getRole().equals(Role.USER)) {
                role = Role.USER;
            } else {
                role = Role.ADMIN;
            }
        }
        return role;
    }
}
