package com.ks.projectxservices.Models;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<UserData, Integer> {
    List<UserData> findByUsername(String username);
    List<UserData> findByUserid(Integer userid);
    List<UserData> findByEmail(String email);
}
