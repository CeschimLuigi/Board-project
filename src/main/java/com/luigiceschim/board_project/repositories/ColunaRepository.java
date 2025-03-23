package com.luigiceschim.board_project.repositories;

import com.luigiceschim.board_project.entities.Coluna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ColunaRepository extends JpaRepository<Coluna, Long> {
    @Query("SELECT col FROM Coluna col WHERE col.board.id = :boardId AND col.ordem = 1")
    Optional<Coluna> findFirstColumnByBoardId(@Param("boardId") Long boardId);

    Optional<Coluna> findByOrdem(int ordem);



}
