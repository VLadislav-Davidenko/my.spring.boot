package com.example.my.spring.boot.service;


import com.example.my.spring.boot.dto.SrcFolderInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class FolderScanService {

    @Value("${report.folder.src}")
    private String folderPath;

    public SrcFolderInfo scan(){
        log.info("Scan folder: " + folderPath);
        // TODO
        SrcFolderInfo result = new SrcFolderInfo(List.of("file", "file2"));
        return result;
    }
}
