package com.example.ej2calculadoraspli;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.LayoutInflater;
import android.widget.Toast;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    EditText txtNum;
    ImageButton btniCero,btniUno,btniDos,btniTres,btniCuatro,btniCinco,btniSeis,btniSiete,btniOcho,btniNueve;
    ImageButton btniPunto,btniMulti,btniSuma,btniResta,btniDiv,btniIgual;
    String op;
    double Num1,Num2,Result;
    boolean Retorno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtNum=findViewById(R.id.txtndNum);
        btniCero=findViewById(R.id.btniCero);
        btniUno=findViewById(R.id.btniUno);
        btniDos=findViewById(R.id.btniDos);
        btniTres=findViewById(R.id.btniTres);
        btniCuatro=findViewById(R.id.btniCuatro);
        btniCinco=findViewById(R.id.btniCinco);
        btniSeis=findViewById(R.id.btniSeis);
        btniSiete=findViewById(R.id.btniSiete);
        btniOcho=findViewById(R.id.btniOcho);
        btniNueve=findViewById(R.id.btniNueve);
        btniPunto=findViewById(R.id.btniPunto);
        btniSuma=findViewById(R.id.btniSuma);
        btniResta=findViewById(R.id.btniResta);
        btniMulti=findViewById(R.id.btniMulti);
        btniDiv=findViewById(R.id.btniDiv);
        btniIgual=findViewById(R.id.btniIgual);

        Calculadora();
        Operacion();
        Resultado();

    }
    public void Calculadora(){
        btniCero.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                txtNum.setText(txtNum.getText()+"0");
            }
        });
        btniUno.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                txtNum.setText(txtNum.getText()+"1");
            }
        });
        btniDos.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                txtNum.setText(txtNum.getText()+"2");
            }
        });
        btniTres.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                txtNum.setText(txtNum.getText()+"3");
            }
        });
        btniCuatro.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                txtNum.setText(txtNum.getText()+"4");
            }
        });
        btniCinco.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                txtNum.setText(txtNum.getText()+"5");
            }
        });
        btniSeis.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                txtNum.setText(txtNum.getText()+"6");
            }
        });
        btniSiete.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                txtNum.setText(txtNum.getText()+"7");
            }
        });
        btniOcho.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                txtNum.setText(txtNum.getText()+"8");
            }
        });
        btniNueve.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                txtNum.setText(txtNum.getText()+"9");
            }
        });
        btniPunto.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                txtNum.setText(txtNum.getText()+".");
            }
        });

    }

    public void Operacion (){
        btniSuma.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                op="+";
                Num1 = Double.parseDouble(txtNum.getText().toString());
                txtNum.setText("");
            }
        });
        btniResta.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                op="-";
                Num1 = Double.parseDouble(txtNum.getText().toString());
                txtNum.setText("");
            }
        });
        btniMulti.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                op="*";
                Num1 = Double.parseDouble(txtNum.getText().toString());
                txtNum.setText("");
            }
        });
        btniDiv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                op="/";
                Num1 = Double.parseDouble(txtNum.getText().toString());
                txtNum.setText("");
            }
        });
    }
    public boolean valNum (){
        Retorno=true;
        if(txtNum.getText().toString().trim().length()==0)
            Retorno=false;
        return Retorno;

    }
    public void Resultado(){
        btniIgual.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(valNum()){
                    Num2= Double.parseDouble(txtNum.getText().toString());

                    switch (op){
                        case "+":txtNum.setText("");Result=Num1+Num2;break;
                        case "-":txtNum.setText("");Result=Num1-Num2;break;
                        case "*":txtNum.setText("");Result=Num1*Num2;break;
                    }
                    txtNum.setText(String.valueOf(Result));
                    if(op.equals("/")){
                        txtNum.setText("");
                        if(Num2 !=0.0){
                            Result=Num1/Num2;
                            txtNum.setText(String.valueOf(Result));
                        }else
                            txtNum.setText("Infinito");
                    }
                }
                else
                    Toast.makeText(getApplicationContext(),"No dejes Campos Vacios",
                            Toast.LENGTH_LONG).show();
            }
        });
    }
    public void Programador (View view){
        LayoutInflater caratula = getLayoutInflater();
        View mostrar = caratula.inflate(R.layout.programador,null);
        Toast ventana = new Toast(getApplicationContext());
        ventana.setDuration(Toast.LENGTH_LONG);
        ventana.setView(mostrar);
        ventana.show();
    }
    public void Limpiar (View view){
        txtNum.setText("");
        Num1=0;
        Num2=0;
    }
    public void Salir (View view)
    {
        finish();
    }

}