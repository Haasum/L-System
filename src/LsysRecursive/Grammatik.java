package LsysRecursive;

import java.util.ArrayList;

public class Grammatik {

    ArrayList<Rule> ruleset;
    char currentLetter;
    String textFile;
    String currRule = "";
    Rule rule;
    char axiom = 'A';
    int grow;
    double turn;

    public Grammatik(String textFile) {
       // System.out.println("Grammatik is ON");

        this.textFile = textFile + '.';
        readRules();

    }

    public void readRules() { //læser reglerne og deler dem op i i rule-letter og rule
        ruleset = new ArrayList<>();
        for (int i = 0; i < textFile.length()-1; i++) { //kører i textfilens længde

            StringBuilder buildRule = new StringBuilder();

            char current = textFile.charAt(i);



            if (current == ':') {
                currentLetter = textFile.charAt(i - 1); //her tilføjes char til venstre for ':' til currentLetter (=ruleLetter)
            }

            if (current == ',') { //hver gang current er ',' starter sendRules metoden, og buildRule nulstilles
                addRule();
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

    private void addRule() { //reglerne sendes. det er også her de skal gemmes
        rule = new Rule(currentLetter, currRule);
        ruleset.add(rule);
        currRule = ""; //currRule nulstilles
    }

    public ArrayList<Rule> getRuleset(){
        return ruleset;
    }

    public char getAxiom() {
        return axiom;
    }

    //TODO Skal det tilføjes til ruleset arraylist?
    public int getGrow(char charCheck) {

        if (charCheck == 'A') {
            grow = 5;
        }

        if (charCheck == 'B') {
            grow = 8;
        }
        if (charCheck == 'C') {
            grow = 11;
        }
        return grow;
    }
    public double getTurn(char charCheck){

        if(charCheck == 'A') {
            turn = 0.1;
        }

        if(charCheck == 'B'){
            turn = 0.2;
        }

        if(charCheck == 'C'){
            turn = 0.3;
        }

        return turn;
    }
}





