package sample;

import  javafx.beans.property.*;

class Myinterger
{
    private IntegerProperty number= new SimpleIntegerProperty();

    public int getNumber() {
        return number.get();
    }

    public IntegerProperty numberProperty() {
        return number;
    }

    public void setNumber(int number) {
        this.number.set(number);
    }
}


public class Property_ {


    public static void  main(String []args)
    {
        Myinterger nuber1= new Myinterger();

         nuber1.numberProperty().addListener((observable, oldValue, newValue) -> {
             // ham nay se dc goi neu nhu co su thay doi ve gia tri cua nuber1
             System.out.println("observable : "+observable);
             System.out.println("oldValue : " +observable);
             System.out.println("newValue : "+newValue);

         });

         nuber1.setNumber(1); // co su thay doive gia tri , tai day se quay lai thuc hien ham ben tren


    }

}
