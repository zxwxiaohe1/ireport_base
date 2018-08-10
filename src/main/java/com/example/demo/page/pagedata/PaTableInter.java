package com.example.demo.page.pagedata;

import java.util.List;

/**
 * Created by xiaohe on 2017/7/6.
 */
public interface PaTableInter {
    public String getDid();

    public String getDname();

    public String getDtype();

    public String getRank();

    public String getDstatus();

    public List<SubTableInter> getListSubData();
}
