package com.example.board.controller;

import java.util.List;

import com.example.board.dto.BoardDto;
import com.example.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/board/openBoardList.do")
    public ModelAndView openBoardList() throws Exception {
        ModelAndView mv = new ModelAndView("/board/boardList");

        List<BoardDto> list = boardService.selectBoardList();
        mv.addObject("list", list);

        return mv;
    }
}