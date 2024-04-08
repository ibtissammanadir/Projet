package com.example.management.Beans;


import com.example.management.Model.Employee;
import com.example.management.Model.Projet;
import com.example.management.daojpa.daoimpl;
import jakarta.annotation.ManagedBean;
import jakarta.faces.view.ViewScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@ManagedBean
@ViewScoped
public class AffectationBean {

    @PersistenceContext
    private EntityManager em;
    private Long selectedEmployeId;
    private Long selectedProjetId;
    private List<Employee> employes;
    private List<Projet> projets;
    private Employee employee ;
    private daoimpl dao = new daoimpl();


    public Long getSelectedEmployeId() {
        return selectedEmployeId;
    }

    public void setSelectedEmployeId(Long selectedEmployeId) {
        this.selectedEmployeId = selectedEmployeId;
    }

    public Long getSelectedProjetId() {
        return selectedProjetId;
    }

    public void setSelectedProjetId(Long selectedProjetId) {
        this.selectedProjetId = selectedProjetId;
    }

    public List<Employee> getEmployes() {
        return dao.Lister();
    }

    public void setEmployes(List<Employee> employes) {
        this.employes = employes;
    }

    public List<Projet> getProjets() {
        return dao.ListerE();
    }

    public void setProjets(List<Projet> projets) {
        this.projets = projets;
    }
    public void affecterEmployeAuProjet(){
        dao.affecterEmployeAuProjet( selectedEmployeId,  selectedProjetId);
    }
    public void addEmployee(){
        dao.saveUser(employee);
    }
}


