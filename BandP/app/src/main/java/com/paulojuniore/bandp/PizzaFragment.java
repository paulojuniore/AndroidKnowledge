package com.paulojuniore.bandp;

import android.R.layout;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

/**
 * A simple {@link ListFragment} subclass.
 */
public class PizzaFragment extends ListFragment {

    private SQLiteDatabase db;
    private Cursor cursor;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        try {
            SQLiteOpenHelper bitsandpizzasDatabaseHelper = new BitsandPizzasDataBaseHelper(getActivity());
            db = bitsandpizzasDatabaseHelper.getReadableDatabase();

            cursor = db.query("PIZZAS", new String[] {"_id", "NAME"}, null, null, null,
                    null, null);

            CursorAdapter listAdapter = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB) {
                listAdapter = new SimpleCursorAdapter(getActivity(), android.R.layout.simple_list_item_1, cursor,
                        new String[] {"NAME"}, new int[] {android.R.id.text1}, 0);
            }
            setListAdapter(listAdapter);
        } catch (SQLiteException e) {
            Toast.makeText(getActivity(), "Database unavailable", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        cursor.close();
        db.close();
    }
}
