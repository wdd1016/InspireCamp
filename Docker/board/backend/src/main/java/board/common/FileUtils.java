package board.common;

import board.entity.BoardFileEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.nio.file.Paths;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Component
public class FileUtils {
    @Value("${spring.servlet.multipart.location}")
    private String uploadDir;

    public List<BoardFileEntity> parseFileInfoForJpa(MultipartHttpServletRequest request) throws Exception {
        if (ObjectUtils.isEmpty(request)) {
            return null;
        }

        List<BoardFileEntity> fileInfoList = new ArrayList<>();
        // 파일을 저장할 디렉터리를 설정
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
        ZonedDateTime now = ZonedDateTime.now();
        String imageDir = Paths.get(System.getProperty("user.dir"), uploadDir, "images").toString();
        File fileDir = new File(imageDir);
        if (!fileDir.exists()) {
            fileDir.mkdir();
        }
        String storedDir = Paths.get(imageDir, now.format(dtf)).toString();
        fileDir = new File(storedDir);
        if (!fileDir.exists()) {
            fileDir.mkdir();
        }

        // 업로드 파일 데이터를 디렉터리에 저장하고 정보를 리스트에 저장
        Iterator<String> fileTagNames = request.getFileNames();
        while (fileTagNames.hasNext()) {
            String fileTagName = fileTagNames.next();
            List<MultipartFile> files = request.getFiles(fileTagName);
            for (MultipartFile file : files) {
                String originalFileExtension = "";

                // 파일 확장자를 ContentType에 맞춰서 지정
                if (!file.isEmpty()) {
                    String contentType = file.getContentType();
                    if (ObjectUtils.isEmpty(contentType)) {
                        break;
                    } else {
                        if (contentType.contains("image/jpeg")) {
                            originalFileExtension = ".jpg";
                        } else if (contentType.contains("image/png")) {
                            originalFileExtension = ".png";
                        } else if (contentType.contains("image/gif")) {
                            originalFileExtension = ".gif";
                        } else {
                            break;
                        }
                    }

                    // 저장에 사용할 파일 이름을 조합
                    String storedFileName = Long.toString(System.nanoTime()) + originalFileExtension;
                    String finalDir = Paths.get(storedDir, storedFileName).toString();

                    // 파일 정보를 리스트에 저장
                    BoardFileEntity entity = new BoardFileEntity();
                    entity.setFileSize(file.getSize());
                    entity.setOriginalFileName(file.getOriginalFilename());
                    entity.setStoredFilePath(finalDir);
                    fileInfoList.add(entity);

                    // 파일 저장
                    fileDir = new File(finalDir);
                    file.transferTo(fileDir);
                }
            }
        }

        return fileInfoList;
    }
}
