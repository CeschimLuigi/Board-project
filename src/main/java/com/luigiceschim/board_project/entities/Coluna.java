package com.luigiceschim.board_project.entities;

import com.luigiceschim.board_project.services.colunaService.ColunaService;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_coluna")
@Data
@NoArgsConstructor
public class Coluna {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer ordem;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    @Enumerated(EnumType.STRING)
    private TipoColuna tipo;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coluna", fetch = FetchType.EAGER)
    private List<Card>cards;

    public Coluna(String nome, int ordem, TipoColuna tipoColuna) {
        this.nome= nome;
        this.ordem = ordem;
        this.tipo= tipoColuna;
        this.cards = new ArrayList<>();
    }

    public void addCard(Card card){
        this.cards.add(card);
    }
    public void removeCard(Card card){
        this.cards.remove(card);
    }


}
