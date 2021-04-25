package org.acm.demo.model;


import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
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
//    @Null(message = "can not assign id for fruit")
    public Integer id;

    @NotBlank(message = "name can not be empty")
    public String name;

    @NotBlank(message = "description can not be empty")
    public String description;

    public Fruit() {

    }

    public Fruit(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public static Fruit findByNameAndDescription(String name, String description) {
        return find("name = ?1 and description = ? 2", name, description).firstResult();
    }
}
