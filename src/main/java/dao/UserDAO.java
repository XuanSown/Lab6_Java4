package dao;

import entity.User;

public interface UserDAO {
	User findById(String id);
}
