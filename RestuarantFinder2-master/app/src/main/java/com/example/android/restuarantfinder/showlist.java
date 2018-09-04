package com.example.android.restuarantfinder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class showlist extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_showlist);
        NearByPlaces nearByPlaces = new NearByPlaces();
        //JSONArray jsonArray=nearByPlaces.find();
        ArrayList<String> items = new ArrayList<String>();
        for(int i=0 ;i<NearByPlaces.jsonArray.length();i++)
        {
            try {
                JSONObject json_data = NearByPlaces.jsonArray.getJSONObject(i);
                String name = json_data.getString("name");
                items.add(name);
            }catch(Exception e)
            {

            }
        }
        ArrayAdapter<String> mArrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_expandable_list_item_1,items);
        ListView obj = findViewById(R.id.listview);
        obj.setAdapter(mArrayAdapter);

        obj.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView,View view,int position,long arg) {
                if(position == 0)
                {
                    int pos = position;
                    Intent mao = new Intent(showlist.this, Mao.class);
                    mao.putExtra("position", pos);
                    startActivity(mao);
                }
                if(position == 1)
                {
                    int pos = position;
                    Intent vrindavan = new Intent(showlist.this, Vrindavan.class);
                    vrindavan.putExtra("position", pos);
                    startActivity(vrindavan);
                }

            }
        } );
    }
}
