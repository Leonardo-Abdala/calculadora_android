package com.example.calculadora;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Optional;
import java.util.function.BiFunction;

public class Calculadora {

    public static final int MODO_EDITANDO = 0;
    public static final int MODO_EXIBINDO = 1;
    public static final int MODO_ERRO = 2;
    private double numero;
    private Deque<Double> operandos;
    private int modo = MODO_EXIBINDO;
    private double pv = 0.0;
    private double fv = 0.0;
    private double pmt = 0.0;
    private double i = 0.0;
    private double n = 0.0;
    private boolean feitoCalculo = false;

    public Calculadora() {
        numero = 0;
        operandos = new LinkedList<>();
    }

    public void setNumero(double numero) {
        this.numero = numero;
        modo = MODO_EDITANDO;
    }

    public double getNumero() {
        return numero;
    }

    public int getModo() {
        return modo;
    }

    public void enter() {
        if (modo == MODO_ERRO) {
            modo = MODO_EXIBINDO;
        }
        if (modo == MODO_EDITANDO) {
            operandos.push(numero);
            modo = MODO_EXIBINDO;
        }
    }

    protected void executarOperacao(BiFunction<Double, Double, Double> operacao) {
        if (modo == MODO_EDITANDO || modo == MODO_ERRO) {
            enter();
        }
        double op1 = Optional.ofNullable(operandos.pollFirst()).orElse(0.0);
        double op2 = Optional.ofNullable(operandos.pollFirst()).orElse(0.0);
        numero = operacao.apply(op1, op2);
        operandos.push(numero);
    }
    public void soma() {
        executarOperacao((op1, op2) -> op1 + op2);
    }

    public void subtracao() {
        executarOperacao((op1, op2) ->  op2 - op1 );
    }

    public void multiplicacao() {
        executarOperacao((op1, op2) -> op1 * op2);
    }

    public void divisao() {
        if (modo == MODO_EDITANDO) {
            enter();
        }
        double denominador = Optional.ofNullable(operandos.peek()).orElse(0.0);
        if (denominador == 0) {
            modo = MODO_ERRO;
            return;
        }
        executarOperacao((op1, op2) -> op2 / op1);
    }

    public void calcularJurosCompostos(int encontrar){
        if (modo == MODO_ERRO) {
            modo = MODO_EXIBINDO;
        }

        if(!feitoCalculo){ // significa que ainda não foi calculado os juros depois que um ou mais valores foram alterados
            switch (encontrar){
            /*
            0 encontrar PV
            1 encontrar FV
            2 encontrar i
            3 encontrar n
            4 encontrar PMT
            */

                case 0:
                    pv = fv/Math.pow(1+i/100, n);
                    feitoCalculo = true;
                    break;

                case 1:
                    fv = pv * (Math.pow(1+i/100, n));
                    feitoCalculo = true;
                    break;

                case 2:
                    i = Math.pow((fv/pv), 1/n) - 1;
                    feitoCalculo = true;
                    break;

                case 3:
                    n = Math.log(fv / pv) / Math.log(1 + i/100);
                    feitoCalculo = true;
                    break;

                case 4:
                    pmt = (pv*i/100)/(1-Math.pow((1+i/100),-n));
                    feitoCalculo = true;
                    break;

                case 5:
                    n = (Math.log(pmt / (pmt - pv * i/100))/Math.log(1 + i/100));
                    feitoCalculo = true;
                    break;

                case 6:
                    pv = (pmt * (1 - Math.pow(1 + i/100, -n))) / (i/100);
                    feitoCalculo = true;
                    break;
            }
        }

    }

    public void setPV(double numero){
        pv = numero;
        modo = MODO_EXIBINDO;
        feitoCalculo = false;
    }

    public void setFV(double numero){
        fv = numero;
        modo = MODO_EXIBINDO;
        feitoCalculo = false;
    }

    public void setPMT(double numero){
        pmt = numero;
    }

    public void setI(double numero){
        i = numero;
        modo = MODO_EXIBINDO;
        feitoCalculo = false;
    }

    public void setN(double numero){
        n = numero;
        modo = MODO_EXIBINDO;
        feitoCalculo = false;
    }

    public double getPV() {
        return pv;
    }

    public double getFV() {
        return fv;
    }

    public double getPMT() {
        return pmt;
    }

    public double getI() {
        return i;
    }

    public double getN() {
        return n;
    }

}
