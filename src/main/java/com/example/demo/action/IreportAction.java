package com.example.demo.action;

import com.example.demo.serverce.ExportIrService;
import com.example.demo.serverce.PageUtilService;
import com.example.demo.page.pageinfo.PdfDetail;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JExcelApiExporter;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRHtmlExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.support.WebApplicationContextUtils;
import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * 描述：Controller层，处理用户请求并调取服务层方法
 * Created by xiaohe on 2017/6/23.
 */
@Controller
@EnableAutoConfiguration
@RequestMapping(value = "/ireportAction")
@ComponentScan(basePackages = {"com.example.demo.serverce", "com.example.demo.action", "com.example.demo.config"})
public class IreportAction {

    @Resource
    private PageUtilService pageUtilService;/**页面数据服务层属性*/
    @Resource
    private ExportIrService exportIrService;/**报表导出格式服务层属性*/

    /**
     * 返回iReport报表视图，支持PDF显示中文
     * @param model
     */
    @RequestMapping(value = "/reportChs", method = RequestMethod.GET)
    /**数据准备，调用服务层并转化为报表数据*/
    public void reportChs(HttpServletRequest request, HttpServletResponse response,Model model) {
        Set<PdfDetail> list = new HashSet<PdfDetail>();
        PdfDetail detail = new PdfDetail();
//        detail.setDetail_image("classpath:templates/files/images/ireport-background/02.jpg");/**设置图片地址*/
        detail.setTable_datas(new JRBeanCollectionDataSource(pageUtilService.getTableData()));/**将table数据转化为JRBeanCollectionDataSource对象设置到传输数据bean*/
        detail.setCrosstable_datas(new JRBeanCollectionDataSource(pageUtilService.getCrossUser()));/**将交叉报表数据转化为JRBeanCollectionDataSource对象设置到传输数据bean*/
        detail.setChart_Datas(new JRBeanCollectionDataSource(pageUtilService.getChatData()));/**将饼图数据转化为JRBeanCollectionDataSource对象设置到传输数据bean*/
        detail.setHistogram_Datas(new JRBeanCollectionDataSource(pageUtilService.getHistogramData()));/**将柱状图数据转化为JRBeanCollectionDataSource对象设置到传输数据bean*/
//        detail.setPretTable_Datas(new JRBeanCollectionDataSource(pageUtilService.getPretTableData()));/**将子报表数据转化为JRBeanCollectionDataSource对象设置到传输数据bean*/
        list.add(detail);
        /**设置报表数据源*/
        JRDataSource jrDataSource = new JRBeanCollectionDataSource(list);
        /**读取Ireport报表模型*/
        InputStream  jasperPath = IreportAction.class.getResourceAsStream("/templates/files/ireport/report4.jasper");
        try {
//            /**设置报表数据源*/
            JasperPrint jasperPrint =JasperFillManager.fillReport(jasperPath,pageUtilService.getIrparameters(),jrDataSource);
//            /**设置报表导出格式*/
            exportIrService.createHtml(request,response, jasperPrint);
//            JRHtmlExporter exporter_html  =   new  JRHtmlExporter();
//            File reportFile =  WebApplicationContextUtils..getWebApplicationContext().getResource(jasperPrint.toString()).getFile();
//            String imageURI = request.getContextPath() + "/reportFiles/";
//            exporter_html.setParameter(JRHtmlExporterParameter.IMAGES_DIR_NAME, jasperPath);
//            exporter_html.setParameter(JRHtmlExporterParameter.IMAGES_URI, imageURI);
//            exporter_html.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN, Boolean.TRUE);
//            exporter_html.setParameter(JRHtmlExporterParameter.IS_OUTPUT_IMAGES_TO_DIR, Boolean.TRUE);
//            exporter_html.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
//            exporter_html.setParameter(JRExporterParameter.OUTPUT_WRITER, response.getWriter());
//            response.setContentType("text/html");
//            exporter_html.exportReport();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
