package com.lederboard.backend.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "games")
@Data

public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "game_name", nullable = false, unique = true, length = 50)
    private String gameName;

    @Column(name = "description", columnDefinition="TEXT")
    private String description;

    @Column(name = "icon_url", length = 255)
    private String iconUrl;

    @Column(nullable = false)
    private boolean isActive = true;
}
    