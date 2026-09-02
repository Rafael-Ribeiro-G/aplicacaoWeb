package com.example.imagensPecas.infra.repository;

import com.example.imagensPecas.domain.entity.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

public interface ImageRepository extends JpaRepository<Image, String> {
}
