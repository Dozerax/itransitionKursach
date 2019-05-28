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


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    @ElementCollection(targetClass = Genre.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "composition_genre", joinColumns = @JoinColumn(name = "composition_id"))
    @Enumerated(EnumType.STRING)
    private Set<Genre> genres;

    public Composition(){

    }

    public Composition(User author) {
        this.author = author;
    }

    public Composition(String compositionname, String compositionDescription, Set<Genre> genres, User author) {
        this.compositionname = compositionname;
        this.compositionDescription = compositionDescription;
        this.genres = genres;
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

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getCompositionDescription() {
        return compositionDescription;
    }

    public void setCompositionDescription(String compositionDescription) {
        this.compositionDescription = compositionDescription;
    }
}
