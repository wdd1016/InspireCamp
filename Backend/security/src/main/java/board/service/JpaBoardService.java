package board.service;

import board.entity.BoardEntity;
import board.entity.BoardFileEntity;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;

public interface JpaBoardService {
    List<BoardEntity> selectBoardList();

    BoardEntity selectBoardDetail(int boardIdx);


    void insertBoard(BoardEntity boardEntity, MultipartHttpServletRequest request) throws Exception;

    void updateBoard(BoardEntity boardEntity);

    void deleteBoard(int boardIdx);

    BoardFileEntity selectBoardFileInfo(int idx, int boardIdx);
}
