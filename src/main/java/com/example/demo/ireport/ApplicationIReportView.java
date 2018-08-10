package com.example.demo.ireport;

import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.jasperreports.JasperReportsMultiFormatView;

import java.util.Map;

/**
 * Created by xiaohe on 2017/6/23.
 */

public class ApplicationIReportView extends JasperReportsMultiFormatView {

        private JasperReport jasperReport;
    /**
     * ApplicationIReportView无参构造函数
     */
        public ApplicationIReportView() {
            super();
        }
    /**
     * 构造报表信息
     * @Param map集合键值对信息
     * @return JasperPrint对象报表模板
     */
        protected JasperPrint fillReport(Map<String, Object> model) throws Exception {
            if (model.containsKey("url")) {
                setUrl(String.valueOf(model.get("url")));
                this.jasperReport = loadReport();
            }
            return super.fillReport(model);
        }
    /**
     * 获得报表对象
     * @return JasperPrint对象报表模板
     */
        protected JasperReport getReport() {
            return this.jasperReport;
        }
}
