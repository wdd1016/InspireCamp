package board.mapper;

import board.dto.BoardDto;
import board.dto.BoardFileDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import java.util.List;

// 특징              @Mapper	                                                @Service
// 주체              MyBatis                                             	Spring
// 동작 방식          MyBatis가 인터페이스를 감지하고 Proxy 구현체를 자동 생성	    Spring이 클래스(구현체)를 감지하여 빈으로 등록
// 대상	             Mapper 인터페이스	                                    Service 구현 클래스
// 구현체 생성 여부    MyBatis가 런타임에 동적으로 생성	                        개발자가 구현체 클래스를 명시적으로 작성해야 함
@Mapper
public interface BoardMapper {
    List<BoardDto> selectBoardList();

    void insertBoard(BoardDto boardDto);

    BoardDto selectBoardDetail(int boardIdx);

    void updateBoard(BoardDto boardDto);

    void deleteBoard(BoardDto boardDto);

    void updateHitCnt(int boardIdx);

    void insertBoardFileList(List<BoardFileDto> fileInfoList);

    List<BoardFileDto> selectBoardFileList(int boardIdx);

    BoardFileDto selectBoardFileInfo(@Param("idx") int idx, @Param("boardIdx") int boardIdx);
}

// MyBatis가 이런식으로 만들어줌.
// public class BoardMapperImpl implements BoardMapper {
//     @Override
//     List<BoardDto> select
// }
