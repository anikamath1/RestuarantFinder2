package com.example.android.restuarantfinder;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Vrindavan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_vrindavan );

        TextView restName = (TextView)findViewById(R.id.vrindavan);
        TextView restAdd = (TextView)findViewById(R.id.vrindavanAdd);

        Intent intent = getIntent();
        String name = intent.getStringExtra("restName");

//        dataBaseHelper dbHelper = new dataBaseHelper(this);
//        SQLiteDatabase db = dbHelper.getReadableDatabase(); //to read the data in db
//
//        String[] projection = {"restID", "restName", "restAddress"};
//        String selection = "restName LIKE ?";
//        String[] selectionArgs = {name};
//        Cursor cursor = db.query("restDetails_table", projection, selection, selectionArgs, null, null, null);
//
//        //Cursor cursor = db.query("restDetails_table", projection, null, null, null, null, null);
//        //cursor.moveToPosition(pos);
//        if(cursor.moveToFirst()){
//            String rest_name = cursor.getString(1);
//            String rest_add = cursor.getString(2);
//            restName.setText(rest_name);
//            restAdd.setText(rest_add);
//        }
//
//        Button placeOrderButton = (Button) findViewById(R.id.placeOrderButton);
//        placeOrderButton.setOnClickListener( new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        } );
    }
}
