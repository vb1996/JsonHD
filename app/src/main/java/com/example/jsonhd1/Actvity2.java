package com.example.jsonhd1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class Actvity2 extends AppCompatActivity {

    Button rtbtn;
    TextView showdatatv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actvity2);

        showdatatv= findViewById(R.id.showdatatv);
        rtbtn = findViewById(R.id.Rtbtn);

        rtbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                FirebaseFirestore db = FirebaseFirestore.getInstance();
                db.collection("Orders").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for(QueryDocumentSnapshot documentSnapshot :task.getResult()) {

                                //showdatatv.setText(documentSnapshot.getData().toString());

                                Item item = documentSnapshot.toObject(Item.class);

                                // item.getName();
                                // item.setPrice(15);
                                // item.setQty(5);
                            }

                        }
                    }
                });
            }
        });
    }
}
