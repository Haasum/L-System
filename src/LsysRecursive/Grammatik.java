package LsysRecursive;

import java.util.ArrayList;

public class Grammatik {

    ArrayList<Rule> ruleset;
    char currentLetter;
    String textFile;

    public Grammatik(String textFile){

        this.textFile = textFile;
        saveRules();
        ruleset = new ArrayList<>();

    }

    public void saveRules() {
        for(int i=1; i<textFile.length();i++){
            String currRule = "";

            char current = textFile.charAt(i);
            if(current == ':' ){
                currentLetter = textFile.charAt(i-1);

                for(int j = i+1 ; j < textFile.length()-i; j++){
                    char currPartRule = textFile.charAt(j);
                    if (currPartRule == ','){
                        break;
                    }
                    currRule += currPartRule;

                }
            }

            Rule rule = new Rule(currentLetter, currRule);
            ruleset.add(rule);

        }
        System.out.println("jeg er gemt");
    }


}
