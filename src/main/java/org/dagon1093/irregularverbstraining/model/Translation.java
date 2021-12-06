package org.dagon1093.irregularverbstraining.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "translation")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Translation extends BaseEntity{

    @Column(name = "word")
    private String word;

}
