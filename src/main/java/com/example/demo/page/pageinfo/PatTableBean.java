package com.example.demo.page.pageinfo;

import com.example.demo.page.pagedata.SubTableInter;

import java.util.List;

/**
 * 描述：父报表bean，定义报表显示字段
 * Created by xiaohe on 2017/6/29.
 */
public class PatTableBean {

    private String did;

    private String dname;

    private String dtype;

    private String rank;

    private String dstatus;
    private List<SubTableBean> listSubData;

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDtype() {
        return dtype;
    }

    public void setDtype(String dtype) {
        this.dtype = dtype;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getDstatus() {
        return dstatus;
    }

    public void setDstatus(String dstatus) {
        this.dstatus = dstatus;
    }
    public List<SubTableBean> getListSubData() {
        return listSubData;
    }

    public void setListSubData(List<SubTableBean> listSubData) {
        this.listSubData = listSubData;
    }
}
