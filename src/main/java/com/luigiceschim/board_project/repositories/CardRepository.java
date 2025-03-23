package com.luigiceschim.board_project.repositories;

import com.luigiceschim.board_project.entities.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface CardRepository extends JpaRepository<Card, Long> {

    @Modifying
    @Query("UPDATE Card c SET c.coluna.id = (" +
            "   SELECT col.id FROM Coluna col WHERE col.board.id = c.coluna.board.id AND col.ordem = c.coluna.ordem + 1" +
            ") WHERE c.id = :cardId")
    void moveCardToNextColumn(@Param("cardId") Long cardId);

    @Modifying
    @Query("DELETE FROM Card c WHERE c.id = :cardId")
    void removeCard(@Param("cardId")Long cardId);

    @Modifying
    @Query("UPDATE Card c SET c.coluna.id = " +
            "(SELECT col.id FROM Coluna col WHERE col.board.id = c.coluna.board.id AND col.tipo = 'CANCELADO') " +
            "WHERE c.id = :cardId")
    void cancelCard(@Param("cardId") Long cardId);




}
