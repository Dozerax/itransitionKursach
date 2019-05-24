package com.itransition.kursach.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "composition")
public class Composition {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String compositionname;
    private String compositionDescription;
    @Column(columnDefinition = "LONGTEXT")
    private String text;

    private Long userId;
    private String author;

    @ElementCollection(targetClass = Genre.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "composition_genre", joinColumns = @JoinColumn(name = "composition_id"))
    @Enumerated(EnumType.STRING)
    private Set<Genre> genres;

    public Composition(){

    }

    public Composition(String compositionname,String compositionDescription, String text, Set<Genre> genres, Long userId,String author) {
        this.compositionname = compositionname;
        this.text = text;
        this.compositionDescription = compositionDescription;
        this.genres = genres;
        this.userId = userId;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompositionname() {
        return compositionname;
    }

    public void setCompositionname(String compositionname) {
        this.compositionname = compositionname;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCompositionDescription() {
        return compositionDescription;
    }

    public void setCompositionDescription(String compositionDescription) {
        this.compositionDescription = compositionDescription;
    }
}
