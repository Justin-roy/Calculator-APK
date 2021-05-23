package com.example.justincalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {
    ImageView btn_0,btn_1,btn_2,btn_3,btn_4,btn_5,btn_6,btn_7,btn_8,btn_9;
    ImageView btn_Dot,btn_Equal,btn_Plus,btn_Minus,btn_Multi,btn_Ac,btn_Mod,btn_extra;
    TextView InputTxt,OutputTxt;
    String data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InputTxt = findViewById(R.id.InputTxt);
        OutputTxt = findViewById(R.id.OutputTxt);
        btn_0 = findViewById(R.id.btn0);
        btn_1 = findViewById(R.id.btn1);
        btn_2 = findViewById(R.id.btn2);
        btn_3 = findViewById(R.id.btn3);
        btn_4 = findViewById(R.id.btn4);
        btn_5 = findViewById(R.id.btn5);
        btn_6 = findViewById(R.id.btn6);
        btn_7 = findViewById(R.id.btn7);
        btn_8 = findViewById(R.id.btn8);
        btn_9 = findViewById(R.id.btn9);
        btn_Dot = findViewById(R.id.btnDot);
        btn_Equal = findViewById(R.id.btnEqual);
        btn_Plus = findViewById(R.id.btnPlus);
        btn_Minus = findViewById(R.id.btnMinus);
        btn_Multi = findViewById(R.id.btnMulti);
        btn_Ac = findViewById(R.id.btnAc);
        btn_Mod = findViewById(R.id.btnMod);
        btn_extra = findViewById(R.id.btnExtra);
        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = InputTxt.getText().toString();
                InputTxt.setText(data+"0");
            }
        });
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = InputTxt.getText().toString();
                InputTxt.setText(data+"1");
            }
        });
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = InputTxt.getText().toString();
                InputTxt.setText(data+"2");
            }
        });
        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = InputTxt.getText().toString();
                InputTxt.setText(data+"3");
            }
        });
        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = InputTxt.getText().toString();
                InputTxt.setText(data+"4");
            }
        });
        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = InputTxt.getText().toString();
                InputTxt.setText(data+"5");
            }
        });
        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = InputTxt.getText().toString();
                InputTxt.setText(data+"6");
            }
        });
        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = InputTxt.getText().toString();
                InputTxt.setText(data+"7");
            }
        });
        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = InputTxt.getText().toString();
                InputTxt.setText(data+"8");
            }
        });
        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = InputTxt.getText().toString();
                InputTxt.setText(data+"9");
            }
        });
        btn_Dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = InputTxt.getText().toString();
                InputTxt.setText(data+".");
            }
        });

        btn_extra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = InputTxt.getText().toString();
                InputTxt.setText(data+"÷");
            }
        });
        btn_Plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = InputTxt.getText().toString();
                InputTxt.setText(data+"+");
            }
        });
        btn_Minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = InputTxt.getText().toString();
                InputTxt.setText(data+"-");
            }
        });
        btn_Multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = InputTxt.getText().toString();
                InputTxt.setText(data+"x");
            }
        });
        btn_Ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputTxt.setText("");
                OutputTxt.setText("");
            }
        });
        btn_Mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = InputTxt.getText().toString();
                InputTxt.setText(data+"%");
            }
        });

        btn_Equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = InputTxt.getText().toString();
                data = data.replaceAll("x","*");
                data = data.replaceAll("%","/100");
                data = data.replaceAll("÷","/");
                Context rhino = Context.enter();
                rhino.setOptimizationLevel(-1);

                String Final_Ans;
                Scriptable scriptable = rhino.initStandardObjects();
                Final_Ans = rhino.evaluateString(scriptable,data,"Javascript",1,null).toString();
                OutputTxt.setText(Final_Ans);
            }
        });

    }
}