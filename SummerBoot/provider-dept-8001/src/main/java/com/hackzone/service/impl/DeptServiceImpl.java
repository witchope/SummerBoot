package com.hackzone.service.impl;

import com.hackzone.dao.repository.DeptRepository;
import com.hackzone.entity.Dept;
import com.hackzone.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeptServiceImpl implements DeptService {

    private final DeptRepository deptRepository;

    @Autowired
    public DeptServiceImpl(DeptRepository deptRepository) {
        this.deptRepository = deptRepository;
    }

    @Override
    public Optional<Dept> getDeptById(String id) {
        Optional<Dept> dept = deptRepository.findById(Long.valueOf(id));
        return dept;
    }
}
