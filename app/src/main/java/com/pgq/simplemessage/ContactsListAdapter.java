package com.pgq.simplemessage;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pgq.simplemessage.DAO.ListContactsBean;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by PGQ on 2015-4-21-0021.
 */
public class ContactsListAdapter extends RecyclerView.Adapter<ContactsListAdapter.ViewHolder> {
    private List<ListContactsBean> mDataset;

    /**
     * This class contains all butterknife-injected Views & Layouts from layout file 'listcontacts_item.xml'
     * for easy to all layout elements.
     *
     * @author ButterKnifeZelezny, plugin for Android Studio by Avast Developers (http://github.com/avast)
     */

    /**
     * This class contains all butterknife-injected Views & Layouts from layout file 'listcontacts_item.xml'
     * for easy to all layout elements.
     *
     * @author ButterKnifeZelezny, plugin for Android Studio by Avast Developers (http://github.com/avast)
     */

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @InjectView(R.id.iv_img)
        ImageView mIvImg;
        @InjectView(R.id.tv_name)
        TextView mTvName;
        @InjectView(R.id.tv_phoneNumber)
        TextView mTvPhoneNumber;
        @InjectView(R.id.list_item)
        LinearLayout mListItem;

        ViewHolder(View view) {
            super(view);
            ButterKnife.inject(this, view);
        }
    }

    public ContactsListAdapter(List<ListContactsBean> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                         int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listcontacts_item, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
//        holder.mIvImg.setImageResource();
        final ListContactsBean item = mDataset.get(position);

        holder.mTvName.setText(item.getName());
        holder.mTvPhoneNumber.setText(item.getPhoneNumber());
        holder.mListItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strPhoneNumber = item.getPhoneNumber();
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+strPhoneNumber));
                v.getContext().startActivity(intent);
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }


}