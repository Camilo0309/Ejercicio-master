package com.i001114.ejercicio.Views;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.i001114.ejercicio.Database.Constans;
import com.i001114.ejercicio.Helper.SqliteHelper;
import com.i001114.ejercicio.MainActivity;
import com.i001114.ejercicio.R;

public class RegisterActivity extends AppCompatActivity {
    EditText editTextRegisterName, editTextRegisterPass, getEditTextRegisterEmail;
    SqliteHelper sqliteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editTextRegisterName = (EditText) findViewById(R.id.register_name);
        getEditTextRegisterEmail= (EditText) findViewById(R.id.register_email);
        editTextRegisterPass = (EditText) findViewById(R.id.register_pass);

        sqliteHelper = new SqliteHelper(this, "db_maps", null, 1);
    }

    public void Register(View view){

        SQLiteDatabase db = sqliteHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Constans.TABLE_FIELD_USER_USERNAME, editTextRegisterName.getText().toString());
        values.put(Constans.TABLE_FIELD_USER_EMAIL, getEditTextRegisterEmail.getText().toString());
        values.put(Constans.TABLE_FIELD_USER_PASSWORD, editTextRegisterPass.getText().toString());

        Long idResult = db.insert(Constans.TABLE_NAME_USERS, Constans.TABLE_FIELD_USER_ID, values);

        editTextRegisterName.setText("");
        getEditTextRegisterEmail.setText("");
        editTextRegisterPass.setText("");

        Toast.makeText(this, "REGISTED USER!", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void Login(View view){

        Toast.makeText(this, "Bienvenido", Toast.LENGTH_SHORT).show();

    }
}
