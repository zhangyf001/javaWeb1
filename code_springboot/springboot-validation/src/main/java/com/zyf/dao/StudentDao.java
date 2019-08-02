package com.zyf.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zyf.entity.Student;

public interface StudentDao extends JpaRepository<Student, Integer> {

}
