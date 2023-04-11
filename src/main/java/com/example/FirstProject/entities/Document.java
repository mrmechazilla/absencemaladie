package com.example.FirstProject.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Document {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private long size;
    private Date dateCreation;
    private Date uploadTime;
    @Column(columnDefinition = "MEDIUMBLOB") // approx 16MB
    private byte[] content;

    @OneToOne(mappedBy = "document")
    @JoinColumn(name = "absencemaladieId")
    private AbsenceMaladie absenceMaladie;

    public Document(Long id, String name, long size, Date dateCreation, Date uplloadTime, byte[] content){
        this.id = id;
        this.name = name;
        this.size = size;
        this.dateCreation = dateCreation;
        this.uploadTime = uplloadTime;
        this.content = content;
    }
}
