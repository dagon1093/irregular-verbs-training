package org.dagon1093.irregularverbstraining.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "past")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Past extends BaseEntity{

    @Column(name = "word")
    private String word;
}
