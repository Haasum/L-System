/**
 * Gammatik står for at parse hvad der står i tekstfilen som kommer fra txt.java
 * vores readRules method læser bogstavet inden vores kolon og reglener efter kolon som kan læses senere.
 */

package LsysRecursive;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
public class Grammatik {
    ArrayList<Rule> ruleset;
    char currentLetter;
    String textFile;
    String currRule = "";
    Rule rule;
    char axiom = 'A';

    public Grammatik(String textFile) {
        this.textFile = textFile + '.';
        readRules();
        addPrimitives();
    }

    public void readRules() { //læser reglerne og deler dem op i i rule-letter og rule
        ruleset = new ArrayList<>();
        for (int i = 0; i < textFile.length()-1; i++) { //kører i textfilens længde
            StringBuilder buildRule = new StringBuilder();
            char current = textFile.charAt(i);
            if (current == ':') {
                currentLetter = textFile.charAt(i - 1); //her tilføjes char til venstre for ':' til currentLetter (=ruleLetter)
                System.out.println("regel er " + currentLetter);
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
        //TODO: her skal array af current letter
        rule = new Rule(currentLetter, currRule);
        ruleset.add(rule);
        currRule = ""; //currRule nulstilles
    }

    public void addPrimitives(){ //TODO: skal impleme
        char[] primitives = new char[]{'[',']','+','-'};
        for (char c :primitives) {
            Rule primitive = new Rule(c);
        }
    }

    public ArrayList<Rule> getRuleset(){
        return ruleset;
    }

    public char getAxiom() {
        return axiom;
    }
}





