package com.example.management.daojpa;

import com.example.management.Model.Employee;
import com.example.management.Model.Projet;

import java.util.List;

public interface dao {
    List<Employee> Lister();
    void affecterEmployeAuProjet(Long employeId, Long projetId);
    void saveUser(Employee employee);
    void delete(Long id);
    List<Projet> ListerE();
}
