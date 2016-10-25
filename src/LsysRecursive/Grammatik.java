package LsysRecursive;

import java.util.ArrayList;

public class Grammatik {

    ArrayList<Rule> ruleset;
    char currentLetter;
    String textFile;
    String currRule = "";

    public Grammatik(String textFile) {
        System.out.println("Grammatik is ON");

        this.textFile = textFile + '.';
        readRules();
        ruleset = new ArrayList<Rule>();

    }

    public void readRules() { //læser reglerne og deler dem op i i rule-letter og rule

        for (int i = 0; i < textFile.length()-1; i++) { //kører i textfilens længde

            StringBuilder buildRule = new StringBuilder();

            char current = textFile.charAt(i);



            if (current == ':') {
                currentLetter = textFile.charAt(i - 1); //her tilføjes char til venstre for ':' til currentLetter (=ruleLetter)
            }

            if (current == ',') { //hver gang current er ',' starter sendRules metoden, og buildRule nulstilles
                sendRules();
                buildRule.setLength(0);
            }


             if (textFile.charAt(i+1) != ':' && Character.isLetter(current)) {//hvis current ikke er til venstre for ':' OG current er et bogstav:
                buildRule.append(current); //current appendes til buildRule der er en stringBuilder
                currRule += String.valueOf(buildRule); //currRule får buildRules string //currRule får strengen fra buildRule
            }

            else if (current == '.') { // '.' stopper metoden
                return;
            }

            }
    }

    private void sendRules() { //reglerne sendes. det er også her de skal gemmes
        System.out.println("the rule-letter is " + currentLetter);
        System.out.println("the rule is " + currRule);
        //Rule rule = new Rule(currentLetter, currRule);
        ruleset.add(new Rule(currentLetter, currRule));
        //ruleset.add(rule);
        //System.out.println(ruleset.size());
        currRule = ""; //currRule nulstilles
    }
}



//det næste er fra den gamle grammatik klasse. sletter når vi alle sammen er her.

         /*   for (int j = i + 1; j < textFile.length() - i; j++) {
                    char currPartRule = textFile.charAt(j);
                    if (currPartRule == ',') {
                        break;
                    }
                    else {
                        Character.toString(textFile.charAt(j));
                        System.out.println(textFile.charAt(i - 1));

                    } */

//  currRule += currPartRule;


//det er her den fucker med os
          // Rule rule = new Rule(currentLetter, currRule);
          // ruleset.add(rule);

          //  System.out.println("regelbogstav er: " + currentLetter + " Reglen er: " + currRule);
           // String testRegel = currentLetter + currRule;
           // System.out.println("test reglen er " + testRegel);



        //}

   //     System.out.println("jeg er gemt");

 //   }

//}




