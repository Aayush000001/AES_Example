package com.aayushgulia.aes_example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.scottyab.aescrypt.AESCrypt;

import java.security.GeneralSecurityException;

public class MainActivity extends AppCompatActivity {
    String EncryptedMsg;
    String DecryptedMsg;
    EditText et_plainText;
    TextView tv_enc, tv_dec;
    Button btn_submit, btn_decrypt;
    String password = "place your key here";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_enc = findViewById(R.id.tv_enc);
        tv_dec = findViewById(R.id.tv_decrypt);

        et_plainText = findViewById(R.id.et_plainText);

        btn_submit = findViewById(R.id.btn_submit);
        btn_decrypt = findViewById(R.id.btn_decrypt);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(et_plainText.getText().toString())){

                    String plainText = et_plainText.getText().toString().trim();
                    try{

                        EncryptedMsg = AESCrypt.encrypt(password, plainText);
                        tv_enc.setText(EncryptedMsg);

                    }catch (Exception e){
                        Log.d("MainActivityEncryption", "" + e);
                    }
                }
            }
        });

        btn_decrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                    DecryptedMsg = AESCrypt.decrypt(password, EncryptedMsg);
                    tv_dec.setText(DecryptedMsg);

                } catch (GeneralSecurityException e) {

                    e.printStackTrace();
                }
            }
        });
    }
}

