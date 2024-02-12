package com.notadev.mocktail.models;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "mocktails")
@Table(name = "mocktails")
@Data
public class Mocktails {

    @Id
    @Column (name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column (name = "url")
    private String url;

    @Lob
    @Column(name = "expectedResponse", columnDefinition = "TEXT")
    private String expectedResponse;
}
