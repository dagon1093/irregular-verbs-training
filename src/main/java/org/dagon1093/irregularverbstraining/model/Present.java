package org.dagon1093.irregularverbstraining.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @Column(name = "transcription")
    private String transcription;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "present")
    private Set<Past> pastSet;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "present")
    private Set<Participle> participleSet;

    @Column(name = "translate")
    private String translate;
}
