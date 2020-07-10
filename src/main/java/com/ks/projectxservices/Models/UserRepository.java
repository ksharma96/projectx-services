package com.ks.projectxservices.Models;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByUsername(String username);
    List<User> findByUserid(Integer userid);
}
