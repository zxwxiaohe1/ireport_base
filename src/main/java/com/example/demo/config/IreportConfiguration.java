package com.example.demo.config;

import com.example.demo.ireport.ApplicationIReportView;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * 描述：报表配置类，配置相关报表bean，代替xml配置
 * Created by xiaohe on 2017/7/5.
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@Configuration
public class IreportConfiguration {
    @Bean
    public ApplicationIReportView applicationIReportView(){  /**注册报表视图报表视图*/
        ApplicationIReportView applicationIReportView=new ApplicationIReportView();
        applicationIReportView.setReportDataKey("jrMainDataSource");  /**设置报表数据源key值引用*/
        return applicationIReportView;
    }
}
