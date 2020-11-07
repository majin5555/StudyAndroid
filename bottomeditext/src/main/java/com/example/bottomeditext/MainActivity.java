package com.example.bottomeditext;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.code_list);

        listView = new TreeListView(this,initNodeTree());
    }
    public List<NodeResource> initNodeTree(){
        List <NodeResource> list = new ArrayList<NodeResource>();
        NodeResource n1 = new NodeResource(""+-1, ""+0, "���ڵ�,�Լ���0", "dfs", R.drawable.icon_department);
        list.add(n1);
        NodeResource n2 = new NodeResource(""+-1, ""+4, "���ڵ㣬�Լ���4", "dfs", R.drawable.icon_department);
        list.add(n2);
        NodeResource n3 = new NodeResource(""+0, ""+7, "��id��0���Լ���7", "dfs", R.drawable.icon_department);
        list.add(n3);
        NodeResource n4 = new NodeResource(""+7, ""+10, "��id��7���Լ���10", "dfs", R.drawable.icon_department);
        list.add(n4);
        NodeResource n5 = new NodeResource(""+7, ""+14, "��id��7���Լ���14", "dfs", R.drawable.icon_department);
        list.add(n5);
        NodeResource n6 = new NodeResource(""+10, ""+18, "��id��10���Լ���18", "dfs", R.drawable.icon_department);
        list.add(n6);
        NodeResource n7 = new NodeResource(""+4,""+22, "��id��4���Լ���22", "dfs", R.drawable.icon_department);
        list.add(n7);
        return list;
    }
    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();

    }
}
