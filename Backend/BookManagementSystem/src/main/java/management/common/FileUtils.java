package management.common;

import management.dto.BookImagesDto;
import management.entity.BookImagesEntity;
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
import java.time.LocalDateTime;


@Component
public class FileUtils {
    @Value("${spring.servlet.multipart.location}")
    private String uploadDir;

    // 요청을 통해서 전달받은 파일을 저장하고, 파일 정보를 반환하는 메서드
    public BookImagesDto parseFileInfo(Long bookId, MultipartHttpServletRequest request) throws Exception {
        if (ObjectUtils.isEmpty(request)) {
            return null;
        }

        BookImagesDto fileInfo = new BookImagesDto();
        // 파일을 저장할 디렉터리를 설정
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
        String partDir = Paths.get(uploadDir, "images").toString();
        String imageDir = Paths.get(System.getProperty("user.dir"), partDir).toString();
        File fileDir = new File(imageDir);
        if (!fileDir.exists()) {
            fileDir.mkdir();
        }
        String nowDay = ZonedDateTime.now().format(dtf);
        String storedDir = Paths.get(imageDir, nowDay).toString();
        partDir = Paths.get(partDir, nowDay).toString();
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
                    partDir = Paths.get(partDir, storedFileName).toString();

                    // 파일 정보를 DTO에 저장
                    fileInfo.setBookId(bookId);
                    fileInfo.setImageUrl('/' + partDir);

                    // 파일 저장
                    fileDir = new File(finalDir);
                    file.transferTo(fileDir);
                }
            }
        }

        return fileInfo;
    }

    public BookImagesEntity parseFileInfo(MultipartHttpServletRequest request) throws Exception {
        if (ObjectUtils.isEmpty(request)) {
            return null;
        }

        BookImagesEntity fileInfo = new BookImagesEntity();
        // 파일을 저장할 디렉터리를 설정
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
        String partDir = Paths.get(uploadDir, "images").toString();
        String imageDir = Paths.get(System.getProperty("user.dir"), partDir).toString();
        File fileDir = new File(imageDir);
        if (!fileDir.exists()) {
            fileDir.mkdir();
        }
        String nowDay = ZonedDateTime.now().format(dtf);
        String storedDir = Paths.get(imageDir, nowDay).toString();
        partDir = Paths.get(partDir, nowDay).toString();
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
                    partDir = Paths.get(partDir, storedFileName).toString();

                    // 파일 정보를 DTO에 저장
                    fileInfo.setImageUrl('/' + partDir);

                    // 파일 저장
                    fileDir = new File(finalDir);
                    file.transferTo(fileDir);
                }
            }
        }

        return fileInfo;
    }
}
