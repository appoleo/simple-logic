package com.ami.study.export;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author wangchendong
 * @date 2021/08/19
 */
public class CSVExport {

    /**
     * RFC4180-由RFC 4180定义的逗号分隔格式。
     * 默认-与RFC4180格式相似，但是允许在数据行之间插入空行。如果在使用Apache Commons CSV库定义解析器时未另外指定，则使用此格式。
     * EXCEL-与RFC 4180类似，但是允许缺少列名，并且忽略空行。
     * TDF -CSV文件的预定义格式，用制表符（\t）代替逗号分隔。
     * MYSQL -MySqlSELECT INTO OUTFILE和LOAD DATA INFILE操作支持的格式。
     * ORACLE -Oracle SQL加载程序使用的CSV格式。
     * INFORMIX_UNLOAD和INFORMIX_UNLOAD_CSV-定义为与IBM Informix可嵌入数据库一起使用的特殊格式。
     * MONGODB_CSV和MONGODB_TSV-与杨木NoSQL MongoDB数据库配合使用，分别用于逗号分隔和制表符分隔的值。
     * POSTGRESQL_CSV和POSTGRESQL_TEXT -PostgreSQL数据库支持的格式。
     *
     * @param response HttpServletResponse
     * @throws IOException when write error
     */
    public static void export(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Disposition", "attachment; filename=\"test.csv\"");
        CSVFormat csvFormat = CSVFormat.EXCEL.builder().setHeader("姓名", "年龄", "家乡").build();
        try (PrintWriter writer = response.getWriter()){
            CSVPrinter csvPrinter = new CSVPrinter(writer, csvFormat);
            for (int i = 0; i < 10; i++) {
                csvPrinter.printRecord("张三", 20, "湖北");
            }
            csvPrinter.printRecord("张张三张三张三张三张,三张三张三张三张三张三三", 20, "湖北");
        }
    }
}
