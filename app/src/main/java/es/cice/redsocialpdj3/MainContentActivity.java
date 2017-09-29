package es.cice.redsocialpdj3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainContentActivity extends AppCompatActivity {

    Button button_cambio;
    EditText editTextCambio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_content);




        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        final DatabaseReference database = FirebaseDatabase.getInstance().getReference();

        database.child("user").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List users = new ArrayList();
                for(DataSnapshot userDataSnapshot : dataSnapshot.getChildren()) {
                    EditText editText = (EditText) findViewById(R.id.edittext_change);

                    String name = userDataSnapshot.child("nombre").getValue().toString();
                    Log.d("TAG", "" + userDataSnapshot);
                    Log.d("TAG", "" + name);




                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

         button_cambio = (Button)findViewById(R.id.button_change);
         editTextCambio = (EditText)findViewById(R.id.edittext_change);

         button_cambio.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 database.child("user/2").child("nombre").setValue(editTextCambio.getText().toString());
             }
         });
    }



}


/*

// Read from the database
myRef.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        // This method is called once with the initial value and again
        // whenever data at this location is updated.
        String value = dataSnapshot.getValue(String.class);
        Log.d(TAG, "Value is: " + value);
    }

    @Override
    public void onCancelled(DatabaseError error) {
        // Failed to read value
        Log.w(TAG, "Failed to read value.", error.toException());
    }
});
 */