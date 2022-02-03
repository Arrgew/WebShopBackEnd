package com.arrgew.webshop.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Data
@Entity
@Table(name = "TAG")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "TAG_NAME")
    private String name;

    @ManyToMany(mappedBy = "tags")
    @JsonBackReference
    private Set<Item> items = new HashSet<>();

}
