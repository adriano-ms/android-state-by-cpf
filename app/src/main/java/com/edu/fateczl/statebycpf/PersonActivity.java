package com.edu.fateczl.statebycpf;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/**
 * @author Adriano M Sanchez
 */
public class PersonActivity extends AppCompatActivity {

    private TextView tvPersonName;
    private TextView tvPersonCpf;
    private TextView tvPersonStates;

    private Button btBack;

    private Person person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_person);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        tvPersonName = findViewById(R.id.tvPersonName);
        tvPersonCpf = findViewById(R.id.tvPersonCpf);
        tvPersonStates = findViewById(R.id.tvPersonStates);

        btBack = findViewById(R.id.btBack);

        setupActivity();
    }

    private void setupActivity(){
        Bundle b = getIntent().getExtras();
        person = new Person(b.getString("name"), b.getString("cpf"));
        tvPersonName.setText(person.getName());
        String cpf = person.getCpf();
        StringBuilder sb = new StringBuilder();
        sb.append(cpf.substring(0, 3)).append(".");
        sb.append(cpf.substring(3, 6)).append(".");
        sb.append(cpf.substring(6, 9)).append("-");
        sb.append(cpf.substring(9, 11));
        tvPersonCpf.setText(sb.toString());
        sb = null;
        StringBuilder sb2 = new StringBuilder();
        person.getStates().forEach(s -> sb2.append(s).append("\n"));
        tvPersonStates.setText(sb2.toString());
        btBack.setOnClickListener(bt -> backActivity());
    }

    private void backActivity(){
        Intent i = new Intent(this, MainActivity.class);
        this.startActivity(i);
        this.finish();
    }
}