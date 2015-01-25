package com.hackathon.team6.activities;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.*;
import com.hackathon.team6.R;
import com.hackathon.team6.dataBase.DataBase;
import com.hackathon.team6.dataBase.dataType.Transaction;

import java.util.List;

/**
 * Created by brian on 1/24/2015.
 */
public class History_Activity extends Activity {

    public static List<Transaction> transactions;

    TableLayout mHistoryTable;
    TextView mEIC_Number;
     /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history);

        mHistoryTable = (TableLayout)findViewById(R.id.history_dynamicTable);
        mEIC_Number = (TextView)findViewById(R.id.history_IC_NUM);

        mEIC_Number.setText(String.valueOf(Home_Page.user.getUserId()));
        
        for(Transaction t : transactions){
            createRow(t.getCurrentType().toString(), t.getCreated_on(),String.valueOf(t.getImageListSize()));
    }
    }
    public void createRow(String type, String date, String imageNumber){
        TableRow myNewRow= new TableRow(this);
        TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
        myNewRow.setLayoutParams(layoutParams);
        TextView typeView = new TextView(this);
        TextView dateView = new TextView(this);
        TextView numImagesView = new TextView(this);
        typeView.setText(type);
        dateView.setText(date);
        numImagesView.setText(imageNumber);
        if(mHistoryTable.getChildCount()%2 == 1){
            myNewRow.setBackgroundColor(Color.parseColor("#CCCCCC"));
        }
        Button viewButton = new Button(this);
        myNewRow.addView(typeView);
        myNewRow.addView(dateView);
        myNewRow.addView(numImagesView);
        myNewRow.addView(viewButton);
        viewButton.setText("View");
        mHistoryTable.addView(myNewRow, mHistoryTable.getChildCount());
    }
}
