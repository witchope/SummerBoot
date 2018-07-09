package com.hackzone.controller;

import com.hackzone.entity.Dept;
import com.hackzone.service.DeptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * @author maxwell
 */
@RestController
@RequestMapping(value = "/dept")
public class DeptController {
    private static final Logger logger = LoggerFactory.getLogger(DeptController.class);

    private final DeptService deptService;
    private final DiscoveryClient discoveryClient;
    @Autowired
    public DeptController(DeptService deptService, DiscoveryClient discoveryClient) {
        this.deptService = deptService;
        this.discoveryClient = discoveryClient;
    }

    @GetMapping(value = "/one/{id}")
    public Dept one(@PathVariable("id")String id) {
        Optional<Dept> data = deptService.getDeptById(id);
        // 获取所有的微服务
        List<String> clientService = discoveryClient.getServices();
        for (String s : clientService) {
            logger.info(s);
        }
        // 获取所有实例
        List<ServiceInstance> instances = discoveryClient.getInstances("summer-service-dept");
        for (ServiceInstance instance : instances) {
            logger.info(instance.getServiceId() + "\t" + instance.getHost());
        }
        return data.get();
    }

}
