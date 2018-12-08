package max.pawras.jeroty;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class HomeScreen extends AppCompatActivity implements View.OnClickListener {

    private TextView dryProducts, share, byProducts, oilProducts, message,logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        Toolbar tool = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(tool);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //init
        dryProducts=(TextView)findViewById(R.id.dry_products);
        byProducts=(TextView)findViewById(R.id.by_products);
        oilProducts=(TextView)findViewById(R.id.oil_products);

        //listner
        dryProducts.setOnClickListener(this);
        byProducts.setOnClickListener(this);
        oilProducts.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        SharedPreferences mSharedPreferences = getSharedPreferences("applevel", MODE_PRIVATE);
        SharedPreferences.Editor mEditor = mSharedPreferences.edit();
        switch (v.getId()){
            case R.id.dry_products:
                mEditor.putString("product", "dry_products");
                mEditor.commit();
                startActivity(new Intent(HomeScreen.this, DryProducts.class));
                break;
            case R.id.oil_products:
                mEditor.putString("product", "oil_products");
                mEditor.commit();
                startActivity(new Intent(HomeScreen.this, OilProducts.class));
                break;
            case R.id.by_products:
                mEditor.putString("product", "by_products");
                mEditor.commit();
                startActivity(new Intent(HomeScreen.this, ByProducts.class));
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        finish();
        return true;
    }
}