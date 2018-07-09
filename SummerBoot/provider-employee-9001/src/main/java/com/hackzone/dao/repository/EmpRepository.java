package com.hackzone.dao.repository;

import com.hackzone.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author maxwell
 */
@Repository
public interface EmpRepository extends JpaRepository<Employee, Long>{
}
