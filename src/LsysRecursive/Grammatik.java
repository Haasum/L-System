package LsysRecursive;

import java.util.ArrayList;

public class Grammatik {

    ArrayList<Rule> ruleset;
    char currentLetter;
    String textFile;
    String currRule = "";

    public Grammatik(String textFile) {
        System.out.println("Grammatik is ON");

        this.textFile = textFile;
        saveRules();
        ruleset = new ArrayList<>();

    }

    public void saveRules() {
        for (int i = 1; i < textFile.length(); i++) {

            StringBuilder buildRule = new StringBuilder();

            char current = textFile.charAt(i);
            if (current == ':') {
                currentLetter = textFile.charAt(i - 1);
            }
            if (current == ',') {
                sendRules();
            }

            if (current == '.') {
                break;
            }
            else if (current != ':') { // ellers, hvis current ikke er , eller " så skal den appendes til buildRule, der er en stringbuilder

                buildRule.append(current);
                currRule += String.valueOf(buildRule); //currRule får buildRules string


            }



            }





        /*
        Det her virker ikke. dvs den gemmer ikke reglen. Vi havde svært ved at få det til at virke, da RULE-klassen
        er lidt rodet/ikke virker.

        Rule rule = new Rule(currentLetter, currRule);
        ruleset.add(rule);

        */





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

                }

    private void sendRules() {
        System.out.println("the rule-letter is " + currentLetter);
        System.out.println("the rule is " + currRule);
        currRule = "";
    }
}

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




