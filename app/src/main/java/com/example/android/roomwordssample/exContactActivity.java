package com.example.android.roomwordssample;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class exContactActivity extends AppCompatActivity {

    private TextView mTVNameView;
    private TextView mTVPhoneView;
    private Button editButton;
    private Button deleteButton;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex_contact);

        mTVNameView = findViewById(R.id.tv_name);
        mTVPhoneView = findViewById(R.id.tv_phone);
        editButton  = findViewById(R.id.button_edit);
        deleteButton = findViewById(R.id.button_delete);


    }
}
