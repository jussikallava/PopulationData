package fi.kallava.population.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author jussi kallava 17.9.2018
 */
public abstract class Entity {

    @Id
    @GeneratedValue
    private Long id;

    public Long getId() {
        return id;
    }
}