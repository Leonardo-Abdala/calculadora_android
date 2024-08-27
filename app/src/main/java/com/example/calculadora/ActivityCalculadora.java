package com.example.calculadora;

import static android.text.Selection.getSelectionStart;

import static com.example.calculadora.Calculadora.MODO_EXIBINDO;

import android.app.Activity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
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
    private boolean numerosDepoisDoPonto;
    private StringBuilder stringBuilderVisor;
    private boolean excluirZero; //depois do usuário excluir todos os números ou tiver setado um número, será atribuído o valor 0 somente para exibir, mas na hora que for digitado um número, esse será o primeiro valor


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculadora);

        calculadora = new Calculadora();
        visor = "0.0";
        numerosDepoisDoPonto = false;
        excluirZero = true;
        textViewVisor = findViewById(R.id.editTextNumber);
        textViewVisor.setText(visor);
        textViewVisor.setInputType(InputType.TYPE_NULL); // ocultar teclado virtual

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void setNumero0(View view){
        if(numerosDepoisDoPonto){
            inserirNumeroDepoisPonto(0);
        }else{
            inserirNumeroAntesPonto(0);
        }
        textViewVisor.setText(visor);
    }

    public void setNumero1(View view){
        if(numerosDepoisDoPonto){
            inserirNumeroDepoisPonto(1);
        }else{
            inserirNumeroAntesPonto(1);
        }
        textViewVisor.setText(visor);
    }

    public void setNumero2(View view){
        if(numerosDepoisDoPonto){
            inserirNumeroDepoisPonto(2);
        }else{
            inserirNumeroAntesPonto(2);
        }
        textViewVisor.setText(visor);
    }

    public void setNumero3(View view){
        if(numerosDepoisDoPonto){
            inserirNumeroDepoisPonto(3);
        }else{
            inserirNumeroAntesPonto(3);
        }

        textViewVisor.setText(visor);
    }

    public void setNumero4(View view){
        if(numerosDepoisDoPonto){
            inserirNumeroDepoisPonto(4);
        }else{
            inserirNumeroAntesPonto(4);
        }
        textViewVisor.setText(visor);
    }

    public void setNumero5(View view){
        if(numerosDepoisDoPonto){
            inserirNumeroDepoisPonto(5);
        }else{
            inserirNumeroAntesPonto(5);
        }
        textViewVisor.setText(visor);
    }

    public void setNumero6(View view){
        if(numerosDepoisDoPonto){
            inserirNumeroDepoisPonto(6);
        }else{
            inserirNumeroAntesPonto(6);
        }
        textViewVisor.setText(visor);
    }

    public void setNumero7(View view){
        if(numerosDepoisDoPonto){
            inserirNumeroDepoisPonto(7);
        }else{
            inserirNumeroAntesPonto(7);
        }
        textViewVisor.setText(visor);
    }

    public void setNumero8(View view){
        if(numerosDepoisDoPonto){
            inserirNumeroDepoisPonto(8);
        }else{
            inserirNumeroAntesPonto(8);
        }
        textViewVisor.setText(visor);
    }

    public void setNumero9(View view){
        if(numerosDepoisDoPonto){
            inserirNumeroDepoisPonto(9);
        }else{
            inserirNumeroAntesPonto(9);
        }
        atualizarVisor();
    }

    public void setEnter(View view){
        calculadora.enter();
        excluirZero = true;
        visor = "0.0";
        semNumerosDepoisPonto();
    }

    public void setSoma(View view){
        double numero = Double.parseDouble(textViewVisor.getText().toString());
        calculadora.setNumero(numero);
        calculadora.enter();
        calculadora.soma();
        visor = String.valueOf(calculadora.getNumero());
        textViewVisor.setText(visor);
        excluirZero = true;
        semNumerosDepoisPonto();

    }

    public void setSubtracao(View view){
        double numero = Double.parseDouble(textViewVisor.getText().toString());
        calculadora.setNumero(numero);
        calculadora.enter();
        calculadora.subtracao();
        visor = String.valueOf(calculadora.getNumero());
        textViewVisor.setText(visor);
        excluirZero = true;
        semNumerosDepoisPonto();
    }

    public void setMultiplicacao(View view){
        double numero = Double.parseDouble(textViewVisor.getText().toString());
        calculadora.setNumero(numero);
        calculadora.enter();
        calculadora.multiplicacao();
        visor = String.valueOf(calculadora.getNumero());
        textViewVisor.setText(visor);
        excluirZero = true;
        semNumerosDepoisPonto();

    }

    public void setDivisao(View view){
        double numero = Double.parseDouble(textViewVisor.getText().toString());
        calculadora.setNumero(numero);
        calculadora.enter();
        calculadora.divisao();
        visor = String.valueOf(calculadora.getNumero());
        textViewVisor.setText(visor);
        excluirZero = true;
        semNumerosDepoisPonto();
    }

    public void clear(View view){
        textViewVisor.setText("0.0");
        excluirZero = true;
        semNumerosDepoisPonto();
    }

    public void setPonto(View view){
        numerosDepoisDoPonto = true;
        visor = visor.substring(0, visor.length() - 1);
    }

    public void semNumerosDepoisPonto(){
        numerosDepoisDoPonto = false;
    }

    private void atualizarVisor(){
        textViewVisor.setText(visor);
    }

    private void inserirNumeroAntesPonto(int numero){
        stringBuilderVisor = new StringBuilder(visor);
        if(excluirZero){
            stringBuilderVisor.replace(0,visor.length(), String.valueOf(numero) + ".0"); // Zerar antes do ponto
            excluirZero = false;
        }else{
            stringBuilderVisor.insert(visor.indexOf("."), numero);
        }

        calculadora.setNumero(Double.parseDouble(stringBuilderVisor.toString()));
        visor = stringBuilderVisor.toString();
    }

    private void inserirNumeroDepoisPonto(int numero){
        stringBuilderVisor = new StringBuilder(visor);
        if(excluirZero){
            stringBuilderVisor.replace(visor.indexOf(".")+1,visor.length(), String.valueOf(numero));
            excluirZero = false;
        }else{
            stringBuilderVisor.insert(visor.length(), numero);
        }
        calculadora.setNumero(Double.parseDouble(stringBuilderVisor.toString()));
        visor = stringBuilderVisor.toString();
    }

    public void apagarNumero(View view){
        stringBuilderVisor = new StringBuilder(visor);
        if(numerosDepoisDoPonto){
            if(stringBuilderVisor.substring(visor.indexOf(".")+1).length() == 1){ // caso seja 1, significa que só existe mais um número depois do ponto, logo para não deixar um vazio, deve-se substituir por 0
                stringBuilderVisor.replace(visor.indexOf(".")+1, visor.indexOf(".")+2, "0");
                excluirZero = true;
            }else{
                stringBuilderVisor.delete(visor.indexOf(".")+1,visor.indexOf(".")+2);
            }
        }else{
            if(stringBuilderVisor.substring(0, visor.indexOf(".")).length() == 1){ // caso seja 1, significa que só existe mais um número antes do ponto, logo para não deixar um vazio, deve-se substituir por 0
                stringBuilderVisor.replace(visor.indexOf(".")-1, visor.indexOf("."), "0");
                excluirZero = true;
            }else{
                stringBuilderVisor.delete(visor.indexOf(".")-1, visor.indexOf("."));
            }
        }

        visor = stringBuilderVisor.toString();
        atualizarVisor();

    }

    public void definirOuCalcularPv(View view){
        int modo = calculadora.getModo();
        if(modo == MODO_EXIBINDO){
            if(calculadora.getPMT() != 0){
                calculadora.calcularJurosCompostos(6);
            }else{
                calculadora.calcularJurosCompostos(0);
            }

        }else{
            calculadora.setPV(Double.parseDouble(textViewVisor.getText().toString()));
        }

        visor = String.valueOf(calculadora.getPV());
        textViewVisor.setText(visor);
        excluirZero = true;
        semNumerosDepoisPonto();
    }

    public void definirOuCalcularFv(View view){
        int modo = calculadora.getModo();
        if(modo == MODO_EXIBINDO){
            calculadora.calcularJurosCompostos(1);
        }else{
            calculadora.setFV(Double.parseDouble(textViewVisor.getText().toString()));
        }

        visor = String.valueOf(calculadora.getFV());
        textViewVisor.setText(visor);
        excluirZero = true;
        semNumerosDepoisPonto();
    }

    public void definirOuCalcularI(View view){
        int modo = calculadora.getModo();
        if(modo == MODO_EXIBINDO){
            calculadora.calcularJurosCompostos(2);
        }else{
            calculadora.setI(Double.parseDouble(textViewVisor.getText().toString()));
        }

        visor = String.valueOf(calculadora.getI());
        textViewVisor.setText(visor);
        excluirZero = true;
        semNumerosDepoisPonto();
    }

    public void definirOuCalcularN(View view){
        int modo = calculadora.getModo();
        if(modo == MODO_EXIBINDO){
            if(calculadora.getPMT() != 0){
                calculadora.calcularJurosCompostos(5);
            }else{
                calculadora.calcularJurosCompostos(3);
            }

        }else{
            calculadora.setN(Double.parseDouble(textViewVisor.getText().toString()));
        }

        visor = String.valueOf(calculadora.getN());
        textViewVisor.setText(visor);
        excluirZero = true;
        semNumerosDepoisPonto();
    }

    public void definirOuCalcularPmt(View view){
        int modo = calculadora.getModo();
        if(modo == MODO_EXIBINDO){
            calculadora.calcularJurosCompostos(4);
        }else{
            calculadora.setPMT(Double.parseDouble(textViewVisor.getText().toString()));
        }

        visor = String.valueOf(calculadora.getPMT());
        textViewVisor.setText(visor);
        excluirZero = true;
        semNumerosDepoisPonto();
    }
}
