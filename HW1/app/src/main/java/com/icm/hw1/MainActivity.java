package com.icm.hw1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import com.icm.hw1.databinding.ActivityMainBinding;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

private ActivityMainBinding binding;

private Map<Integer, Contact> contacts = new HashMap<>(3);
private Button clicked;

    private EditText numberPad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

     binding = ActivityMainBinding.inflate(getLayoutInflater());
     setContentView(binding.getRoot());
     numberPad = findViewById(R.id.phoneNumber);
     Intent intent = new Intent(this, SaveContact.class);
     findViewById(R.id.saved1).setOnLongClickListener(new View.OnLongClickListener() {
         @Override
         public boolean onLongClick(View view) {
             clicked = findViewById(R.id.saved1);
             intent.putExtra("EXTRA_SAVED", R.id.saved1);
             startActivity(intent);
             return true;
         }
     });
        findViewById(R.id.saved2).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                clicked = findViewById(R.id.saved2);
                intent.putExtra("EXTRA_SAVED", R.id.saved2);
                startActivity(intent);
                return true;
            }
        });
        findViewById(R.id.saved3).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                clicked = findViewById(R.id.saved3);
                intent.putExtra("EXTRA_SAVED", R.id.saved3);
                startActivity(intent);
                return true;
            }
        });
    }

    public void addNumberToView(View view){
        Button button = (Button) view;
        StringBuilder sb = new StringBuilder().append(numberPad.getText()).append(button.getText().toString());
        numberPad.setText(sb.toString());
    }
    public void clearLastCharacter(View view){
        String number = numberPad.getText().toString();
        if(number.length()>0){
            numberPad.setText(number.substring(0, number.length()-1));
        }
    }

    public void addToContacts(Contact contact){
        contacts.put(clicked.getId(), contact);
        clicked.setText(contact.getName());
        destroyClicked();
    }

    public void destroyClicked(){
        clicked = null;
    }

    public void addSavedNumberToView(View view){
        Button saved = (Button) view;
        Contact contact = contacts.get(saved.getId());
        if(contact.getNumber() != null) numberPad.setText(contact.getNumber());
    }

    public void openCall(View view){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        String number = "tel:"+ numberPad.getText().toString();
        intent.setData(Uri.parse(number));
        startActivity(intent);
    }


}