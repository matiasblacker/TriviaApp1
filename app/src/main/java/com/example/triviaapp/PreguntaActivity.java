package com.example.triviaapp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class PreguntaActivity extends AppCompatActivity {

    private RadioGroup rgOpciones;
    private Button btnResponder;
    private TextView tvSaludo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta);

        tvSaludo = findViewById(R.id.tvSaludo);
        rgOpciones = findViewById(R.id.rgOpciones);
        btnResponder = findViewById(R.id.btnResponder);

        // Obtener el nombre del usuario
        String nombreUsuario = getIntent().getStringExtra("nombreUsuario");
        tvSaludo.setText("Hola, " + nombreUsuario + "!");

        // Validar y responder
        btnResponder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedOptionId = rgOpciones.getCheckedRadioButtonId();

                if (selectedOptionId == -1) {
                    Toast.makeText(PreguntaActivity.this, "Por favor selecciona una opción", Toast.LENGTH_SHORT).show();
                } else {
                    if (selectedOptionId == R.id.rbOpcion2) {  // Suponiendo que la respuesta correcta es Opción 2
                        mostrarResultado("¡Correcto!", "Has acertado la pregunta, es Dratini.");
                    } else {
                        mostrarResultado("Incorrecto", "Lo siento, esa no es la respuesta correcta :(");
                    }
                }
            }
        });
    }

    private void mostrarResultado(String titulo, String mensaje) {
        new AlertDialog.Builder(this)
                .setTitle(titulo)
                .setMessage(mensaje)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .show();
    }
}