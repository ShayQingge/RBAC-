package com.athena.service;

import java.util.Map;

import com.athena.pojo.Users;

public interface UsersService {
	Map<String, Object> login(Users users);
}
