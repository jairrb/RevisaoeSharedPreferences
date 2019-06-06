package br.com.digitalhouse.revisaoesharedpreferences.login.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import br.com.digitalhouse.revisaoesharedpreferences.R;
import br.com.digitalhouse.revisaoesharedpreferences.home.view.HomeActivity;

public class LoginActivity extends AppCompatActivity {

    private TextInputLayout textInputLayoutEmail;
    private TextInputLayout textInputLayoutPassword;
    private Switch switchRemember;
    private Button btnLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();

        final SharedPreferences preferences = getSharedPreferences("APP", MODE_PRIVATE);

        textInputLayoutEmail.getEditText().setText(preferences.getString("EMAIL",""));
        textInputLayoutPassword.getEditText().setText(decrypt(preferences.getString("PASSWORD","")));

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (switchRemember.isChecked()){
                    String email = textInputLayoutEmail.getEditText().getText().toString();
                    String password = textInputLayoutPassword.getEditText().getText().toString();

                    preferences.edit().putString("EMAIL",email).commit();
                    preferences.edit().putString("PASSWORD",encrypt(password)).commit();
                }

                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(intent);

            }
        });


    }

    private void initViews() {
        textInputLayoutEmail = findViewById(R.id.textInputLayoutEmail);
        textInputLayoutPassword = findViewById(R.id.textInputLayoutPassword);
        switchRemember = findViewById(R.id.switchRemember);
        btnLogin = findViewById(R.id.btnLogin);
    }

    public String encrypt(String input) {
        return Base64.encodeToString(input.getBytes(), Base64.DEFAULT);
    }

    public String decrypt(String input) {
        return new String(Base64.decode(input, Base64.DEFAULT));
    }
}
