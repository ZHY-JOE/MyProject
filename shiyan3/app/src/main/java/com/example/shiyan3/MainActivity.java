package com.example.shiyan3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import java.util.*;
public class MainActivity extends AppCompatActivity {
    private String[] names = new String[]
            {"Lion","Tiger","Monkey","Dog","Cat","Elephant"};
    private int[] images = new int[]
            {R.drawable.lion,R.drawable.tiger,R.drawable.monkey,R.drawable.dog,R.drawable.cat,R.drawable.elephant};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Map<String,Object>> lists = new ArrayList<>();
        for (int i = 0;i < names.length;i++){
            Map<String,Object> list = new HashMap<>();
            list.put("images",images[i]);
            list.put("names",names[i]);
            lists.add(list);
        }

        ListView list1 = findViewById(R.id.list_main);

        SimpleAdapter simpleAdapter = new SimpleAdapter(MainActivity.this,
                lists, R.layout.activity_list,
                new String[] {"names","images"},
                new int[] {R.id.names,R.id.images});
        list1.setAdapter(simpleAdapter);

        list1.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast toast = Toast.makeText(MainActivity.this,names[position],Toast.LENGTH_SHORT);
                toast.show();
            }
        });

    }
}
