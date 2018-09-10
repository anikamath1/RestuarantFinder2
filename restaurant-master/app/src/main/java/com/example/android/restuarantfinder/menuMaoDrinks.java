package com.example.android.restuarantfinder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class menuMaoDrinks extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_menu_mao_drinks );

        ListView listViewStarter = (ListView) findViewById(R.id.listViewStarter);
        dataBaseAccess databaseAccess = dataBaseAccess.getInstance(getApplicationContext());
        databaseAccess.open();

        Intent intent = getIntent();
        String buttonText = intent.getStringExtra("itemType");
        List<String> itemName = databaseAccess.getDrinksMao(buttonText);
        databaseAccess.close();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itemName);
        listViewStarter.setAdapter(adapter);
    }
}
