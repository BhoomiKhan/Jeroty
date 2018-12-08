package max.pawras.jeroty;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        init();
    }

    private void init() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i=new Intent(SplashScreen.this,Location.class);
                startActivity(i);
                overridePendingTransition(R.anim.signin_incoming_screen_right_to_mean_position,R.anim.signin_current_screen_move_mean_to_left);
                finish();
            }
        }, 1500);
    }
}