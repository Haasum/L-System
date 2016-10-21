package LsysRecursive;

import java.util.ArrayList;

public class Grammatik {

    ArrayList<Rule> ruleset;
    char currentLetter;
    String textFile;

    public Grammatik(String textFile) {
        System.out.println("Grammatik is ON");

        this.textFile = textFile;
        saveRules();
        ruleset = new ArrayList<>();

    }

    public void saveRules() {
        for (int i = 1; i < textFile.length(); i++) {
            String currRule = "";

            char current = textFile.charAt(i);
            if (current == ':') {
                currentLetter = textFile.charAt(i - 1);

                for (int j = i + 1; j < textFile.length() - i; j++) {
                    char currPartRule = textFile.charAt(j);
                    if (currPartRule == ',') {
                        break;
                    }
                    currRule += currPartRule;

                }
            }

//det er her den fucker med os
          // Rule rule = new Rule(currentLetter, currRule);
          // ruleset.add(rule);

            System.out.println("regelbogstav er: " + currentLetter + " Reglen er: " + currRule);
           // String testRegel = currentLetter + currRule;
           // System.out.println("test reglen er " + testRegel);



        }

        System.out.println("jeg er gemt");

    }

}




