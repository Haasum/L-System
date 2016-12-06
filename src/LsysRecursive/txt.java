package LsysRecursive;

import java.io.*;

/**
 * Denne klasse står for at få indputtet fra vores txt fil. Det indput skal kunne give et axiom og et regelsystem til vores Lsystem
 */

/*
den ene er at ryde op i tekstfil klassen.
Det er kopieret kode, så det ville være fedt at du kunne skrive den igennem/skrive den om, så det var vores egen
fra linje 46 i txt klassen er det udkommenteret.
det er det kode du skal skrive igennem. det er det kode der læser tekstfilen.
 husk evt at kopier path for tekstfilen på din computer, så du kan teste at det virker
 */
public class txt {

    // public String inputFromTxt = "A:F[+F[-A]]-F+F,B:ACA";
    //public String inputFromTxt = null;
    //public String endInput;
    //public StringBuilder endOutput = new StringBuilder();
    //public String txtInput;
    //char letter;
    //String rightSide = "";


    public txt() throws IOException {
        checkTxt();
        // parseTextFile();
    }

    public String checkTxt() throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("C:\\Users\\nanna\\IdeaProjects\\Proto2\\Proto2\\src\\LsysRecursive\\testTxt.txt"));
            StringBuilder sb = new StringBuilder();
            String line;
            line = br.readLine();
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                try {
                    line = br.readLine();
                } catch
                        (IOException e) {
                    e.printStackTrace();
                }
                String inputFromText = sb.toString();
                System.out.println("textfilen er " + inputFromText + "woop woop");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}


    /*public String getTxtInput() throws IOException { //her er outputtet samlet efter randommetoder er kørt
        return this.inputFromTxt; // når input fra textFil skal virke

    }*/

            /*
        }
        try {
            StringBuilder sb = new StringBuilder();
            String line = null;
            try {
                line = br.readLine();
            } catch (IOException) {
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
                e.printStackTrace();*/

             /*public void parseTextFile() {
        for (int i = 0; i < inputFromTxt.length() - 1; i++) {
            char current = inputFromTxt.charAt(i);
            if (inputFromTxt.charAt(i + 1) == ':') {
                char currentLetter = inputFromTxt.charAt(i);
                letter = currentLetter; //NJ
                StringBuilder currentRule = new StringBuilder();
                for (int j = i + 1; j < inputFromTxt.length() - i; j++) {
                    char currentCheck = inputFromTxt.charAt(j);
                    if (currentCheck != ',') {
                        rightSide += currentCheck;
                        System.out.println(rightSide);
                        break;
                    }
                }
            }
        }
    }*/




