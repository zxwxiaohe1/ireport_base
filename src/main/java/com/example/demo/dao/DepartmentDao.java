package com.example.demo.dao;

import com.example.demo.entity.Department;
import com.example.demo.page.pagedata.PaTableInter;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

/**
 * 描述：定义dao层类方法，操作部门信息
 * Created by xiaohe on 2017/6/29.
 */

public interface DepartmentDao extends CrudRepository<Department, String> {

    /**
     * 查询所有状态正常的部门信息
     * @return List<User>对象集合
     */
    @Query("select d from Department d")
    @EntityGraph(value = "Department.detail", type = EntityGraph.EntityGraphType.LOAD)
    public List<Department> findAllDepartmentd();/** 查询所有部门信息*/
    /**
     * 查询所有的部门信息
     * @return List<PaTableInter>对象集合
     */
    public Set<PaTableInter> findAllBy();/** 查询所有部门信息*/
}