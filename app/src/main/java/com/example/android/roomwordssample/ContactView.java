package com.example.android.roomwordssample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ContactView extends AppCompatActivity {
    TextView resultado;
    Button back;
    Button edit;
    Button deletebutton;
    public Contact contacto;
    public static String CONTACTO;
    public static boolean recibir=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_view);

        resultado = findViewById(R.id.resultado);
        back = findViewById(R.id.button_back);
        deletebutton = findViewById(R.id.button_delete);
        edit = findViewById(R.id.button_edit);

        MainActivity.mContactViewModel = new ViewModelProvider(this).get(ContactViewModel.class);


        Intent intent2 = getIntent();
        Bundle b = intent2.getExtras();
        Contact c = (Contact) b.getSerializable(MainActivity.CONTACTO);

        resultado.setText("NOMBRE: " + c.getmName()+"\n");
        resultado.append("TELEFONO: " +c.getmPhone()+"\n");

        contacto = new Contact(c.getmName(), c.getmPhone());

        back.setOnClickListener(new android.view.View.OnClickListener(){
            public void onClick(View v){
                volver(v);
            }});

        deletebutton.setOnClickListener(new android.view.View.OnClickListener(){
            public void onClick(View v){

                MainActivity.mContactViewModel.delete(c);
                volver(v);
            }});


        edit.setOnClickListener(new android.view.View.OnClickListener(){
            public void onClick(View v){
                paginaEditar(v);
            }});
    }



    public void volver(View v){
        Intent intent= new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void paginaEditar(View v){
        Intent intent= new Intent(this,NewContactActivity.class);
        Contact p = new Contact (contacto.getmName().toString(),contacto.getmPhone().toString());
        Bundle b = new Bundle();
        b.putSerializable(CONTACTO, p);
        intent.putExtras(b);
        recibir=true;
        startActivity(intent);
    }
}