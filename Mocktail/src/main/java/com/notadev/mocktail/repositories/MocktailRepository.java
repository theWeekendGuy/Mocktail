package com.notadev.mocktail.repositories;

import com.notadev.mocktail.models.Mocktails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.print.DocFlavor;

@Repository
public interface MocktailRepository extends JpaRepository<Mocktails, Long> {
    Mocktails findByUrl(String url);
}
