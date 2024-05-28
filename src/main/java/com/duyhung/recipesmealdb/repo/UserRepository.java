package com.duyhung.recipesmealdb.repo;

import com.duyhung.recipesmealdb.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    Optional<User> findByUsernameAndPassword(String username, String password);

    @Query(value = "SELECT * FROM users WHERE username LIKE CONCAT('%', :queryUsername, '%')", nativeQuery = true)
    List<User> findAllByUsername(@Param("queryUsername") String queryUsername);

}
