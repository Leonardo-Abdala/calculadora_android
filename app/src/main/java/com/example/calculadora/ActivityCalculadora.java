package com.example.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.calculadora.Calculadora;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivityCalculadora extends AppCompatActivity {

    private Calculadora calculadora;
    private String visor;
    private TextView textViewVisor;
    private boolean zerarVisor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculadora);

        calculadora = new Calculadora();
        visor = "0.0";
        zerarVisor = true;
        textViewVisor = findViewById(R.id.editTextNumber);
        textViewVisor.setText(visor);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void setNumero0(View view){
        if(zerarVisor){
            visor = "0.0";
            zerarVisor = false;
        }else{
            visor = 0 + visor ;
        }

        textViewVisor.setText(visor);
    }

    public void setNumero1(View view){
        if(zerarVisor){
            visor = "1.0";
            zerarVisor = false;
        }else{
            visor = 1 + visor;
        }
        textViewVisor.setText(visor);
    }

    public void setNumero2(View view){
        if(zerarVisor){
            visor = "2.0";
            zerarVisor = false;
        }else{
            visor = 2 + visor;
        }
        textViewVisor.setText(visor);
    }

    public void setNumero3(View view){
        if(zerarVisor){
            visor = "3.0";
            zerarVisor = false;
        }else{
            visor = 3 + visor;
        }
        textViewVisor.setText(visor);
    }

    public void setNumero4(View view){
        if(zerarVisor){
            visor = "4.0";
            zerarVisor = false;
        }else{
            visor = 4 + visor;
        }
        textViewVisor.setText(visor);
    }

    public void setNumero5(View view){
        if(zerarVisor){
            visor = "5.0";
            zerarVisor = false;
        }else{
            visor = 5 + visor;
        }
        textViewVisor.setText(visor);
    }

    public void setNumero6(View view){
        if(zerarVisor){
            visor = "6.0";
            zerarVisor = false;
        }else{
            visor = 6 + visor;
        }
        textViewVisor.setText(visor);
    }

    public void setNumero7(View view){
        if(zerarVisor){
            visor = "7.0";
            zerarVisor = false;
        }else{
            visor = 7 + visor;
        }
        textViewVisor.setText(visor);
    }

    public void setNumero8(View view){
        if(zerarVisor){
            visor = "8.0";
            zerarVisor = false;
        }else{
            visor = 8 + visor;
        }
        textViewVisor.setText(visor);
    }

    public void setNumero9(View view){
        if(zerarVisor){
            visor = "9.0";
            zerarVisor = false;
        }else{
            visor = 9 + visor;
        }
        textViewVisor.setText(visor);
    }

    public void setEnter(View view){
        double numero = Double.parseDouble(textViewVisor.getText().toString());
        calculadora.setNumero(numero);
        calculadora.enter();
        visor = String.valueOf(calculadora.getNumero());
        textViewVisor.setText(visor);
        zerarVisor = true;
    }

    public void setSoma(View view){
        double numero = Double.parseDouble(textViewVisor.getText().toString());
        calculadora.setNumero(numero);
        calculadora.enter();
        calculadora.soma();
        visor = String.valueOf(calculadora.getNumero());
        textViewVisor.setText(visor);
        zerarVisor = true;

    }

    public void setSubtracao(View view){
        double numero = Double.parseDouble(textViewVisor.getText().toString());
        calculadora.setNumero(numero);
        calculadora.enter();
        calculadora.subtracao();
        visor = String.valueOf(calculadora.getNumero());
        textViewVisor.setText(visor);
        zerarVisor = true;
    }

    public void setMultiplicacao(View view){
        double numero = Double.parseDouble(textViewVisor.getText().toString());
        calculadora.setNumero(numero);
        calculadora.enter();
        calculadora.multiplicacao();
        visor = String.valueOf(calculadora.getNumero());
        textViewVisor.setText(visor);
        zerarVisor = true;

    }

    public void setDivisao(View view){
        double numero = Double.parseDouble(textViewVisor.getText().toString());
        calculadora.setNumero(numero);
        calculadora.enter();
        calculadora.divisao();
        visor = String.valueOf(calculadora.getNumero());
        textViewVisor.setText(visor);
        zerarVisor = true;
    }

    public void clear(View view){
        textViewVisor.setText("0.0");
        zerarVisor = true;
    }
}
