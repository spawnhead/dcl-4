package net.sam.dcl.modern.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name = "dcl_year_num")
@IdClass(DclYearNumId.class)
public class DclYearNumEntity {

    @Id
    @Column(name = "dcl_year", nullable = false)
    private Integer dclYear;

    @Id
    @Column(name = "dcl_table", nullable = false, length = 64)
    private String dclTable;

    @Column(name = "dcl_num", nullable = false)
    private Integer dclNum;

    public Integer getDclYear() { return dclYear; }
    public void setDclYear(Integer dclYear) { this.dclYear = dclYear; }
    public String getDclTable() { return dclTable; }
    public void setDclTable(String dclTable) { this.dclTable = dclTable; }
    public Integer getDclNum() { return dclNum; }
    public void setDclNum(Integer dclNum) { this.dclNum = dclNum; }
}
