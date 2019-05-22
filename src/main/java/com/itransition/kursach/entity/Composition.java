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
    private String text;

    @ElementCollection(targetClass = Genre.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "composition_genre", joinColumns = @JoinColumn(name = "composition_id"))
    @Enumerated(EnumType.STRING)
    private Set<Genre> genres;

    public Composition(){

    }

    public Composition(String compositionname, String text, Set<Genre> genres) {
        this.compositionname = compositionname;
        this.text = text;
        this.genres = genres;
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
}
