package com.i001114.ejercicio;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.i001114.ejercicio.Helper.SqliteHelper;
import com.i001114.ejercicio.Views.MapsActivity;
import com.i001114.ejercicio.Views.RegisterActivity;

public class MainActivity extends AppCompatActivity {

    Button buttonLogin;
    EditText editTextName, editTextPass;
    TextView textViewRegister, editTextForgotPass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        editTextName = (EditText) findViewById(R.id.login_name);
        editTextPass = (EditText) findViewById(R.id.login_pass);
        textViewRegister = (TextView) findViewById(R.id.btn_register);
        editTextForgotPass = (TextView) findViewById(R.id.btn_forgotpass);


    }
    public void OPenRegisterWindow(View view){
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    public void Login(View view){
        SqliteHelper sqliteHelper = new SqliteHelper(this, "db_maps", null, 1);
        SQLiteDatabase db = sqliteHelper.getReadableDatabase();
        String user = editTextName.getText().toString();
        String pass = editTextPass.getText().toString();
        Cursor cursor = db.rawQuery("SELECT username, password from users WHERE username ='" +user+"'and password='"+pass+"'",null);
        if (cursor.moveToFirst()){
            String usuario = cursor.getString(0);
            String contra = cursor.getString(2);
            if (user.equals(usuario) && pass.equals(contra)){
                final AlertDialog.Builder Alerta = new AlertDialog.Builder(this);
                Alerta.setTitle("INGRESO EXITOSO");
                Alerta.setMessage("Bienvenido Sr(a): "+ user);
                Alerta.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                        startActivity(intent);
                        onBackPressed();
                    }
                });
                Alerta.setIcon(R.drawable.icons8_applause_50);
                Alerta.create();
                Alerta.show();

            }
        } else {
            final AlertDialog.Builder Alerta = new AlertDialog.Builder(this);
            Alerta.setTitle("ERROR!");
            Alerta.setMessage("Usuario y/o contraseña Incorrecta");
            Alerta.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    editTextName.setText("");
                    editTextPass.setText("");
                }
            });
            Alerta.setIcon(R.drawable.icons8_warning_shield_50);
            Alerta.create();
            Alerta.show();
        }
    }

    public void ForgotPassword(View view){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
        View mView = getLayoutInflater().inflate(R.layout.dialog_pass, null);
        EditText Email = (EditText) mView.findViewById(R.id.forgotemail);
        TextView Pass = (TextView) mView.findViewById(R.id.clave);
        Button ShowPass = (Button) mView.findViewById(R.id.show_pass);
        Button Back = (Button) mView.findViewById(R.id.forgot_back);

        alertDialog.setView(mView);
        AlertDialog dialog = alertDialog.create();
        dialog.show();



    }



}
