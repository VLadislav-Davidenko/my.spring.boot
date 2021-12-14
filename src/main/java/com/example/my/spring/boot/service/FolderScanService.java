package com.example.my.spring.boot.service;


import com.example.my.spring.boot.dto.SrcFolderInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;

@Slf4j
@Service
public class FolderScanService {

    @Value("${report.folder.src}")
    private String folderPath;

    public SrcFolderInfo scan(){
        File folder = new File(folderPath);
        File[] listOfFiles = folder.listFiles();
        ArrayList<String> files = new ArrayList<>();
        if (listOfFiles != null) {
            for (File listOfFile : listOfFiles) {
                log.info(listOfFile.getName());
                files.add(listOfFile.getName());
            }
        } else{
            log.info("Empty");
        }
        log.info("Scan folder: " + folderPath);
        return new SrcFolderInfo(files);
    }
}
