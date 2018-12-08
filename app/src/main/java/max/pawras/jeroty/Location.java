package max.pawras.jeroty;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import max.pawras.jeroty.utils.CustomSpinnerAdapter;

public class Location extends AppCompatActivity {

    private Spinner districts;
    private String district;
    private ArrayList<String> districtList = new ArrayList<>();
    private boolean doubleBackToExitPressedOnce = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        districts = (Spinner) findViewById(R.id.districts);

        //perform click agaisnt spinner click
        districts.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                district=districtList.get(position);
                SharedPreferences mSharedPreferences = getSharedPreferences("applevel", MODE_PRIVATE);
                Editor mEditor = mSharedPreferences.edit();
                mEditor.putString("district", district);
                mEditor.commit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        Button next=(Button)findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences mSharedPreferences = getSharedPreferences("applevel", MODE_PRIVATE);
                Editor mEditor = mSharedPreferences.edit();
                mEditor.putString("district", district);
                mEditor.commit();
                startActivity(new Intent(Location.this, HomeScreen.class).putExtra("district",district));
                overridePendingTransition(R.anim.signin_incoming_screen_right_to_mean_position,R.anim.signin_current_screen_move_mean_to_left);
            }
        });

        setAdapter();
    }

    public void setAdapter() {
        districtList.add("Hunza");
        districtList.add("Gilgit");
        districtList.add("Astore");
        districtList.add("Nagar");
        districtList.add("Shiger");
        districtList.add("Ghanche");
        districtList.add("Skardu");
        districtList.add("Diamer");
        districtList.add("Kharmong");
        districtList.add("Ghizer");
        CustomSpinnerAdapter mCustomSpinnerAdapter = new CustomSpinnerAdapter(Location.this, districtList);
        districts.setAdapter(mCustomSpinnerAdapter);
    }

    @Override
    public void onBackPressed() {

        if (false) {
        } else {
            if (doubleBackToExitPressedOnce) {
                super.onBackPressed();
                return;
            }
            this.doubleBackToExitPressedOnce = true;
            Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();
            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    doubleBackToExitPressedOnce = false;
                }
            }, 2000);
        }
    }
}
