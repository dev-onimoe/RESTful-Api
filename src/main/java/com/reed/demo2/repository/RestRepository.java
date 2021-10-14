package com.reed.demo2.repository;

import com.reed.demo2.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestRepository extends JpaRepository<Users, Integer> {

}
