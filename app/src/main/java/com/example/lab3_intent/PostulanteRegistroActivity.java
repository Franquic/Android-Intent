package com.example.lab3_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PostulanteRegistroActivity extends AppCompatActivity {

    EditText etDni, etLastname, etNames, etBirthday, etSchool, etCareer;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postulante_registro);

        etDni = findViewById(R.id.et_dni);
        etLastname = findViewById(R.id.et_lastname);
        etNames = findViewById(R.id.et_names);
        etBirthday = findViewById(R.id.et_birth);
        etSchool = findViewById(R.id.et_school);
        etCareer = findViewById(R.id.etReg_career);

        btnRegister = findViewById(R.id.bt_register);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String[] data = new String[6];
                data[0] = etDni.getText().toString();
                data[1] = etLastname.getText().toString();
                data[2] = etNames.getText().toString();
                data[3] = etBirthday.getText().toString();
                data[4] = etSchool.getText().toString();
                data[5] = etCareer.getText().toString();

                Intent intent = new Intent(getApplicationContext(), PostulanteInfoActivity.class);
                intent.putExtra("postulant", data);
                startActivity(intent);
            }
        });
    }
}
