package LsysRecursive;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Denne klasse står for at få indputtet fra vores txt fil. Det indput skal kunne give et axiom og et regelsystem til vores Lsystem
 */
public class txt {

    public String inputFromTxt;

    public txt() {
     /*  BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("C:\\Users\\naja\\IdeaProjects\\GITHUB\\Proto2\\src\\LsysRecursive\\testTxt.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            StringBuilder sb = new StringBuilder();
            String line = null;
            try {
                line = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                try {
                    line = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            String everything = sb.toString();
            System.out.println("textfilen er: " + everything); //fortæller os hvad tekstfilen er
            inputFromTxt = everything;
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } */

    }

        public String getTxtFile() { //her laves tekstfilen om til en string, der kan tilgås fra andre klasser
          // return this.inputFromTxt; // når input fra textFil skal virke
            return "A:ABA,B:BCB,C:ACA,"; // til test
        }




}