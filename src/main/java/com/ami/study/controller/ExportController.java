package com.ami.study.controller;

import com.ami.study.export.CSVExport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wangchendong
 * @date 2021/08/19
 */
@RestController
@RequestMapping("/export")
public class ExportController {

    @GetMapping("/csv")
    public void exportCsv(HttpServletResponse response) {
        try {
            CSVExport.export(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
