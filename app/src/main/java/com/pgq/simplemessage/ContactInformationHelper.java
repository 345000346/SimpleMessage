package com.pgq.simplemessage;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;

import com.pgq.simplemessage.DAO.ListContactsBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cocoa on 2015-4-21-0021.
 */
public class ContactInformationHelper {

    private String id, name, phoneNumber, email;


    public List<ListContactsBean> getContactInformation(Context mContext) {
        List<ListContactsBean> list = new ArrayList<>();

        Uri mContacts = ContactsContract.Contacts.CONTENT_URI;
        ContentResolver contentResolver = mContext.getContentResolver();
        Cursor cursor = contentResolver.query(mContacts, null, null, null, null);
        while (cursor.moveToNext())

        {

            id = cursor.getString(cursor.getColumnIndex(android.provider.ContactsContract.Contacts._ID));
            name = cursor.getString(cursor.getColumnIndex(android.provider.ContactsContract.Contacts.DISPLAY_NAME));

            //获取 Phone Number
            Cursor phoneCursor = contentResolver.query(
                    android.provider.ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                    null, android.provider.ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "=" + id, null, null);
            while (phoneCursor.moveToNext()) {
                ListContactsBean listContactsBean = new ListContactsBean();
                phoneNumber = phoneCursor.getString(
                        phoneCursor.getColumnIndex(android.provider.ContactsContract.CommonDataKinds.Phone.NUMBER));
                listContactsBean.setId(id);
                listContactsBean.setImg("");
                listContactsBean.setName(name);
                listContactsBean.setPhoneNumber(phoneNumber);
                list.add(listContactsBean);
            }
            phoneCursor.close();

        }
        cursor.close();
        return list;
    }
}
