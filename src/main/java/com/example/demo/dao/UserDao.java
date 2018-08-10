package com.example.demo.dao;

import com.example.demo.entity.User;
import com.example.demo.page.pagedata.ChartBean;
import com.example.demo.page.pagedata.CrossTabBean;
import com.example.demo.page.pagedata.HistogramBean;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * 描述：定义dao层方法，操作用户信息
 * Created by xiaohe on 2017/6/23.
 */
public interface UserDao extends CrudRepository<User, String> {
    /**
     * 查询所有状态正常的用户信息
     *
     * @return List<User>对象集合
     */

    @Query("select u from User u")/**在@Query中使用SpEL表达式*/
    public List<User> findAllUser();/**查询所有用户信息*/
    /**
     * 查询所有状态正常的用户信息
     *
     * @return List<User>对象集合
     */
    @Query(value = "select u.age as age,u.sex as sex,u.uid as uid from User u")
    public List<ChartBean> findChartField();/**查询所有用户指定字段信息，不暴露其他信息*/

    /**
     * 查询所有用户信息，并投影到柱状图接口
     *
     * @return List<HistogramBean>柱状图投影接口对象集合
     */
    @Query(value = "select count(u.uid) as statistics,u.age as age,u.sex as sex from User u group by sex,age")
    public List<HistogramBean> findAllBy();/**查询所有用户指定字段信息，不暴露其他信息*/
    /**
     * 查询用户信息，并投影到交叉报表接口
     *
     * @return List<CrossTabBean>交叉报表投影接口对象集合
     */
    @Query(value = "select u.uid as uid,u.age as age,u.sex as sex,u.name as name from User u")
    public List<CrossTabBean> findCrossUser();/**查询所有用户指定字段信息，不暴露其他信息*/
}
