package com.edu.fateczl.statebycpf;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Optional;

/**
 * @author Adriano M Sanchez
 */
public class MainActivity extends AppCompatActivity {

    private EditText etName;
    private EditText etCpf;

    private Button btVerify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etName = findViewById(R.id.etName);
        etCpf = findViewById(R.id.etCpf);
        btVerify = findViewById(R.id.btVerify);
        btVerify.setOnClickListener(bt -> verify());
    }

    private void verify(){
        try {
            String name = etName.getText().toString();
            String cpf = etCpf.getText().toString();
            validate(name, cpf);
            nextActivity(name, cpf);
        } catch (Exception e) {
            new AlertDialog.Builder(this).setTitle(getString(R.string.txt_error_alert_title)).setMessage(e.getMessage()).show();
        }
    }

    private void validate(String name, String cpf) throws Exception {
        if(name.isEmpty() || name.isBlank())
            throw new Exception(getString(R.string.txt_invalid_name_exception));
        if(cpf.length() != 11)
            throw new Exception(getString(R.string.txt_invalid_cpf_exception));
    }

    private void nextActivity(String name, String cpf){
        Bundle b = new Bundle();
        b.putString("name", name);
        b.putString("cpf", cpf);
        Intent i = new Intent(this, PersonActivity.class);
        i.putExtras(b);
        this.startActivity(i);
        this.finish();
    }
}