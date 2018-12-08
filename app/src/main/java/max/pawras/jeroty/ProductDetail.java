package max.pawras.jeroty;

import android.Manifest;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

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
               getRunTimePermission();
            }
        });
    }

    private void getRunTimePermission() {
        ActivityCompat.requestPermissions(ProductDetail.this,
                new String[]{Manifest.permission.SEND_SMS},
                1);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {

                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    sendSMS("923003234046");
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Toast.makeText(ProductDetail.this, "Permission denied to read your External storage", Toast.LENGTH_SHORT).show();
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }


    public void sendSMS(String phoneNo) {
        String message = "District: "+district+"\nProduct: "+product+"\nSub Product: "+subProduct+"\nQuantity: "+quantity+ "\n price: "+price;
        try {
            SmsManager sms = SmsManager.getDefault();
            sms.sendTextMessage(phoneNo, null, message , null, null);
            finish();
        } catch (Exception e) {
            Toast.makeText(this, "not send", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }


//    public void sendMySMS() {
//
//        String phone = "923003234046";
//        String message = "District: "+district+"\nProduct: "+product+"\nSub Product: "+subProduct+"\nQuantity: "+quantity+ "\n price: "+price;
//
//        //Check if the phoneNumber is empty
//        if (phone.isEmpty()) {
//            Toast.makeText(getApplicationContext(), "Please Enter a Valid Phone Number", Toast.LENGTH_SHORT).show();
//        } else {
//
//            SmsManager sms = SmsManager.getDefault();
//            // if message length is too long messages are divided
//            List<String> messages = sms.divideMessage(message);
//            for (String msg : messages) {
//
//                PendingIntent sentIntent = PendingIntent.getBroadcast(this, 0, new Intent("SMS_SENT"), 0);
//                PendingIntent deliveredIntent = PendingIntent.getBroadcast(this, 0, new Intent("SMS_DELIVERED"), 0);
//                sms.sendTextMessage(phone, null, msg, sentIntent, deliveredIntent);
//
//            }
//        }
//    }
}
