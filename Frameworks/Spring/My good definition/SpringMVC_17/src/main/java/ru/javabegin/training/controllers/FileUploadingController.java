package ru.javabegin.training.controllers;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Controller
@Slf4j
public class FileUploadingController {

    @PostMapping("/uploadFile")
    @ResponseBody
    public String uploadFile(@RequestParam("file") MultipartFile file){
        String name = null;

        if(!file.isEmpty()){
            try{
                byte[] bytes = file.getBytes();

                name = file.getOriginalFilename();

                String rootPath = System.getProperty("catalina.home");
                File dir = new File(rootPath + File.separator + "tmpFiles");

                if(!dir.exists()){
                    dir.mkdirs();
                }

                File uploadFile = new File(dir.getAbsolutePath() + File.separator + name);

                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(uploadFile));
                stream.write(bytes);
                stream.flush();
                stream.close();

                log.info("uploaded: " + uploadFile.getAbsolutePath());

                return "You successfully uploaded file=" + name;
            } catch (IOException e) {
                return "You failed to upload " + name + "=>" + e.getMessage();
            }
        }
        else {
            return "You failed to upload " + name + " because the file was empty.";
        }

    }

}
