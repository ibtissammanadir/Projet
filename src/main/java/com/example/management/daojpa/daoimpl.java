package com.example.management.daojpa;

import com.example.management.Model.Employee;
import com.example.management.Model.Projet;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;


public class daoimpl implements dao {
    private Long selectedEmployeId;
    private Long selectedProjetId;
    private List<Employee> employes;
    private List<Projet> projets;
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Employee");
    private List<Employee> employees;
    private List<Projet> projects ;

    @Override
    public List<Employee> Lister(){
        String jpql = "SELECT e FROM Employee e";
        EntityManager em = emf.createEntityManager();
        this.employees = em.createQuery(jpql, Employee.class).getResultList();
        System.out.println("lister est bien");
        return employees;
    }
    @Override
    public List<Projet> ListerE(){
        String jpql = "SELECT e FROM Projet e";
        EntityManager em = emf.createEntityManager();
        this.projects = em.createQuery(jpql, Projet
                .class).getResultList();
        System.out.println("lister est bien");
        return projects;
    }
    @Override
    public void affecterEmployeAuProjet(Long employeId, Long projetId) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Employee employe = em.find(Employee.class, employeId);
            Projet projet = em.find(Projet.class, projetId);
            if (employe != null && projet != null) {
                employe.setProjet(projet);
                em.merge(employe);
            }
            em.getTransaction().commit();
        } finally {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            em.close();
        }
    }

    @Override

    public void saveUser(Employee employee) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            if (employee.getId() == null) {
                em.persist(employee);
            } else {
                em.merge(employee);
            }
            em.getTransaction().commit();
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }
    @Override
    public void delete(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Employee employee = em.find(Employee.class, id);
            if (employee != null) {
                em.remove(employee);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

}
