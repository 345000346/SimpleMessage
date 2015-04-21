package com.pgq.simplemessage.DAO;

/**
 * Created by PGQ on 2015-4-21-0021.
 */
public class ListContactsBean {

    private String id;
    private String img;
    private String name;
    private String phoneNumber;

    public ListContactsBean() {
    }

    public ListContactsBean(String id, String img, String name, String phoneNumber) {
        this.id = id;
        this.img = img;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "ListContactsBean{" +
                "id='" + id + '\'' +
                ", img='" + img + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
