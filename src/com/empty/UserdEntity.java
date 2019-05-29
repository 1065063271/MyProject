package com.empty;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "userd", schema = "tmsql", catalog = "")
public class UserdEntity {
    private int userId;
    private String name;
    private String address;
    private String tel;
    private String birthdate;
    private String relname;

    @Id
    @Column(name = "userId", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "address", nullable = true, length = 50)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "tel", nullable = true, length = 15)
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Basic
    @Column(name = "birthdate", nullable = true, length = 20)
    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    @Basic
    @Column(name = "relname", nullable = true, length = 20)
    public String getRelname() {
        return relname;
    }

    public void setRelname(String relname) {
        this.relname = relname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserdEntity that = (UserdEntity) o;
        return userId == that.userId &&
                Objects.equals(name, that.name) &&
                Objects.equals(address, that.address) &&
                Objects.equals(tel, that.tel) &&
                Objects.equals(birthdate, that.birthdate) &&
                Objects.equals(relname, that.relname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, name, address, tel, birthdate, relname);
    }
}
