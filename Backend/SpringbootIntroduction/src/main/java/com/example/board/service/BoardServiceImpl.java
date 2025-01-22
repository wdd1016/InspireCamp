package com.example.board.service;

import java.util.List;

import com.example.board.dto.BoardDto;
import com.example.board.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    private BoardMapper boardMapper;

    @Override
    public List<BoardDto> selectBoardList() {
        return boardMapper.selectBoardList();
    }
}
