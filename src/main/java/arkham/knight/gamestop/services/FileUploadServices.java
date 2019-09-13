package arkham.knight.gamestop.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileUploadServices {

    public String almacenarAndDepurarImagen (MultipartFile[] files, String uploadDirectory){


        // Aqui guardare el nombre del archivo
        StringBuilder fileNames = new StringBuilder();

        // Aqui tomaremos cada archivo subido y que son varios utilizaremos un foreach
        // cuando sea solo uno no habrea necesidad del foreach

        for (MultipartFile file: files) {

            // Aqui consigo y almaceno el nombre el archivo
            Path fileNamePath = Paths.get(uploadDirectory,file.getOriginalFilename());

            // Aqui le agregamos el nombre del archivo a la variable que definimos arriba
            fileNames.append(file.getOriginalFilename());

            // Aqui finalmente guardamos los archivos o el archivo obtenido
            // El try y el catch son necesarios o sino data error el write

            try {

                Files.write(fileNamePath, file.getBytes());
            }catch (IOException e){

                e.printStackTrace();
            }


        }


        // Aqui al final retorno el nombre del archivo para asi mandarle esto al constructor de cliente o equipo
        // y guardar el nombre de la imagen
        return fileNames.toString();
    }

}
