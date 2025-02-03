package board.dto;

import lombok.Data;

import java.util.List;

@Data
public class BoardDto {
    private int boardIdx;
    private String title;
    private String contents;
    private int hitCnt;
    private String createdDt;
    private String createdId;
    private String updaterDt;
    private String updaterId;

    // 첨부 파일 정보를 저장할 필드를 추가
    private List<BoardFileDto> fileInfoList;
}
