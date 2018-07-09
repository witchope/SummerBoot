package com.hackzone.service;

import com.hackzone.entity.Dept;
import com.hackzone.entity.Employee;

import java.util.Optional;

/**
 * @author maxwell
 */
public interface EmpService {
    Optional<Employee> getEmpById(Long id);
    Optional<Employee> getObjById(Long id);
}
