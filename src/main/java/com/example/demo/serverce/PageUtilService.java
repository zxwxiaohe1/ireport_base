package com.example.demo.serverce;

import com.example.demo.dao.DepartmentDao;
import com.example.demo.dao.UserDao;
import com.example.demo.entity.Department;
import com.example.demo.entity.User;
import com.example.demo.page.pagedata.ChartBean;
import com.example.demo.page.pagedata.CrossTabBean;
import com.example.demo.page.pagedata.HistogramBean;
import com.example.demo.page.pagedata.PaTableInter;
import com.example.demo.page.pageinfo.PatTableBean;
import com.example.demo.page.pageinfo.SubTableBean;
import groovy.ui.SystemOutputInterceptor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * 描述：报表页面统计工具服务层
 * Created by xiaohe on 2017/6/23.
 */
@Service
public class PageUtilService {
    @Resource
    private UserDao userDao;
    /**
     * 定义用户dao层服务属性
     */
    @Resource
    private DepartmentDao departmentDao;/**  定义部门dao层服务属性*/

    /**
     * 返回表格信息bean集合
     *
     * @return Set<ChartBean>对象集合
     */
    public Set<User> getTableData() {
        Set<User> set = new HashSet<User>();/**  定义方法返回值，装载表格数据*/
        List<User> listUser = userDao.findAllUser();/**  查询所有用户信息*/
        if (listUser != null) {/** 判断集合是否为空*/
            set.addAll(listUser);
        }
        return set;/**  返回用户Set集合*/
    }

    /**
     * 返回饼状图信息bean集合
     *
     * @return Set<ChartBean>对象集合
     */
    public List<ChartBean> getChatData() {
        return userDao.findChartField();/**  返回饼状图bean集合*/
    }


    /**
     * 返回饼状图信息bean集合
     *
     * @return Set<HistogramBean>对象集合
     */
    public List<HistogramBean> getHistogramData() {
        List<HistogramBean> his = userDao.findAllBy();
        for (int i = 0; i < his.size(); i++) {
            System.out.println("statistics=" + his.get(i).getStatistics() + "age=" + his.get(i).getAge() + "sex=" + his.get(i).getSex());
        }
        return userDao.findAllBy();/** 返回柱状图bean集合*/
    }


    /**
     * 返回父报表数据信息bean集合
     *
     * @return Set<PatTableBean>对象集合
     */
    public Set<PaTableInter> getPretTableData() {
        Set<PaTableInter> listdepartments = departmentDao.findAllBy();
//        Set<PaTableInter> set=new HashSet<PaTableInter>();
        List<PaTableInter> listdepartment=new ArrayList<PaTableInter>(listdepartments);
//        for (int k= 0; k < listdepartmenta.size(); k++) {
//            set.add(listdepartmenta.get(k));
//        }
//        List<PaTableInter> listdepartment=new ArrayList<PaTableInter>(set);
//        for (int i = 0; i < listdepartment.size(); i++) {
//            if()
//        }
        return listdepartments;
    }

    /**
     * 查询用户信息，并投影到交叉报表接口
     *
     * @return List<CrossTabBean>交叉报表投影接口对象集合
     */
    public List<CrossTabBean> getCrossUser() {
        return userDao.findCrossUser();/** 返回柱状图bean集合*/
    }

    /**
     * 简介:返回报表属性集合
     *
     * @return Map<String, Object>
     */
    public Map<String, Object> getIrparameters(){
        /**设置报表页面属性值*/
        Map<String, Object> parameters=new HashMap<String, Object>();
        return parameters;
    }
}
