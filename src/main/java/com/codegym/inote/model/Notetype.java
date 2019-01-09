package com.codegym.inote.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "notetype")
public class Notetype {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String Description;

    @OneToMany(targetEntity = INote.class)
    private List<INote> iNotes;

    public Notetype() {
    }

    public Notetype(String name, String description, List<INote> iNotes) {
        this.name = name;
        Description = description;
        this.iNotes = iNotes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public List<INote> getiNotes() {
        return iNotes;
    }

    public void setiNotes(List<INote> iNotes) {
        this.iNotes = iNotes;
    }
}
