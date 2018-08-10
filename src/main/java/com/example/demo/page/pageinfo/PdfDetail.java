package com.example.demo.page.pageinfo;

/**
 * 描述：报表数据源bean，定义报表需用的所有数据源字段
 * Created by xiaohe on 2017/6/26.
 */

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class PdfDetail {
    private String  detail_image;
    private JRBeanCollectionDataSource table_datas;
    private JRBeanCollectionDataSource chart_Datas;
    private JRBeanCollectionDataSource crosstable_datas;
    private JRBeanCollectionDataSource histogram_Datas;
    private JRBeanCollectionDataSource pretTable_Datas;
    private JRBeanCollectionDataSource subTable_Datas;

    public String getDetail_image() {
        return detail_image;
    }

    public void setDetail_image(String detail_image) {
        this.detail_image = detail_image;
    }

    public JRBeanCollectionDataSource getTable_datas() {

        return table_datas;
    }

    public void setTable_datas(JRBeanCollectionDataSource table_datas) {
        this.table_datas = table_datas;
    }

    public JRBeanCollectionDataSource getCrosstable_datas() {

        return crosstable_datas;
    }

    public void setCrosstable_datas(JRBeanCollectionDataSource crosstable_datas) {
        this.crosstable_datas = crosstable_datas;
    }

    public JRBeanCollectionDataSource getChart_Datas() {

        return chart_Datas;
    }

    public void setChart_Datas(JRBeanCollectionDataSource chart_Datas) {
        this.chart_Datas = chart_Datas;
    }

    public JRBeanCollectionDataSource getHistogram_Datas() {
        return histogram_Datas;
    }

    public void setHistogram_Datas(JRBeanCollectionDataSource histogram_Datas) {
        this.histogram_Datas = histogram_Datas;
    }

    public JRBeanCollectionDataSource getPretTable_Datas() {
        return pretTable_Datas;
    }

    public void setPretTable_Datas(JRBeanCollectionDataSource pretTable_Datas) {
        this.pretTable_Datas = pretTable_Datas;
    }
    public JRBeanCollectionDataSource getSubTable_Datas() {
        return subTable_Datas;
    }

    public void setSubTable_Datas(JRBeanCollectionDataSource subTable_Datas) {
        this.subTable_Datas = subTable_Datas;
    }

}

