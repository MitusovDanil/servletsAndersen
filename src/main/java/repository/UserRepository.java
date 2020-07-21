package repository;

import entity.User;

public interface UserRepository {
    User getUserByLogin(String login);
}
