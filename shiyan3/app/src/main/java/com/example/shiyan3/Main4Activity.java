package com.example.shiyan3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.*;
import android.view.*;
import java.util.*;

public class Main4Activity extends AppCompatActivity {
    private String[] names = new String[]
            {"One","Two","Three","Four","Five","Six"};
    private int[] images = new int[]
            {R.drawable.lion,R.drawable.tiger,R.drawable.monkey,R.drawable.dog,R.drawable.cat,R.drawable.elephant};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        List<Map<String,Object>> lists = new ArrayList<>();
        for (int i = 0;i < names.length;i++){
            Map<String,Object> list = new HashMap<>();
            list.put("images",images[i]);
            list.put("names",names[i]);
            lists.add(list);
        }

        ListView list1 = findViewById(R.id.listview);

        SimpleAdapter simpleAdapter = new SimpleAdapter(Main4Activity.this,
                lists, R.layout.activity_list,
                new String[] {"names","images"},
                new int[] {R.id.names,R.id.images});
        list1.setAdapter(simpleAdapter);

        ListView listView = findViewById(R.id.listview);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        listView.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position,
                                                  long id, boolean checked) {

            }
            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                return false;
            }
            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                MenuInflater inflater = mode.getMenuInflater();
                inflater.inflate(R.menu.context_menu, menu);
                return true;
            }
            @Override
            public void onDestroyActionMode(ActionMode mode) {
            }
            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                // Here you can perform updates to the CAB due to
                // an <code><a href="/reference/android/view/ActionMode.html#invalidate()">invalidate()</a></code> request
                return false;
            }
        });

    }
}
