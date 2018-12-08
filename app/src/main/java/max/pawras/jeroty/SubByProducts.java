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

public class SubByProducts extends AppCompatActivity {
    private List<Model> subDryProductList;
    private RecyclerView recyclerView;
    private ListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_by_products);
        init();
    }

    private void init() {
        Toolbar tool = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(tool);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        subDryProductList=new ArrayList<Model>();
        setAdapter();
    }

    private void setAdapter() {
        Model dryProduct1=new Model("Halmon ");
        Model dryProduct2=new Model("Hubi  ");
        Model dryProduct3=new Model("Wahpjuchuli ");
        Model dryProduct4=new Model("Lonakpuchlu ");
        Model dryProduct5=new Model("Margulam");
        Model dryProduct6=new Model("Karpochuli");
        Model dryProduct7=new Model("Ambha");
        Model dryProduct8=new Model("Khuchuli");
        Model dryProduct9=new Model("brochuli");


        subDryProductList.add(dryProduct1);
        subDryProductList.add(dryProduct2);
        subDryProductList.add(dryProduct3);
        subDryProductList.add(dryProduct4);
        subDryProductList.add(dryProduct5);
        subDryProductList.add(dryProduct6);
        subDryProductList.add(dryProduct7);
        subDryProductList.add(dryProduct8);
        subDryProductList.add(dryProduct9);

        recyclerView = (RecyclerView) findViewById(R.id.sub_by_products);
        listAdapter = new ListAdapter(subDryProductList, SubByProducts.this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(listAdapter);

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(SubByProducts.this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent mIntent=new Intent(SubByProducts.this,ProductDetail.class);
                        SharedPreferences mSharedPreferences = getSharedPreferences("applevel", MODE_PRIVATE);
                        SharedPreferences.Editor mEditor = mSharedPreferences.edit();
                        mEditor.putString("sub_sub_product", subDryProductList.get(position).getItem());
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
