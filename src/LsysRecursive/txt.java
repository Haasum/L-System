package LsysRecursive;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Denne klasse står for at få indputtet fra vores txt fil. Det indput skal kunne give et axiom og et regelsystem til vores Lsystem
 */
public class txt {

    public String inputFromTxt = "A:ABA,B:BCB,C:ACA,";
    public String endInput;
    public StringBuilder endOutput= new StringBuilder();
    public String txtInput;

    ArrayList<Character> stack = new ArrayList<Character>();

    Map<Integer,String> myMap = new HashMap<Integer,String>();
    //

    public txt() {
        //checkTxt();
        checkRandom();
    }

    /* public void checkTxt() {
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
            System.out.println("textfilen er: " + everything); //fortæller os hvad tekstfilen er
            inputFromTxt = everything;
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    } */

    public String getTxtFile() { //her laves tekstfilen om til en string, der kan tilgås fra andre klasser
        //return this.inputFromTxt; // når input fra textFil skal virke
        return "A:ABA,B:BCB,C:ACA,"; // til test
    }

    public void checkRandom() { //TODO: CheckRandom metoder virker kun hvis tekstfilen har 3 inputs. skal også virke ved 2 og 1 input

        for (int i = 0; i < inputFromTxt.length() - 1; i++) {
            char current = inputFromTxt.charAt(i);
            if (inputFromTxt.charAt(i + 1) == ':') {
                stack.add(current);

                StringBuilder testBuild = new StringBuilder();
                testBuild.append(inputFromTxt.charAt(i+2));
                testBuild.append(inputFromTxt.charAt(i+3));
                testBuild.append(inputFromTxt.charAt(i+4));
                String test = String.valueOf(testBuild);

                myMap.put(stack.size()-1,test);
            }

        }

        if (stack.get(0) == stack.get(1) && stack.get(0) == stack.get(2)) {
            System.out.println("all stacks are the same");
            makerandom(stack.get(0), stack.get(1), stack.get(1), 0,0);
        }
        else if (stack.get(0) == stack.get(1)) {
            System.out.println("letter no 0 & 1 is same");
            endOutput.append(stack.get(2));
            endOutput.append(':');
            endOutput.append(myMap.get(2));
            makerandom(stack.get(0), stack.get(1), '*', 0, 1);
        }
        else if (stack.get(0) == stack.get(2)) {
            System.out.println("letter no 0 & 2 is same");
            endOutput.append(stack.get(1));
            endOutput.append(':');
            endOutput.append(myMap.get(1));
            makerandom(stack.get(0), stack.get(2), '*', 0, 2);
        }
        else if (stack.get(1) == stack.get(2)) {
            System.out.println("letter no 1 & 2 is same");
            endOutput.append(stack.get(0));
            endOutput.append(':');
            endOutput.append(myMap.get(0));
            makerandom(stack.get(1), stack.get(2), '*', 1, 2);
        }
        else {
            System.out.println("none of the letters are the same");
            txtInput = inputFromTxt;
            System.out.println("the end output is " + txtInput);
        }

    }

    public void makerandom(char a, char b, char c, int no1, int no2) {
        if (c == '*') {
            endOutput.append(',');
            endOutput.append(a);
            for (int j = 0; j < 10; j++) {
                Random rand = new Random();
                int x = rand.nextInt(2);
                if (x == 0){endInput = myMap.get(no1);}
                if (x == 1){endInput = myMap.get(no2);}
            }
        }
        else {
            endOutput.append(',');
            endOutput.append(a);
            for (int j = 0; j < 10; j++) {
                Random rand = new Random();
                int x = rand.nextInt(3);
                endInput = myMap.get(x);
            }
    }
        endOutput.append(':' + endInput);
        txtInput = String.valueOf(endOutput);
        System.out.println("the end output is " + txtInput);
    }



    public String getTxtInput() { //her er outputtet samlet efter randommetoder er kørt
        return this.txtInput; // når input fra textFil skal virke
        // return "A:ABA,B:BCB,C:ACA,"; // til test
    }



}

