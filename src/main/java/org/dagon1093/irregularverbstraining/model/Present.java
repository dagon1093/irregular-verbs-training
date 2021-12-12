package org.dagon1093.irregularverbstraining.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "present")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Present extends BaseEntity{

    @Column(name = "word")
    private String word;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "present")
    private Set<Past> pastSet;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "present")
    private Set<Participle> participleSet;

    @Column(name = "translate")
    private String translate;
}
