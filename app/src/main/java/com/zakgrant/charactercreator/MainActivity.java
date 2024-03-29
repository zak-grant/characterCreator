package com.zakgrant.charactercreator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;
    EditText txtName;
    EditText txtCharacterClass;
    EditText txtAge;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = mFirebaseDatabase.getReference().child("Character");
        txtName = (EditText) findViewById(R.id.txtName);
        txtCharacterClass = (EditText) findViewById(R.id.txtClass);
        txtAge = (EditText) findViewById(R.id.txtAge);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.save_menu:
                saveCharacter();
                Toast.makeText(this, "Character Saved", Toast.LENGTH_SHORT).show();
                clean();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void saveCharacter() {
        String name = txtName.getText().toString();
        String characterClass = txtCharacterClass.getText().toString();
        String age = txtAge.getText().toString();

        Character character = new Character(name, characterClass, age, "");
        mDatabaseReference.push().setValue(character);
    }

    private void clean() {
        txtName.setText("");
        txtCharacterClass.setText("");
        txtAge.setText("");
        txtName.requestFocus();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.save_menu, menu);
        return true;
    }
}
