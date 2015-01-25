package com.hackathon.team6.utlities.adapters;

import android.content.Context;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.hackathon.team6.R;
import com.hackathon.team6.dataBase.dataType.Transaction;
import com.hackathon.team6.utlities.image.BitmapManager;
import com.hackathon.team6.utlities.image.Image_Activity;

import java.util.ArrayList;

/**
 * Created by Colin on 1/24/2015.
 */
public class GridViewAdapter extends BaseAdapter {

    ArrayList<AsyncTask> tasks;
    Transaction transaction;
    Context context;
    LayoutInflater inflater;
    boolean deleteButtons;
    Image_Activity parent;

    public GridViewAdapter(Context context, Transaction transaction, boolean deleteButtons, Image_Activity parent) {
        super();
        this.context = context;
        this.transaction = transaction;
        this.parent = parent;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        tasks = new ArrayList<AsyncTask>();
        this.deleteButtons = deleteButtons;
    }

    @Override
    public int getCount() {
        if(transaction == null || transaction.getUris() == null){
            return 0;
        }
        //if using the adapter for the capture class, use delete buttons and make room for the add picture button
        return transaction.getUris().size() + (deleteButtons ? 1 : 0);
    }

    @Override
    public Object getItem(int i) {
        return transaction.getUris().get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View newView;

        if(i == 0 && deleteButtons){
            newView = inflater.inflate(R.layout.gridview_add_item,viewGroup,false);
        }
        else {
            //-1 accounts for add photo position
            final int position;
            if(deleteButtons) {
                position = i - 1;
            }
            else {
                position = i;
            }

            newView = inflater.inflate(R.layout.gridview_item,viewGroup,false);

            ImageView iv = (ImageView) newView.findViewById(R.id.gridView_item_imageView);

            Button b = (Button) newView.findViewById(R.id.gridView_item_button);

            if(!deleteButtons){
                b.setVisibility(View.GONE);
            }
            else {
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        transaction.getUris().remove(position);
                        parent.updateCount();
                        notifyDataSetChanged();
                    }
                });
            }

            if(transaction.getUris().get(position) != null){
                tasks.add(BitmapManager.setImageView(iv, context, transaction.getUris().get(position), 120, 120));
            }

            iv.setFocusable(false);

            iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }
        return newView;
    }
}
