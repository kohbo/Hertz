package com.hackathon.team6.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import com.hackathon.team6.R;

/**
 * Created by brian on 1/24/2015.
 */
public class History_Activity extends Activity {

    ListView history_list;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);

        history_list = (ListView)findViewById(R.id.history_list_view);

    }

}
