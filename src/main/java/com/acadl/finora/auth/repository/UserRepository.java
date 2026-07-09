package com.acadl.finora.auth.repository;

import com.acadl.finora.auth.model.User;

public interface UserRepository {
    User create(User user);
}
