package com.example.demo.serverce;

import com.example.demo.config.ReportImageServlet;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.*;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.j2ee.servlets.ImageServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

/**
 * 描述：报表页面统计工具服务层
 * Created by xiaohe on 2017/6/23.
 */
@Service
public class ExportIrService {
    /**
     * 导出Excel
     *
     * @throws ClassNotFoundException
     * @throws JRException
     * @throws SQLException
     * @throws FileNotFoundException
     */
    public final void createExcel(HttpServletResponse response, JasperPrint jasperPrint) throws IOException, JRException {
        response.setContentType("application/xls");
        response.setCharacterEncoding("UTF-8");
        /**下载报表文件*/
        response.setHeader("Content-Disposition", "attachment;filename=\"" +
                System.currentTimeMillis() + "" + ".xls\"");
        ServletOutputStream outputStream = response.getOutputStream();
        try {
            /**导出pdf*/
            JExcelApiExporter exporter = new JExcelApiExporter();
            //JRXlsExporter exporter = new JRXlsExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outputStream);
            exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);  /**删除记录最下面的空行*/
            exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);/**删除多余的ColumnHeader*/
            exporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);/**显示边框*/
            exporter.exportReport();
        } finally {
            outputStream.flush();
            outputStream.close();
        }
    }

    /**
     * 导出Pdf
     *
     * @throws ClassNotFoundException
     * @throws JRException
     * @throws SQLException
     * @throws FileNotFoundException
     */
    public final void createPdf(HttpServletResponse response, JasperPrint jasperPrint) throws IOException, JRException {
        response.setContentType("application/pdf");
        response.setCharacterEncoding("UTF-8");
        /**下载报表文件*/
        response.setHeader("Content-Disposition", "attachment;filename=\"" +
                System.currentTimeMillis() + "" + ".pdf\"");
        ServletOutputStream outputStream = response.getOutputStream();
        try {

            /**导出pdf*/
            JRPdfExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outputStream);
            exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);  /**删除记录最下面的空行*/
            exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);/**删除多余的ColumnHeader*/
            exporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);/**显示边框*/
            exporter.exportReport();
        } finally {
            outputStream.flush();
            outputStream.close();
        }
    }

    /**
     * 导出word
     * @throws ClassNotFoundException
     * @throws JRException
     * @throws SQLException
     * @throws FileNotFoundException
     */
    public final void createWord(HttpServletResponse response, JasperPrint jasperPrint) throws IOException, JRException {
        response.setContentType("application/docx");
        response.setCharacterEncoding("UTF-8");
        /**下载报表文件*/
        response.setHeader("Content-Disposition", "attachment;filename=\"" +
                System.currentTimeMillis() + "" + ".docx\"");
        ServletOutputStream outputStream = response.getOutputStream();
        try {

            /**导出Word*/
            JRDocxExporter exporter = new JRDocxExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outputStream);
            exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);  /**删除记录最下面的空行*/
            exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.TRUE);/**删除多余的ColumnHeader*/
            exporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.TRUE);/*显示边框*/
            exporter.exportReport();
        } finally {
            outputStream.flush();
            outputStream.close();
        }
    }

    /**
     * 导出Html
     *
     * @throws ClassNotFoundException
     * @throws JRException
     * @throws FileNotFoundException
     */
    public final void createHtml(HttpServletRequest request,HttpServletResponse response, JasperPrint jasperPrint) throws IOException, JRException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        ServletOutputStream outputStream = response.getOutputStream();
        try {
            /**导出HTML*/
            /**下载报表文件*/
//            response.setHeader("Content-Disposition", "attachment;filename=\"" +
//                    System.currentTimeMillis() + "" + ".html");
            JRHtmlExporter exporter = new JRHtmlExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            request.getSession().setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outputStream);
            exporter.setParameter(JRHtmlExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
            exporter.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN, Boolean.TRUE);
            exporter.setParameter(JRHtmlExporterParameter.IMAGES_URI,"../servlets/image?image=");
            exporter.setParameter(JRExporterParameter.CHARACTER_ENCODING,"UTF-8");
            exporter.exportReport();
        } catch (Exception e ){
            e.printStackTrace();
        }finally {
            outputStream.flush();
            outputStream.close();
        }
    }
}