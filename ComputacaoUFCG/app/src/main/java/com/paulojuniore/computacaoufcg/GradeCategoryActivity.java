package com.paulojuniore.computacaoufcg;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class GradeCategoryActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ListView listView = getListView();
        ArrayAdapter<Grade> listAdapter = new ArrayAdapter<Grade>(
                this, android.R.layout.simple_list_item_1, Grade.subjects);

        listView.setAdapter(listAdapter);
    }
}
