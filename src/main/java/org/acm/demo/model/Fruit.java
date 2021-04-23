package org.acm.demo.model;


import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.util.List;

@Entity
public class Fruit extends PanacheEntityBase {
    @Id
    @SequenceGenerator(
            name = "fruitSequence",
            sequenceName = "fruit_id_seq",
            allocationSize = 1,
            initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fruitSequence")
    public Integer id;
    public String name;
    public String description;
    public Fruit() {

    }

    public Fruit(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public static List<Fruit> findByNameAndDescription(String name, String description) {
        return find("name = ?1 and description = ? 2", name, description).list();
    }
}
