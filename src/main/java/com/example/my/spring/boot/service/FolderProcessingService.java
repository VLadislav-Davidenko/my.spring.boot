package com.example.my.spring.boot.service;

import com.example.my.spring.boot.dto.ReportData;
import com.example.my.spring.boot.dto.SrcFolderInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Comparator;

@Slf4j
@Service
public class FolderProcessingService {

    public ReportData process(SrcFolderInfo folderInfo){
        log.info("Process some data");
        return new ReportData(folderInfo.getFiles().stream()
                .max(Comparator.comparingInt(String::length)).orElse(null), folderInfo.getFiles().size()
        );

    }
}
