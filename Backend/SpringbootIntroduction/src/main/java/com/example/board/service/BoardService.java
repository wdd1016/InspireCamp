package com.example.board.service;

import com.example.board.dto.BoardDto;

import java.util.List;

public interface BoardService {
    List<BoardDto> selectBoardList();

    void insertBoard(BoardDto boardDto);

    BoardDto selectBoardDetail(int boardIdx);

    void updateBoard(BoardDto boardDto);

    void deleteBoard(int boardIdx);
}
