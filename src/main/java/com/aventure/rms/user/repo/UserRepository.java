package com.aventure.rms.user.repo;

import com.aventure.rms.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
