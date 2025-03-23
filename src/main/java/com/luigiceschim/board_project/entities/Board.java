package com.luigiceschim.board_project.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_board")
@Data
@NoArgsConstructor
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "board_id")
    private List<Coluna>colunas;

    public Board(String nome){
        this.nome = nome;
        this.colunas = new ArrayList<>();
        inicializarColunas();

    }

    private void inicializarColunas(){
        this.colunas.add(new Coluna("Inicial",1,TipoColuna.INICIAL));
        this.colunas.add(new Coluna("Pendente",2,TipoColuna.PENDENTE));
        this.colunas.add(new Coluna("Final",3,TipoColuna.FINAL));
        this.colunas.add(new Coluna("Cancelado",4,TipoColuna.CANCELADO));
    }

    public void moveCard(){
    }

}
