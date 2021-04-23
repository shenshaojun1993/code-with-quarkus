package org.acm.demo.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class Gift extends PanacheEntity {

    private String name;

    public Gift() {
    }

    public Gift(String name) {
        this.name = name;
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

    public static List<Gift> findById(Long id) {
        return findAll().list();
    }
}
