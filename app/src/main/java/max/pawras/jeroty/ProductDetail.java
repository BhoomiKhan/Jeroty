package max.pawras.jeroty;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ProductDetail extends AppCompatActivity {

    private EditText mQuantity, mPrice;
    private Button done;
    private String product, subProduct, subSubProduct,district,quantity, price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        mQuantity=(EditText)findViewById(R.id.quantity);
        mPrice=(EditText)findViewById(R.id.price);
        done=(Button)findViewById(R.id.done);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantity=mQuantity.getText().toString();
                price=mPrice.getText().toString();
                SharedPreferences mSharedPreferences = getSharedPreferences("applevel", MODE_PRIVATE);
               district= mSharedPreferences.getString("district","none");
               product= mSharedPreferences.getString("product","none");
               subProduct= mSharedPreferences.getString("sub_product","none");
               subSubProduct= mSharedPreferences.getString("sub_sub_product","none");
                Toast.makeText(ProductDetail.this, product+" "+subProduct+" "+subSubProduct, Toast.LENGTH_SHORT).show();
                sendSMS("+923003234046");
            }
        });
    }

    public void sendSMS(String phoneNo) {
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNo, null, "District: "+district+"\nProduct: "+product+"\nSub Product: "+subProduct+"\nQuantity: "+quantity+ "\n price: "+price, null, null);
            Toast.makeText(getApplicationContext(), "Dfs",
                    Toast.LENGTH_LONG).show();
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(),ex.getMessage().toString(),
                    Toast.LENGTH_LONG).show();
            ex.printStackTrace();
        }
    }
}
