package com.example.lab3_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PostulanteInfoActivity extends AppCompatActivity {
    int count = 0;
    private Postulant p1;
    Postulant[] postulants;
    String[] data = new String[10];

    TextView tvDni, tvLastname, tvNames, tvBirthday, tvSchool, tvCareer;
    EditText teSearch;
    Button btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postulante_info);

        teSearch = findViewById(R.id.te_search);
        btnSearch = findViewById(R.id.bt_search);

        data = getIntent().getStringArrayExtra("postulant");
        postulants = new Postulant[10];

        p1 = new Postulant(data[0], data[1], data[2], data[3], data[4], data[5]);
        postulants[count] = p1;

        tvDni = findViewById(R.id.tv_dni);
        tvLastname = findViewById(R.id.tv_lastname);
        tvNames = findViewById(R.id.tv_names);
        tvBirthday = findViewById(R.id.tv_birthday);
        tvSchool = findViewById(R.id.tv_school);
        tvCareer = findViewById(R.id.tv_career);

        if (postulants == null){
            Toast.makeText(this, "Sin registro", Toast.LENGTH_SHORT).show();
        } else {
            tvDni.setText("DNI: "+postulants[count].dni);
            tvLastname.setText("Apellidos: " +postulants[count].lastname);
            tvNames.setText("Nombres: "+postulants[count].names);
            tvBirthday.setText("Nacimiento: "+postulants[count].birthday);
            tvSchool.setText("Colegio: "+postulants[count].school);
            tvCareer.setText("Carrera: "+postulants[count].career);
            count++;
        }

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (Postulant p: postulants){
                    System.err.println(teSearch.getText().toString());
                    if (p != null && p.dni.equals(teSearch.getText().toString())){
                        tvDni.setText("DNI: "+p.dni);
                        tvLastname.setText("Apellidos: "+p.lastname);
                        tvNames.setText("Nombres: "+p.names);
                        tvBirthday.setText("Nacimiento: "+p.birthday);
                        tvSchool.setText("Colegio: "+p.school);
                        tvCareer.setText("Carrera: "+p.career);
                    }
                }

                Toast.makeText(PostulanteInfoActivity.this, "No registrado", Toast.LENGTH_SHORT).show();
                
            }
        });
    }

}

class Postulant {

    String dni, lastname, names, birthday, school, career;

    public Postulant(String dni, String lastname, String names, String birthday, String school, String career){
        this.dni = dni;
        this.lastname = lastname;
        this.names = names;
        this.birthday = birthday;
        this.school = school;
        this.career = career;
    }
}