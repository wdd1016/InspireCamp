package board.repository;

import board.entity.BoardEntity;
import board.entity.BoardFileEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaBoardRepository extends CrudRepository<BoardEntity, Integer> {
    // 쿼리 메서드
    List<BoardEntity> findAllByOrderByBoardIdxDesc();

    // @Query 어노테이션으로 실행할 쿼리를 직접 정의
    @Query("SELECT file FROM BoardFileEntity file WHERE file.board.boardIdx = :boardIdx AND file.idx = :idx")
    BoardFileEntity findBoardFile(@Param("boardIdx") int boardIdx, @Param("idx") int idx);
}
