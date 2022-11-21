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
    private ContactViewModel mContactViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_view);

        resultado = findViewById(R.id.resultado);
        back = findViewById(R.id.button_back);
        deletebutton = findViewById(R.id.button_delete);

        mContactViewModel = new ViewModelProvider(this).get(ContactViewModel.class);


        Intent intent2 = getIntent();
        Bundle b = intent2.getExtras();
        Contact c = (Contact) b.getSerializable(MainActivity.CONTACTO);

        resultado.setText("NOMBRE: " + c.getmName()+"\n");
        resultado.append("TELEFONO: " +c.getmPhone()+"\n");

        back.setOnClickListener(new android.view.View.OnClickListener(){
            public void onClick(View v){
                volver(v);
            }});

        deletebutton.setOnClickListener(new android.view.View.OnClickListener(){
            public void onClick(View v){

                mContactViewModel.delete(c);
                volver(v);
            }});
    }

    public void volver(View v){
        Intent intent= new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}