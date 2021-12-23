package org.dagon1093.irregularverbstraining.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "participle")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Participle extends BaseEntity{

    @Column(name = "word")
    private String word;

    @Column(name = "transcription")
    private String transcription;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "present_id")
    private Present present;

}
