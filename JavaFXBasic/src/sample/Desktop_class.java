package sample;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Desktop_class {
    //https://docs.oracle.com/javase/7/docs/api/java/awt/Desktop.html
    public static void main(String []args) throws URISyntaxException {

        Desktop desktop=Desktop.getDesktop();
        //	browse(URI uri) : display URI trong trinh duyet mac dinh

        /*
        try {
            //
            desktop.browse(new URI("https://translate.google.com/?hl=vi#en/vi/Suppresses"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        */

        //edit(File file) : mo file de chinh sua

        /*
        try {
            desktop.edit(new File("C:\\Users\\Administrator\\Desktop\\huy.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        */



        //isDesktopSupported()
        //Tests whether this class is supported on the current platform.

        //mail()
        /*
        try {
            desktop.mail();
        } catch (IOException e) {
            e.printStackTrace();
        }
        */

        /*

        try {
            desktop.mail(new URI("https://translate.google.com/?hl=vi#en/vi/Suppresses"));
        } catch (IOException e) {
            e.printStackTrace();
        }


        */

       //	open(File file)
        //Launches the associated application to open the file.

        try {
            desktop.open(new File("C:\\Users\\Administrator\\Desktop\\Lac-Troi-Son-Tung-M-TP.mp3"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
