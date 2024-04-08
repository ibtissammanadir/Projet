package com.example.management.Beans;

import com.example.management.Model.Employee;
import com.example.management.daojpa.daoimpl;
import jakarta.annotation.ManagedBean;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;

import java.util.List;

@ManagedBean
@ViewScoped
public class EmployeeBean {
    @PostConstruct
    public void init(){
         Employee employee = new Employee();

    }
    private Long id;

    private String name;
    private String email;
    private String skills;
    private daoimpl dao = new daoimpl();
    private Employee employee = new Employee();


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }
    public List<Employee> getemployees(){
        return dao.Lister();
    }
    public String ADDEmployee() {
        dao.saveUser(employee);
        return "EmployeList?faces-redirect=true";

    }
    public void deleteEmploye (Long id){dao.delete(id);
    }
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;

    }}
