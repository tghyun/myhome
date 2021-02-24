package com.godcoder.myhome.service;

import com.godcoder.myhome.model.Files;
import com.godcoder.myhome.repository.FilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilesService {

    @Autowired
    private FilesRepository filesRepository;

    public void save(Files files){
        Files f = new Files();
        f.setFile_name(files.getFile_name());
        f.setOrig_file_name(files.getOrig_file_name());
        f.setFile_path(files.getFile_path());
        f.setEvent_id(files.getEvent_id());

        filesRepository.save(f);
    }
}
