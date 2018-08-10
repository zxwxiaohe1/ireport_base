package com.example.demo.config;

import net.sf.jasperreports.j2ee.servlets.ImageServlet;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.annotation.WebServlet;

/**
 * Created by xiaohe on 2017/7/15.
 */
@SpringBootConfiguration
public class ReportImageServlet {
    @Bean
    public ServletRegistrationBean imageServlet() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new ImageServlet());
        registration.addUrlMappings("/servlets/image");
        return registration;
    }
}
