package com.ckelsel.android.oschina.bean;

import org.codehaus.jackson.annotate.JsonProperty;

import java.sql.Date;

/**
 * Created by ckelsel on 2015/9/4.
 */
public class ShippingAddress {

    @JsonProperty("user_id")
    private String _user_id;

    @JsonProperty("tel")
    private String _tel;

    @JsonProperty("address")
    private String _address;

    @JsonProperty("zip_code")
    private String _zip_code;

    @JsonProperty("name")
    private String _name;

    @JsonProperty("province")
    private String _province;

    @JsonProperty("city")
    private String _city;

    @JsonProperty("sex")
    private String _sex;

    @JsonProperty("created_at")
    private Date _created_at;

    @JsonProperty("updated_at")
    private Date _updated_at;

    @JsonProperty("comment")
    private String _comment;

    public String getUser_id() {
        return _user_id;
    }

    public void setUser_id(String user_id) {
        this._user_id = user_id;
    }

    public String getTel() {
        return _tel;
    }

    public void setTel(String tel) {
        this._tel = tel;
    }

    public String getAddress() {
        return _address;
    }

    public void setAddress(String address) {
        this._address = address;
    }

    public String getZip_code() {
        return _zip_code;
    }

    public void setZip_code(String zip_code) {
        this._zip_code = zip_code;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        this._name = name;
    }

    public String getProvince() {
        return _province;
    }

    public void setProvince(String province) {
        this._province = province;
    }

    public String getCity() {
        return _city;
    }

    public void setCity(String city) {
        this._city = city;
    }

    public String getSex() {
        return _sex;
    }

    public void setSex(String sex) {
        this._sex = sex;
    }

    public Date getCreated_at() {
        return _created_at;
    }

    public void setCreated_at(Date created_at) {
        this._created_at = created_at;
    }

    public Date getUpdated_at() {
        return _updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this._updated_at = updated_at;
    }

    public String getComment() {
        return _comment;
    }

    public void setComment(String comment) {
        this._comment = comment;
    }
}
