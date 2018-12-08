package max.pawras.jeroty;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import max.pawras.jeroty.utils.ListAdapter;
import max.pawras.jeroty.utils.Model;
import max.pawras.jeroty.utils.RecyclerItemClickListener;

public class ByProducts extends AppCompatActivity {
    private List<Model> dryProductList;
    private RecyclerView recyclerView;
    private ListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_by_products);
        dryProductList=new ArrayList<Model>();
        init();
    }

    private void init() {
        Toolbar tool = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(tool);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        dryProductList=new ArrayList<Model>();
        setAdapter();
    }

    private void setAdapter() {
        Model dryProduct1=new Model("Scrub");
        Model dryProduct2=new Model("Cleaner");
        Model dryProduct3=new Model("Soap");
        Model dryProduct4=new Model("Jam");
        dryProductList.add(dryProduct1);
        dryProductList.add(dryProduct2);
        dryProductList.add(dryProduct3);
        dryProductList.add(dryProduct4);

        recyclerView = (RecyclerView) findViewById(R.id.by_products);
        listAdapter = new ListAdapter(dryProductList, ByProducts.this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(listAdapter);

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(ByProducts.this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent mIntent=new Intent(ByProducts.this,ProductDetail.class);
                        SharedPreferences mSharedPreferences = getSharedPreferences("applevel", MODE_PRIVATE);
                        SharedPreferences.Editor mEditor = mSharedPreferences.edit();
                        mEditor.putString("sub_product", dryProductList.get(position).getItem());
                        mEditor.commit();
                        startActivity(mIntent);
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        finish();
        return true;
    }
}
