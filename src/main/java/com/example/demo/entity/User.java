package com.example.demo.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users")
@DynamicInsert(true)
@DynamicUpdate(true)
public class User implements Serializable {

    private String uid;
    private int age;
    private String name;
    private String number;
    private String loginname;
    private String password;
    private String serialnumber;
    private String ustatus;
    private String salt;
    private String sex;

    private List<Department> departments;

    public User() {
    }

    public User(String uid, int age, String name, String number,
                String loginname, String password, String serialnumber,
                String ustatus) {
        super();
        this.uid = uid;
        this.age = age;
        this.name = name;
        this.number = number;
        this.loginname = loginname;
        this.password = password;
        this.serialnumber = serialnumber;
        this.ustatus = ustatus;
    }
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "uid", length = 64)
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Column(name = "age", nullable = false, length = 11)
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    @Column(name = "name", nullable = false, length = 10)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "number", nullable = false, length = 20)
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Column(name = "loginname", length = 20)
    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    @Column(name = "password", length = 100, updatable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "serialnumber", nullable = false, length = 20)
    public String getSerialnumber() {
        return serialnumber;
    }

    public void setSerialnumber(String serialnumber) {
        this.serialnumber = serialnumber;
    }

    @Column(name = "ustatus", length = 2)
    public String getUstatus() {
        return ustatus;
    }

    public void setUstatus(String ustatus) {
        this.ustatus = ustatus;
    }

    @Column(name = "salt", length = 20, updatable = false)
    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
    @Column(name = "sex", length = 2, updatable = false)
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }

    // 用户、部门多对多映射
    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "udrelation", joinColumns = {@JoinColumn(name = "uid", nullable = false, updatable = false)}, inverseJoinColumns = {@JoinColumn(name = "did", nullable = false, updatable = false)})
    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }
}