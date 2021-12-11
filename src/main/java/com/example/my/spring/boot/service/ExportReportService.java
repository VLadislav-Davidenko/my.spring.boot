package com.example.my.spring.boot.service;


import com.example.my.spring.boot.dto.ReportData;
import com.example.my.spring.boot.dto.SrcFolderInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ExportReportService {

    private final FolderScanService folderScanService;
    private final FolderProcessingService folderProcessingService;

    @Value("${report.folder.destination}")
    private String destination;


    public void export(){
        log.info("Start export");
        SrcFolderInfo folderInfo = folderScanService.scan();
        ReportData process = folderProcessingService.process(folderInfo);
        createAndExportReport(process);
    }

    private void createAndExportReport(ReportData data){
        log.info("Export data : {} to file{}", data,  destination);
        //TODO
    }
}
