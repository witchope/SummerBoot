package com.hackzone.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Data
@Entity
@Table(name = "tb_department")
public class Dept implements Serializable{
    @Id
    @Column(name = "dept_no")
    private Long deptNo;
    @Column(name = "dept_name")
    private String deptName;
    @Column(name = "dept_source")
    private String deptSource;
}
