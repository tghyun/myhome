package com.godcoder.myhome.controller;

import com.godcoder.myhome.model.Event;
import com.godcoder.myhome.model.Files;
import com.godcoder.myhome.repository.EventRepository;
import com.godcoder.myhome.service.FilesService;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.security.Principal;
import java.util.List;
import java.util.Locale;


@Controller
public class FileController {

    @Autowired
    FilesService filesService;

    @Autowired
    EventRepository eventRepository;

    @RequestMapping("/event/fileup")
    public String fileup(HttpServletRequest request, @RequestPart MultipartFile files, Event event,Principal principal) throws Exception{

        eventRepository.save(event);
        int event_id =  eventRepository.findEventId(event.getUser_id(),event.getEvent_type());

        Files file = new Files();

        String sourceFileName = files.getOriginalFilename();
        String sourceFileNameExtension = FilenameUtils.getExtension(sourceFileName).toLowerCase(Locale.ROOT);
        File destinationFile;
        String destinationFileName;
        String fileUrl = System.getProperty("user.dir")+"/eventFile/";

        do{
            destinationFileName = RandomStringUtils.randomAlphabetic(32)+"."+sourceFileNameExtension;
            destinationFile = new File(fileUrl+destinationFileName);
        }while(destinationFile.exists());

        System.out.println("file path final : "+destinationFile);

        destinationFile.getParentFile().mkdirs();
        files.transferTo(destinationFile);

        file.setFile_name(destinationFileName);
        file.setOrig_file_name(sourceFileName);
        file.setFile_path(fileUrl);
        file.setEvent_id(event_id);

        filesService.save(file);

        return "redirect:/";
    }

    @RequestMapping("/event/multi")
    public String uploadMulit(@RequestParam("files") List<MultipartFile> files, Event event, Principal principal) throws Exception{

        eventRepository.save(event);
        int event_id =  eventRepository.findEventId(event.getUser_id(),event.getEvent_type());

       String fileUrl = System.getProperty("user.dir")+"/eventFile/";

        for(MultipartFile file : files){

            String sourceFileName = file.getOriginalFilename();
            String sourceFileNameExtension = FilenameUtils.getExtension(sourceFileName).toLowerCase(Locale.ROOT);
            File destinationFile;
            String destinationFileName;

            do{
                destinationFileName = RandomStringUtils.randomAlphabetic(32)+"."+sourceFileNameExtension;
                destinationFile = new File(fileUrl+destinationFileName);
            }while(destinationFile.exists());


            destinationFile.getParentFile().mkdirs();
            file.transferTo(destinationFile);

            Files file1 = new Files();

            file1.setFile_name(destinationFileName);
            file1.setOrig_file_name(sourceFileName);
            file1.setFile_path(fileUrl);
            file1.setEvent_id(event_id);

            filesService.save(file1);
        }

        return "redirect:/";
    }
}
