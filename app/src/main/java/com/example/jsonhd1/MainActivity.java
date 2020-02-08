package com.example.jsonhd1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    EditText NameEt, QtyEt, PriceEt;
    Button sendbtn, activity2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NameEt =findViewById(R.id.nameEt);
        QtyEt =findViewById(R.id.qtyEt);
        PriceEt =findViewById(R.id.PriceEt);
        sendbtn =findViewById(R.id.storeBtn);
        activity2 = findViewById(R.id.activity2);



        sendbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //get values from the view
                String name = NameEt.getText().toString();
                int price = Integer.parseInt(PriceEt.getText().toString());
                int qty = Integer.parseInt(QtyEt.getText().toString());

                HashMap<String,String> order = new HashMap<>();

                // adding data to hashmap
                //   order.put("Name",name);
              //  order.put("Price",price+"");
              //  order.put("Qty",qty+"");

                Item item = new Item();
                item.setName(name);
                item.setPrice(price);
                item.setQty(qty);

                // firestore instance

                FirebaseFirestore db = FirebaseFirestore.getInstance();
                db.collection("Orders").add(item);


            }
        });

        activity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Actvity2.class);
                startActivity(intent);
            }
        });
    }
}
