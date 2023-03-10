package com.driver.repositories;

import com.driver.models.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    @Transactional
    @Modifying
    @Query("update User u set u.password = ?1 where u.id = ?2")
    void updatePasswordById(String password, int id);

}
