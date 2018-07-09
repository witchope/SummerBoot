package com.hackzone.service.impl;

import com.hackzone.entity.BaseResp;
import com.hackzone.entity.Dept;
import com.hackzone.entity.Employee;
import com.hackzone.dao.repository.EmpRepository;
import com.hackzone.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Service
public class EmpServiceImpl implements EmpService {
    private final EmpRepository empRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public EmpServiceImpl(EmpRepository empRepository, RestTemplate restTemplate) {
        this.empRepository = empRepository;
        this.restTemplate = restTemplate;
    }


    @Override
    public Optional<Employee> getEmpById(Long id) {
        return empRepository.findById(id);
    }

    @Override
    public Optional<Employee> getObjById(Long id) {
        Optional<Employee> emp = empRepository.findById(id);
        String url = "http://summer-service-dept/dept/one/" + id;
        Dept dept = restTemplate.getForObject(url, Dept.class);
        Employee employee = null;
        if (emp.isPresent()) {
            employee = emp.get();
        }
        if (employee != null) {
            employee.setDept(dept);
        }
        return Optional.ofNullable(employee);
    }
}
