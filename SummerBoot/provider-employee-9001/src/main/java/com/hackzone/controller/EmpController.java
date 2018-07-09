package com.hackzone.controller;

import com.hackzone.entity.BaseResp;
import com.hackzone.entity.Dept;
import com.hackzone.entity.Employee;
import com.hackzone.service.EmpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

/**
 * @author maxwell
 */
@RestController
@RequestMapping(value = "/emp")
public class EmpController {
    private static final Logger logger = LoggerFactory.getLogger(EmpController.class);

    private final EmpService empService;
    private final DiscoveryClient discoveryClient;
    @Autowired
    public EmpController(EmpService empService, DiscoveryClient discoveryClient) {
        this.empService = empService;
        this.discoveryClient = discoveryClient;
    }

    @GetMapping(value = "/one/{id}")
    public BaseResp<Employee> one(@PathVariable("id")Long id) {
        BaseResp<Employee> resp = new BaseResp<>();
        Optional<Employee> data = empService.getEmpById(id);
        resp.setData(data);
        return resp;
    }

    @GetMapping(value = "/many/{id}")
    public BaseResp<Object> many(@PathVariable("id")Long id, HttpServletResponse response) {
        BaseResp<Object> resp = new BaseResp<>();
        Optional<Employee> mutli = empService.getObjById(id);
        resp.setData(Optional.ofNullable(mutli));
        Cookie cookie = new Cookie("test", "123");
        cookie.setMaxAge(3000);
        response.addCookie(cookie);
        return resp;
    }

}
