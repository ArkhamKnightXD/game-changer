package arkham.knight.gamestop.services;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileUploadService {

    public String storeAndCleanImage(MultipartFile[] files, String uploadDirectory){

        StringBuilder fileNames = new StringBuilder();

        for (MultipartFile file: files) {

            Path fileNamePath = Paths.get(uploadDirectory,file.getOriginalFilename());

            fileNames.append(file.getOriginalFilename());

            try {

                Files.write(fileNamePath, file.getBytes());
            }catch (IOException e){

                e.printStackTrace();
            }
        }
        return fileNames.toString();
    }
}
