package com.pgq.simplemessage;

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

    Cursor c;

    public List<ListContactsBean> getContactInformation(Context mContext) {
        ArrayList<ListContactsBean> listMembers = new ArrayList<>();
        Cursor cursor = null;
        try {
            Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
            // 这里是获取联系人表的电话里的信息  包括：名字，名字拼音，联系人id,电话号码；
            // 然后在根据"sort-key"排序

            cursor = mContext.getContentResolver().query(uri, new String[]{"display_name", "sort_key", "contact_id", "data1"}, null, null, "sort_key");
            if (cursor.moveToFirst()) {
                do {
                    ListContactsBean contact = new ListContactsBean();
                    String contact_phone = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                    String name = cursor.getString(0);
                    String sortKey = getSortKey(cursor.getString(1));
                    int contact_id = cursor.getInt(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.CONTACT_ID));
                    contact.contact_name = name;
                    contact.sortKey = sortKey;
                    contact.contact_phone = contact_phone;
                    contact.setContact_id(contact_id);
                    if (name != null)
                        listMembers.add(contact);
                } while (cursor.moveToNext());
                c = cursor;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mContext = null;
        }
        return listMembers;

    }

    /**
     * 获取sort key的首个字符，如果是英文字母就直接返回，否则返回#。
     *
     * @param sortKeyString
     *         数据库中读取出的sort key
     * @return 英文字母或者#
     */
    private static String getSortKey(String sortKeyString) {
        String key = sortKeyString.substring(0, 1).toUpperCase();
        if (key.matches("[A-Z]")) {
            return key;
        }
        return "#";
    }
}
