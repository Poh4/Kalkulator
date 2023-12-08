package com.example.kalkulator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.EditText;
import android.widget.Spinner;
import android.content.DialogInterface;
import android.widget.Toast;
import android.view.View;
import android.app.AlertDialog;


public class MainActivity extends AppCompatActivity {
    private EditText angka1;
    private EditText angka2;
    private Spinner spinOperasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    angka1 = (EditText) findViewById(R.id.editpertama);
    angka2 = (EditText) findViewById(R.id.editkedua);
    spinOperasi= (Spinner) findViewById(R.id.spinerOperasi);
    }

    public void buttonHandler(View view) {
        double a, b, hasil;
        if (angka1.getText().length() == 0 || angka2.getText().length() == 0) {
            Toast.makeText(this, "Angka Masih Kosong!", Toast.LENGTH_LONG).show();
            return;
        }

        a = Double.parseDouble(angka1.getText().toString());
        b = Double.parseDouble(angka2.getText().toString());
        switch (spinOperasi.getSelectedItemPosition()) {
            case 0:
                hasil = a + b;
                break;
            case 1:
                hasil = a - b;
                break;
            case 2:
                hasil = a * b;
                break;
            case 3:
                hasil = a / b;
                break;
            case 4 :
                hasil = a % b;
                break;
            default:
                hasil = a + b;
                break;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Hasil" + spinOperasi.getSelectedItem().toString());
        builder.setMessage("Hasil" + hasil);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                angka1.setText("");
                angka2.setText("");
                dialog.dismiss();
            }
        });
    AlertDialog dialogHasil = builder.create();
    dialogHasil.show();



    }
}