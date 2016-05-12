package com.jurnacks.com.jurnacks.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Stephen Jurnack on 5/11/2016.
 */

@Entity
@Table(name = "config")
public class ConfigEntity {

    @Id
    @Column(unique = true)
    private String name;

    @Column
    private String value;

    public ConfigEntity() {
    }

    public ConfigEntity(String name, String value) {
        this.value = value;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
