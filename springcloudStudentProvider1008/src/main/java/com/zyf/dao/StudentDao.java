package com.zyf.dao;

import com.zyf.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * created by zhangyf on 2020-03-14 9:25
 */
public interface StudentDao extends JpaRepository<Student, Integer>, JpaSpecificationExecutor<Student> {


}
