package com.example.android.restuarantfinder;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Vrindavan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_vrindavan );

        Intent intent = getIntent();
        int pos = intent.getIntExtra("position", -1);

        dataBaseHelper dbHelper = new dataBaseHelper(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase(); //to read the data in db

        String projection[] = {"restID", "restName"};
        Cursor cursor = db.query("restDetails_table", projection, null, null, null, null, null);
        cursor.moveToPosition(pos);
        String rest_name = cursor.getString(1);


        TextView restName = (TextView) findViewById(R.id.vrindavan);
        restName.setText(rest_name);

        Button placeOrderButton = (Button) findViewById(R.id.placeOrderButton);
        placeOrderButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        } );

    }
}
