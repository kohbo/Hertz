package com.hackathon.team6.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;
import com.hackathon.team6.R;

/**
 * Created by brian on 1/24/2015.
 */
public class History_Activity extends Activity {

    TableLayout mHistoryTable;
    TextView mIC_Number;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history);

        mHistoryTable = (TableLayout)findViewById(R.id.history_dynamicTable);
        mIC_Number = (TextView)findViewById(R.id.history_IC_NUM);
    }
    public void createRow(){
        TableRow myNewRow= new TableRow(this);
        TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
        myNewRow.setLayoutParams(layoutParams);
        TextView typeView = new TextView(this);
        TextView dateView = new TextView(this);
        TextView numImagesView = new TextView(this);
        Button viewButton = new Button(this);
        myNewRow.addView(typeView);
        myNewRow.addView(dateView);
        myNewRow.addView(numImagesView);
        myNewRow.addView(viewButton);
        mHistoryTable.addView(myNewRow, mHistoryTable.getChildCount()+1);
    }
}
