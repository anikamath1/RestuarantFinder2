package com.example.android.restuarantfinder;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageView;

public class Mao extends AppCompatActivity {

    private static final String TAG = "Mao";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_mao );

//        Bundle extras = getIntent().getExtras();
//        if(extras != null){
//            int pos = extras.getInt( "position" );
//        }
        Intent intent = getIntent();
        int pos = intent.getIntExtra("position", -1);

        dataBaseHelper dbHelper = new dataBaseHelper(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase(); //to read the data in db

        String projection[] = {"restID", "restName", "restAddress"};
        Cursor cursor = db.query("restDetails_table", projection, null, null, null, null, null);
        cursor.moveToPosition(pos);
        String rest_name = cursor.getString(1);


        TextView restName = (TextView) findViewById(R.id.mao);
        restName.setText(rest_name);

        ImageView img = (ImageView) findViewById(R.id.maoImage);
        img.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v(TAG, " click");
            }
        } );

        Button placeOrderButton = (Button) findViewById(R.id.placeOrderButton);
        placeOrderButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        } );
    }


}
