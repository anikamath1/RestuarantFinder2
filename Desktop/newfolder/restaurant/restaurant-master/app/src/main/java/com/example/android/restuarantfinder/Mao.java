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

        //create instance of database access class
        dataBaseAccess databaseAccess = dataBaseAccess.getInstance(getApplicationContext());

        databaseAccess.open();

        TextView restName = (TextView) findViewById(R.id.mao);
        TextView restAdd = (TextView)findViewById(R.id.maoAdd);

        Intent intent = getIntent();
        //int pos = intent.getIntExtra("position", -1);
        String name = intent.getStringExtra("restName");


        String rest_name = databaseAccess.getRestName(name);
        databaseAccess.close();

        restName.setText(rest_name);

        final Button startersButton = (Button) findViewById(R.id.starter);
        startersButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(Mao.this, menuMaoStarter.class);
                String buttonText = ((Button)view).getText().toString();
                intent.putExtra("itemType", buttonText);
                startActivity(intent);
            }
        } );

        final Button drinksButton = (Button) findViewById(R.id.drinks);
        drinksButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Mao.this, menuMaoDrinks.class);
                String buttonText = ((Button)view).getText().toString();
                intent.putExtra("itemType", buttonText);
                startActivity(intent);
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




//        dataBaseHelper dbHelper = new dataBaseHelper(this);
//        SQLiteDatabase db = dbHelper.getReadableDatabase(); //to read the data in db
//
////        String projection[] = {"restName", "restAddress"};
//
////        String query = "select * from restDetails_table where restName=" + name + ";";
////
////        Cursor cursor = db.rawQuery(query, projection);
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

