package com.example.loginsample_demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int Counter=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = (EditText)findViewById(R.id.editText_Name);
        Password = (EditText)findViewById(R.id.editText_Password);
        Info=(TextView)findViewById(R.id.textView_Info);
        Login=(Button)findViewById(R.id.btn_Login);
        Info.setText("No of attempts remaining: 3");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Name.getText().toString(),Password.getText().toString());
            }
        });

    }
    private void validate(String username,String userpassword){
        if((username.equals("Admin"))&&(userpassword.equals("123456789"))){
            Intent intent=new Intent(MainActivity.this, Main2Activity.class);
            startActivity(intent);
        }else{
               Counter--;
               Info.setText("No of attempts remaining: " + String.valueOf(Counter));
               if(Counter==0){
                   Login.setEnabled(false);
               }
        }
    }
}
