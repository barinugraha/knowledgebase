package com.dom.kb.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dom.kb.model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{

}
