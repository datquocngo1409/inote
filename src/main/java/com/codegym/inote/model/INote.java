package com.codegym.inote.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "inote")
public class INote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "notetype_id")
    private Notetype notetype;

    private String title;

    private String content;

    public INote() {
    }

    public INote(Notetype notetype, String title, String content) {
        this.notetype = notetype;
        this.title = title;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Notetype getNotetype() {
        return notetype;
    }

    public void setNotetype(Notetype notetype) {
        this.notetype = notetype;
    }
}
