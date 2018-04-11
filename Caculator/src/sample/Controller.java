package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;



public class Controller {

    @FXML
    public TextArea screen_textarea ;
    public Button sum_button;
    public double ANS=0;


    public void sum(ActionEvent event)
    {
        screen_textarea.appendText("+");
    }

    public void sub(ActionEvent event)
    {
        screen_textarea.appendText("-");
    }

    public void mul(ActionEvent event)
    {
        screen_textarea.appendText("*");
    }

    public void div(ActionEvent event)
    {
        screen_textarea.appendText("/");
    }

    public void one(ActionEvent event)
    {
        screen_textarea.appendText("1");
    }

    public void two(ActionEvent event)
    {
        screen_textarea.appendText("2");
    }

    public void three(ActionEvent event)
    {
        screen_textarea.appendText("3");
    }

    public void four(ActionEvent event)
    {
        screen_textarea.appendText("4");
    }

    public void five(ActionEvent event)
    {
        screen_textarea.appendText("5");
    }

    public void six(ActionEvent event)
    {
        screen_textarea.appendText("6");
    }

    public void seven(ActionEvent event)
    {
        screen_textarea.appendText("8");
    }

    public void eight(ActionEvent event)
    {
        screen_textarea.appendText("8");
    }

    public void nice(ActionEvent event)
    {
        screen_textarea.appendText("9");
    }

    public void zero(ActionEvent event)
    {
        screen_textarea.appendText("0");
    }

    public void openparentheses(ActionEvent event)
    {
        screen_textarea.appendText("(");
    }

    public void closeparentheses(ActionEvent event)
    {
        screen_textarea.appendText(")");
    }

    public void percent(ActionEvent event)
    {
        screen_textarea.appendText("%");
    }

    public void sin(ActionEvent event)
    {
        screen_textarea.appendText("sin");
    }

    public void cos(ActionEvent event)
    {
        screen_textarea.appendText("cos");
    }

    public void tan(ActionEvent event)
    {
        screen_textarea.appendText("tan");
    }

    public void cot(ActionEvent event)
    {
        screen_textarea.appendText("cot");
    }

    public void dot(ActionEvent event)
    {
        screen_textarea.appendText(".");
    }

    public void AC(ActionEvent event)
    {
        screen_textarea.clear();
    }

    public void delete(ActionEvent event)
    {
        if(screen_textarea.getText().length()!=0)

        screen_textarea.setText(screen_textarea.getText(0,screen_textarea.getText().length()-1));
    }

    public void pow(ActionEvent event)
    {
        screen_textarea.appendText("^");
    }

    public void ans(ActionEvent event)
    {
        screen_textarea.appendText(String.valueOf(ANS));
    }

    public void result(ActionEvent event)
    {

            boolean Erro=false;
            for(String s: Funcion.erro)
            {
                if(screen_textarea.getText().matches(s))
                {
                    Erro=true;
                    break;
                }
            }

            if(!Erro)
            {
                screen_textarea.setText(String.valueOf(Funcion.computepostifixMultipleDigit(Funcion.getpostifixmultipledigit(Funcion.getarrayinfix(screen_textarea.getText())))));
                ANS=Double.valueOf(screen_textarea.getText());

            }
            else screen_textarea.setText("erro!");
    }

}
