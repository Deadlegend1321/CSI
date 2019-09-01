package com.example.mudit.csi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText u,p;
    Button b;
    TextView tv,tv1,tv2;
    ImageView im;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        u=(EditText)findViewById(R.id.u);
        p=(EditText)findViewById(R.id.p);
        b=(Button)findViewById(R.id.b);
        tv=(TextView)findViewById(R.id.tv);
        tv1=(TextView)findViewById(R.id.tv1);
        tv2=(TextView)findViewById(R.id.tv2);
        im=(ImageView)findViewById(R.id.im);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hui(u.getText().toString(),p.getText().toString());
            }
        });
    }
    void hui(String us,String pass)
    {
        int c=0,d=0,e=0,f=0;
        int l=us.length();
        int l2=pass.length();
        if (l2<8)
        {
            Toast.makeText(this,"Password too weak",Toast.LENGTH_SHORT).show();
        }
        else
        {

            for (int i = 0; i < l2; i++) {
                char ch = pass.charAt(i);
                if (Character.isUpperCase(ch))
                    c++;
                else if (Character.isLowerCase(ch))
                    d++;
                else if (ch == '1' || ch == '2' || ch == '3' || ch == '4' || ch == '5' || ch == '6' || ch == '7' || ch == '8' || ch == '9' || ch == '0')
                    e++;
                else if (ch == '~' || ch == '!' || ch == '@' || ch == '#' || ch == '$' || ch == '%' || ch == '^' || ch == '&' || ch == '*'||ch=='>'||ch=='<'||ch=='_'||ch=='-'||ch=='?')
                    f++;
                else
                    c = c;
            }
            if (c < 1) {
                Toast.makeText(this, "Invalid Password", Toast.LENGTH_SHORT).show();
                tv1.setText("There is no Uppercase character");
            } else if (d < 1) {
                Toast.makeText(this, "Invalid Password", Toast.LENGTH_SHORT).show();
                tv1.setText("There is no Lowercase character");
            } else if (e < 1) {
                Toast.makeText(this, "Invalid Password", Toast.LENGTH_SHORT).show();
                tv1.setText("There is no Number");
            } else if (f < 1) {
                Toast.makeText(this, "Invalid Password", Toast.LENGTH_SHORT).show();
                tv1.setText("There is no Special character");
            } else {
                Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
                Intent j = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(j);
            }
        }
    }
}
