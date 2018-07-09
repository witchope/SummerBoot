package com.hackzone.dao.repository;

import com.hackzone.entity.Dept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author maxwell
 */
@Repository
public interface DeptRepository extends JpaRepository<Dept, Long>{
}
