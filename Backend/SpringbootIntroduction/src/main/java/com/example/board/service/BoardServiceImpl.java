package com.example.board.service;

import java.util.Iterator;
import java.util.List;

import com.example.board.common.FileUtils;
import com.example.board.dto.BoardDto;
import com.example.board.dto.BoardFileDto;
import com.example.board.mapper.BoardMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

// @Transactional
@Slf4j
@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    private BoardMapper boardMapper;

    @Autowired
    private FileUtils fileUtils;

    @Override
    public List<BoardDto> selectBoardList() {
        return boardMapper.selectBoardList();
    }

    @Override
    public void insertBoard(BoardDto boardDto, MultipartHttpServletRequest request) {
        // 로그인한 사용자를 글쓴이로 설정
        // TODO. 로그인한 사용자의 ID로 변경
        // boardDto.setCreatedId("hong");
        // boardMapper.insertBoard(boardDto);

        try {
            List<BoardFileDto> fileInfoList = fileUtils.parseFileInfo(100, request);
        } catch (Exception e) {

        }

        // <Log>
        // if (!ObjectUtils.isEmpty(request)) {
        //     // <input type="file" name="이 속성의 값" />
        //     Iterator<String> fileTagNames = request.getFileNames();
        //     while (fileTagNames.hasNext()) {
        //         log.debug("File Tags");
        //         String fileTagName = fileTagNames.next();
        //         // 하나의 <input type="file" multiple="multiple"> 태그를 통해서 전달된 파일들을 가져옮
        //         List<MultipartFile> files = request.getFiles(fileTagName);
        //         for (MultipartFile file : files) {
        //             log.debug("File Information");
        //             log.debug("- file name: " + file.getOriginalFilename());
        //             log.debug("- file size: " + file.getSize());
        //             log.debug("- content type: " + file.getContentType());
        //         }
        //     }
        // }

    }

    // @Transactional
    @Override
    public BoardDto selectBoardDetail(int boardIdx) {
        boardMapper.updateHitCnt(boardIdx);
        // int i = 10 / 0;
        return boardMapper.selectBoardDetail(boardIdx);
    }

    @Override
    public void updateBoard(BoardDto boardDto) {
        // TODO. 로그인한 사용자 아이디로 변경
        boardDto.setUpdaterId("go");
        boardMapper.updateBoard(boardDto);
    }

    @Override
    public void deleteBoard(int boardIdx) {
        BoardDto boardDto = new BoardDto();
        boardDto.setBoardIdx(boardIdx);
        // TODO. 로그인한 사용자 아이디로 변경
        boardDto.setUpdaterId("go");
        boardMapper.deleteBoard(boardDto);
    }
}
