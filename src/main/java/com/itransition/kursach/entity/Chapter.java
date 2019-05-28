package com.itransition.kursach.entity;

import javax.persistence.*;

@Entity
public class Chapter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String chaptername;
    @Column(columnDefinition = "LONGTEXT")
    private String text;

    @ManyToOne
    @JoinColumn(name = "composition_id")
    private Composition composition;

    public Chapter(){

    }

    public Chapter(String chaptername, String text, Composition composition) {
        this.chaptername = chaptername;
        this.text = text;
        this.composition = composition;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChaptername() {
        return chaptername;
    }

    public void setChaptername(String chaptername) {
        this.chaptername = chaptername;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Composition getComposition() {
        return composition;
    }

    public void setComposition(Composition composition) {
        this.composition = composition;
    }
}
