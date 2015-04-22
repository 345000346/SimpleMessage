package com.pgq.simplemessage.DAO;

/**
 * Created by PGQ on 2015-4-21-0021.
 */
public class ListContactsBean {

    public String contact_name;
    public String contact_phone;
    public int contact_id;
    public String sortKey;

    public int getContact_id() {
        return contact_id;
    }

    public void setContact_id(int contact_id) {
        this.contact_id = contact_id;
    }
}
