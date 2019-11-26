package com.sashamakkar.truebasics;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.List;

public class DetailsActivity extends AppCompatActivity {

    TextView tvname, tvage, tvgender, tvcontact, tvemail, tvsubscribe;
    EditText etname, etage, etcontact, etemail;
    RadioButton rb;
    CheckBox cb;
    Button add;
    DatabaseReference rootref;//points to the first key
    HashMap<String,Object> detail;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        tvname = findViewById(R.id.name);
        tvage = findViewById(R.id.age);
        tvgender = findViewById(R.id.gender);
        tvcontact = findViewById(R.id.contact);
        tvemail = findViewById(R.id.email);
        tvsubscribe = findViewById(R.id.subscribe);

        etname = findViewById(R.id.entername);
        etage = findViewById(R.id.enterage);
        etcontact = findViewById(R.id.entercontact);
        etemail = findViewById(R.id.enteremail);

        cb = findViewById(R.id.checkbox);

        rootref= FirebaseDatabase.getInstance().getReference();

        add = (Button) findViewById(R.id.add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Details detail = new Details();

                detail.setName(etname.getText().toString());
                detail.setAge(etage.getText().toString());
                detail.setContact(etcontact.getText().toString());
                detail.setGender(rb.getText().toString());
                detail.setEmail(etemail.getText().toString());
                detail.setSubscribe(cb.getText().toString());

                new FirebaseDatabaseHelper().addDetails(detail, new FirebaseDatabaseHelper.DataStatus() {
                    @Override
                    public void DataIsLoaded(List<Details> details, List<String> keys) {

                    }

                    @Override
                    public void DataIsInserted() {
                        Toast.makeText(DetailsActivity.this, "Details added", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void DataIsUpdated() {

                    }

                    @Override
                    public void DataIsDeleted() {

                    }
                });

                HashMap<String, String> ev = new HashMap<String, String>();

                DatabaseReference newRef = rootref.push();

                String Name = etname.getText().toString();

                String Age = etage.getText().toString();

                String Gender = rb.getText().toString();

                String Contact = etcontact.getText().toString();

                String Email = etemail.getText().toString();

                String Subscribe = cb.getText().toString();



                ev.put("Name",Name);
                ev.put("Age",Age);
                ev.put("Gender",Gender);
                ev.put("Contact",Contact);
                ev.put("Email",Email);
                ev.put("Subscribe",Subscribe);

                newRef.setValue(ev);

                Intent i = new Intent(DetailsActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }

    public void onRadioClick(View view)
    {
        boolean chk = ((RadioButton) view).isChecked();

        switch (view.getId())
        {
            case R.id.gendermale :
                if (chk)
                {
                    rb = (RadioButton) findViewById(R.id.gendermale);
                }
                break;


            case R.id.genderfemale :
                if (chk)
                {
                    rb = (RadioButton) findViewById(R.id.genderfemale);
                }
                break;


            case R.id.genderother :
                if (chk)
                {
                    rb = (RadioButton) findViewById(R.id.genderother);
                }

                break;

            case R.id.default_activity_button:
                rb = (RadioButton) findViewById(R.id.genderother);

                break;

        }
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkbox:
                if (checked){
                    cb = (CheckBox) findViewById(R.id.checkbox);
                }
            else

                break;

        }
    }

}
