package com.example.birthday_wisher.Repository;

import com.example.birthday_wisher.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u " +
            "WHERE FUNCTION('DAY', u.birthday) = :day " +
            "AND FUNCTION('MONTH', u.birthday) = :month")
    List<User> findUsersByDayAndMonth(@Param("day") int day,@Param("month") int month);
}
