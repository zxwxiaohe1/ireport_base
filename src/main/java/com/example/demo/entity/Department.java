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
@Table(name = "department")
@DynamicInsert(true)
@DynamicUpdate(true)
@NamedEntityGraph(name = "Department.detail", attributeNodes = @NamedAttributeNode("listSubData"))
public class Department implements Serializable {
    private String did;

    private String dname;

    private String dtype;

    private String rank;

    private String dstatus;

    private List<User> listSubData;

    public Department() {
        super();
    }

    public Department(String did, String dname, String dtype, String rank,
                      String dstatus) {
        super();
        this.did = did;
        this.dname = dname;
        this.dtype = dtype;
        this.rank = rank;
        this.dstatus = dstatus;
    }
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "did", length = 64)
    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }
    @Column(name = "dname", nullable = false, length = 20)
    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }
    @Column(name = "dtype", nullable = false, length = 20)
    public String getDtype() {
        return dtype;
    }

    public void setDtype(String dtype) {
        this.dtype = dtype;
    }

    @Column(name = "rank", nullable = false, length = 10)
    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Column(name = "dstatus", length = 2)
    public String getDstatus() {
        return dstatus;
    }

    public void setDstatus(String dstatus) {
        this.dstatus = dstatus;
    }

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "udrelation", joinColumns = { @JoinColumn(name = "did", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "uid", nullable = false, updatable = false) })
    public List<User> getListSubData() {
        return listSubData;
    }

    public void setListSubData(List<User> listSubData) {
        this.listSubData = listSubData;
    }
}