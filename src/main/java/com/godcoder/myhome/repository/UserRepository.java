package com.godcoder.myhome.repository;

import com.godcoder.myhome.model.Event;
import com.godcoder.myhome.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {
    @Transactional
    @Modifying
    @Query(value="UPDATE User r SET r.password = :password WHERE r.user_id = :user_id",nativeQuery = false)
    Integer update(@Param("password") String password, @Param("user_id") Integer user_id);

    List<User> findByUsername(String username);

}
