package com.example.android.arrayadaptertutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ListActivity extends AppCompatActivity {

    public static final String EXTRA_TEXT = "com.example.android.arrayadaptertutorial.EXTRA_TEXT";
            private void startDetailActivity(String text) {
                Intent intent = new Intent(this, DetailActivity.class);
                intent.putExtra(EXTRA_TEXT, text);
                startActivity(intent);
            }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        String[] myArray = {"A.M.", "Being There", "Summerteeth", "Yankee Hotel Foxtrot",
                "A Ghost Is Born", "Kicking Television: Live in Chicago", "Sky Blue Sky",
                "Wilco (The Album)", "The Whole Love", "Star Wars"};

        ArrayAdapter<String> myAdapter = new ArrayAdapter<>(this, R.layout.list_item, myArray);

        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView clickedTextView = (TextView) view.findViewById(R.id.textview);
                String text = clickedTextView.getText().toString();
                startDetailActivity(text);
            }
        });
    }
}
