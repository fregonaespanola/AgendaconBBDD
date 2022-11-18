package com.example.android.roomwordssample;

/*
 * Copyright (C) 2017 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Parcelable;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import java.io.Serializable;


public class NewContactActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.example.android.wordlistsql.REPLY";

    private EditText mEditNameView;
    private EditText mEditPhoneView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_contact);
        mEditNameView = findViewById(R.id.edit_name);
        mEditPhoneView = findViewById(R.id.edit_phone);

        final Button buttonsave = findViewById(R.id.button_save);
        buttonsave.setOnClickListener(view -> {
            Intent replyIntent = new Intent();
            if (TextUtils.isEmpty(mEditNameView.getText()) && TextUtils.isEmpty(mEditPhoneView.getText())) {
                setResult(RESULT_CANCELED, replyIntent);
            } else {
               String name = mEditNameView.getText().toString();
               String phone = mEditPhoneView.getText().toString();
               Contact c = new Contact(name, phone);
               Bundle b = new Bundle();
                b.putSerializable(EXTRA_REPLY,c);
                replyIntent.putExtras(b);
                setResult(RESULT_OK, replyIntent);
            }
            finish();
        });
    }
}

