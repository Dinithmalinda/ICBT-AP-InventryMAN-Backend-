package com.Dinithm.ICBT.USER;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository <Users,Long>{
    List<Users> findByName(String name);
    List<Users> findByMobile(String mobile);
    List<Users> deleteByMobile(String mobile);
}
