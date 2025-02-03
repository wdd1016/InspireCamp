package board.service;

import board.common.FileUtils;
import board.dto.BoardDto;
import board.dto.BoardFileDto;
import board.mapper.BoardMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;

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
        boardDto.setCreatedId("hong");
        boardMapper.insertBoard(boardDto);

        try {
            // 첨부 파일을 디스크에 저장하고, 첨부 파일 정보를 반환
            List<BoardFileDto> fileInfoList = fileUtils.parseFileInfo(boardDto.getBoardIdx(), request);

            // 첨부 파일 정보를 DB에 저장
            if (!CollectionUtils.isEmpty(fileInfoList)) {
                boardMapper.insertBoardFileList(fileInfoList);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
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
        // return boardMapper.selectBoardDetail(boardIdx);

        BoardDto boardDto = boardMapper.selectBoardDetail(boardIdx);
        if (boardDto != null) {
            List<BoardFileDto> boardFileInfoList = boardMapper.selectBoardFileList(boardIdx);
            boardDto.setFileInfoList(boardFileInfoList);
        }
        return boardDto;
    }

    @Override
    public BoardFileDto selectBoardFileInfo(int idx, int boardIdx) {
        return boardMapper.selectBoardFileInfo(idx, boardIdx);
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
