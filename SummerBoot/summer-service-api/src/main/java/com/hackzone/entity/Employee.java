package com.hackzone.entity;


import javax.persistence.*;

/**
 * @author maxwell
 */
@Entity
@Table(name = "tb_employee")
public class Employee {
   @Id
   @GeneratedValue
   @Column(name = "id")
   private Long id;
   @Column(name = "name")
   private String name;
   @Column(name = "email")
   private String email;
   @Column(name = "gender")
   private Integer gender;
   private Dept dept;

   public Employee() {
   }

   public Employee(Long id, String name, String email, Integer gender, Dept dept) {
      this.id = id;
      this.name = name;
      this.email = email;
      this.gender = gender;
      this.dept = dept;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public Integer getGender() {
      return gender;
   }

   public void setGender(Integer gender) {
      this.gender = gender;
   }

   public Dept getDept() {
      return dept;
   }

   public void setDept(Dept dept) {
      this.dept = dept;
   }
}
