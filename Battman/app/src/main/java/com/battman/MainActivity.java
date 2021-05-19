package com.battman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.battman.api.AbstractApiListener;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText username = findViewById(R.id.loginInput);
        final EditText password = findViewById(R.id.passwordInput);

        Button loginBtn = findViewById(R.id.loginButton);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameS = username.getText().toString();
                String passwordS = password.getText().toString();

                final Model model = Model.getInstance(MainActivity.this.getApplication());

                model.login(usernameS, passwordS, new AbstractApiListener(){


                    @Override
                    public void onLogin(User user){
                        if (user != null){
                            model.setUser(user);
                            Toast.makeText(MainActivity.this, "user: "+ usernameS+
                                    " has logged in. andblblblba", Toast.LENGTH_LONG ).show();

                            Intent intent = new Intent(MainActivity.this, MainPageActivity.class);
                            startActivity(intent);

//                    Intent intent = new Intent(MainActivity.this, BatteryActivity.class);
//                    startActivity(intent);

                        }
                        else {
                            Toast.makeText(MainActivity.this, "invalid login" +
                                    " or password", Toast.LENGTH_LONG ).show();}

                    }
                });
            }
        });
    }
}