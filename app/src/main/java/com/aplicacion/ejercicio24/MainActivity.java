package com.aplicacion.ejercicio24;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.aplicacion.ejercicio24.Configuraciones.AlertDialogo;
import com.aplicacion.ejercicio24.Configuraciones.SQLiteConexion;
import com.aplicacion.ejercicio24.Configuraciones.Signaturess;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {

    EditText descripcion;
    Button btnGuardar;
    Bitmap imagenGlobal;
    CardView FirmaDigital;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        descripcion = (EditText) findViewById(R.id.txtdescripcion);
        btnGuardar = (Button) findViewById(R.id.btnGuardar);
        FirmaDigital = (CardView) findViewById(R.id.FirmaDigital);

        btnGuardar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(!descripcion.getText().toString().isEmpty())
                {
                    agregarFirma();
                }
                else{
                    Mensaje();
                }
            }
        });
    }

    private void Mensaje() {
        AlertDialogo alerta = new AlertDialogo();
        alerta.show(getSupportFragmentManager(),"Mensaje");
    }

    private void agregarFirma() {
        SQLiteConexion conexion = new SQLiteConexion(this, Signaturess.NameDatabase, null, 1);
        SQLiteDatabase db = conexion.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(Signaturess.descripcion, descripcion.getText().toString());


        ByteArrayOutputStream baos = new ByteArrayOutputStream(10480);

        imagenGlobal.compress(Bitmap.CompressFormat.JPEG, 0 , baos);

        byte[] blob = baos.toByteArray();

        values.put(Signaturess.firmaDigital, blob);

        Long result = db.insert(Signaturess.tablafirma, Signaturess.id, values);

        Toast.makeText(getApplicationContext(), "Registro exitoso " + result.toString()
                ,Toast.LENGTH_LONG).show();

        db.close();

        LimpiarPatalla();
    }

    private void LimpiarPatalla() {
        descripcion.setText("");
        FirmaDigital = (null);
        imagenGlobal = null;
    }

}