package LsysRecursive;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class txt {

    public String inputFromTxt;

    public txt() {
        BufferedReader br = null;
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
            //System.out.println("textfilen er: " + everything); //fortæller os hvad tekstfilen er
            inputFromTxt = everything;
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }

    }

        public String getTxtFile() {
            //return this.inputFromTxt; //når input fra textFil skal virke
           // return "A:ABA,B:BCB,C:ACA"; //så længe vi tester prototypen er det denne linje der virker
            return "A:ABA,B:BCB."; // til test
        }




}





/*
public class txt {
    String textFile = ("A:ABA,B:BCB,C:ACA");

    public String getTxtFile(){
        return textFile;

    }

} */
