package com.example.tareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText txtPrecio;
    Spinner spnMarca, spnCantidad;

    Button btnProcesar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtPrecio = (EditText)findViewById(R.id.txtPrecio);
        //spinner de las marcas y cantidades
        spnMarca = (Spinner)findViewById(R.id.spnMarca);
        spnCantidad = (Spinner)findViewById(R.id.spnCantidad);
        btnProcesar = (Button)findViewById(R.id.btnProcesar);

        ArrayList<Marca> marca = new ArrayList<Marca>();
        marca.add(new Marca("Seleccione"));
        marca.add(new Marca("HTC"));
        marca.add(new Marca("HUAWEI"));
        marca.add(new Marca("SAMSUNG"));

        ArrayAdapter<Marca> listaMarca = new ArrayAdapter<>(this, androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item,marca);
        spnMarca.setAdapter(listaMarca);

        //array de las cantidades
        ArrayList<Cantidad> cantidad = new ArrayList<Cantidad>();
        cantidad.add(new Cantidad(1.0));
        cantidad.add(new Cantidad(2.0));
        cantidad.add(new Cantidad(3.0));
        cantidad.add(new Cantidad(4.0));
        cantidad.add(new Cantidad(5.0));
        cantidad.add(new Cantidad(6.0));
        cantidad.add(new Cantidad(7.0));
        cantidad.add(new Cantidad(8.0));
        cantidad.add(new Cantidad(9.0));

        ArrayAdapter<Cantidad> listaCantidad = new ArrayAdapter<>(this, androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item,cantidad);
        spnCantidad.setAdapter(listaCantidad);

        btnProcesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcularResultado();
            }
        });
    }


    @Override
    public void onClick(View view) {
    }


    private void calcularResultado() {
        String marcaSeleccionada = spnMarca.getSelectedItem().toString();
        double valorSeleccionado = Double.parseDouble(spnCantidad.getSelectedItem().toString());
        double precio = Double.parseDouble(txtPrecio.getText().toString());

        if (valorSeleccionado == 0){
            Toast.makeText(this, "Tiene que ingresar el monto", Toast.LENGTH_SHORT).show();
        }
        else{
            double resultado = valorSeleccionado*precio;
            Toast.makeText(this, "La marca es: "+marcaSeleccionada+ "\n" + "La cantidad: " + valorSeleccionado + "\n" + "El total es: " + resultado, Toast.LENGTH_SHORT).show();

        }
    }
}
