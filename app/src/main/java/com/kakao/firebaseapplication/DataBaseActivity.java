package com.kakao.firebaseapplication;

import android.content.DialogInterface;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.kakao.firebaseapplication.models.User;

public class DataBaseActivity extends AppCompatActivity implements View.OnClickListener{

    private String TAG = DataBaseActivity.class.getSimpleName();

    private FirebaseDatabase database;
    private DatabaseReference myRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_base);

        findViewById(R.id.saveButton).setOnClickListener(this);
        findViewById(R.id.readButton).setOnClickListener(this);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("users");
    }



    public FirebaseUser getUser() {
        return FirebaseAuth.getInstance().getCurrentUser();
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        FirebaseUser firebaseUser = getUser();
        String uid = firebaseUser.getUid();

        switch (id){
            case R.id.readButton:
                myRef.child(uid).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        User user = dataSnapshot.getValue(User.class);
                        Log.v(TAG, "onDataChange " + user.email);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Log.v(TAG, "onCancelled");
                    }
                });
                break;
            case R.id.saveButton:
                String email = firebaseUser.getEmail();
                String device = Build.DEVICE;
                User user = new User(email, device);
                myRef.child(uid).setValue(user);
                break;
        }
    }
}
