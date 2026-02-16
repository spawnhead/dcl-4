package net.sam.dcl.modern.entity;

import java.io.Serializable;
import java.util.Objects;

public class DclYearNumId implements Serializable {

    private Integer dclYear;
    private String dclTable;

    public DclYearNumId() {}

    public DclYearNumId(Integer dclYear, String dclTable) {
        this.dclYear = dclYear;
        this.dclTable = dclTable;
    }

    public Integer getDclYear() { return dclYear; }
    public void setDclYear(Integer dclYear) { this.dclYear = dclYear; }
    public String getDclTable() { return dclTable; }
    public void setDclTable(String dclTable) { this.dclTable = dclTable; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DclYearNumId that = (DclYearNumId) o;
        return Objects.equals(dclYear, that.dclYear) && Objects.equals(dclTable, that.dclTable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dclYear, dclTable);
    }
}
