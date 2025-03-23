package com.luigiceschim.board_project.repositories;

import com.luigiceschim.board_project.entities.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
