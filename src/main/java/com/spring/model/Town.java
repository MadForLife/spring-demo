package com.spring.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "towns")
public class Town {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", length = 40, nullable = false)
    private String name;

    @OneToMany(mappedBy = "town") // one town could have many minions
    private List<Minion> minionList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Minion> getMinionList() {
        return minionList;
    }

    public void setMinionList(List<Minion> minionList) {
        this.minionList = minionList;
    }

    @Override
    public String toString() {
        return "Town{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", minionList=" + minionList +
                '}';
    }
}
