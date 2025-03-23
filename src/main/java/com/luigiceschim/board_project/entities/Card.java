package com.luigiceschim.board_project.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.luigiceschim.board_project.exceptions.MotivoException;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Entity
@Table(name = "tb_card")
@Data
@NoArgsConstructor
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descricao;
    private OffsetDateTime dataCriacao;
    private boolean bloqueio;
    private String motivoBloqueio;

    @ManyToOne
    @JoinColumn(name = "coluna_id")
    @JsonIgnore
    private Coluna coluna;

    public Card(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataCriacao = OffsetDateTime.now();
        this.bloqueio = false;
    }


    public void bloquear(String motivo) {
        if ((motivo == null || motivo.isBlank())) {
            throw new MotivoException("ERRO! insira o motivo para fazer o bloqueio");
        }

        this.bloqueio = true;
        this.motivoBloqueio = motivo;
    }

    public void desbloquear(String motivo) {
        if (motivo == null || motivo.isBlank()) {
            throw new MotivoException("ERRO! insira o motivo para fazer o desbloqueio");
        }

        this.bloqueio = false;
        this.motivoBloqueio = motivo;


    }
}
