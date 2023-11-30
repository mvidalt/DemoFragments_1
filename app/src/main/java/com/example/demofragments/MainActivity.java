package com.example.demofragments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    private UserInfoFragment userInfoFragment;
    private String currentUserName = "Nombre de usuario dinámico"; // Nombre de usuario inicial

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userInfoFragment = UserInfoFragment.newInstance(currentUserName);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, userInfoFragment, "UserInfoFragment")
                    .commit();
        }

        Button btnChangeUser = findViewById(R.id.btnChangeUser);
        btnChangeUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cambiar el nombre de usuario
                currentUserName = "Lil Sekai"; // Puedes cambiar aquí por el nombre que desees
                userInfoFragment.updateUserName(currentUserName);
            }
        });
    }
}