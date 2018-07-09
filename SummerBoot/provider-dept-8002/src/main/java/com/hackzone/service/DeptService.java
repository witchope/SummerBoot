package com.hackzone.service;

import com.hackzone.entity.Dept;

import java.util.Optional;

/**
 * @author maxwell
 */
public interface DeptService {
    Optional<Dept> getDeptById(String id);
}
