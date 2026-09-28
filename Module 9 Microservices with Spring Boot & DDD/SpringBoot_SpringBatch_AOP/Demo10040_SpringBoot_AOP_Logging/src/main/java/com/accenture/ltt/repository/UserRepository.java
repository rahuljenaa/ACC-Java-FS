

package com.accenture.ltt.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.accenture.ltt.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Derived query method – safe parameter binding
    User findByUsername(String username);

    // Explicit JPQL using named parameter – safe
    @Query("SELECT u FROM User u WHERE u.username = :username")
    User findByUsernameUsingQuery(@Param("username") String username);

    // Native query example – still safe if using parameter binding
    @Query(value = "SELECT * FROM users WHERE username = :username", nativeQuery = true)
    User findByUsernameNative(@Param("username") String username);
}

