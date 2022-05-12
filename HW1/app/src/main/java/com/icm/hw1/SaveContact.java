package com.icm.hw1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SaveContact extends AppCompatActivity {

    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_contact);
    }

    public void saveContactOnClick(View view) {
        EditText name = (EditText) findViewById(R.id.contactName);
        EditText phone = (EditText) findViewById(R.id.contactPhone);
        Contact contact = new Contact(name.getText().toString(), phone.getText().toString());
        ((Button) findViewById(R.id.saved1)).setText(contact.getName());
        finish();
    }

}