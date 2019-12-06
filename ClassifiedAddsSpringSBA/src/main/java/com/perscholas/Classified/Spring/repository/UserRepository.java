package com.perscholas.Classified.Spring.repository;
import com.perscholas.Classified.Spring.model.User;

public interface UserRepository {
		Integer registerUser(User user);
		Boolean getUser(String userName);
	}

