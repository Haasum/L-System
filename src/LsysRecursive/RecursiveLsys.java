package LsysRecursive;

import java.util.ArrayList;

/**s
 * Denne klasse har metoden generateLsys. Ideen med denne: Den skal have en streng som parameter og gennemløbe den.
 * For hver gang den finder et bogstav fra Grammatik, skal den lave et rekursivt kald parametermed bogstavets
 * repræsentative regel, også fundet i Grammatik.
 * Mangler lige nu: Hente regler (ruleobjekter), som er lagret i Grammatik. Hvad skal stoppe rekursionen?
 * Spørgsmål til John: Hvordan gemmes hver streng bedst?
 */
public class RecursiveLsys {
    ArrayList<Rule> ruleset;
    Grammatik grammatik;
    char Axiom; // TODO tjek Johns eksempler; Axiom som String?
    String treeSys;
    int genNo = 0;

    public RecursiveLsys(Grammatik grammatik){
        this.grammatik = grammatik;

        setRuleset();
        setAxiom();
        makeTree("A");

    }
    public void setAxiom() {
        Axiom = grammatik.getAxiom();
        treeSys = ""+Axiom;
    }

    public void setRuleset(){
        ruleset = grammatik.ruleset;
    }

    public void makeTree(String genCheck){
        String nextGen = "";
        if (genNo > 5){
            return;

        } //TODO der skal laves cases for hver
        for(int i = 0; i < genCheck.length(); i++){
            char currentCheck = genCheck.charAt(i);
            switch (currentCheck){
                case 'A':
                    nextGen += ruleset.get(0).getRegel();
                    System.out.println("Test" + genNo + nextGen);
                    break;
                case 'B':
                    nextGen += ruleset.get(1).getRegel();
                    break;
                case 'C':
                    nextGen += ruleset.get(2).getRegel();
                    break;
                default:
                    nextGen += currentCheck;
            }

        }
        System.out.println(nextGen);
        genNo++;
        makeTree(nextGen);
    }

}

   /* public String makeString(String currentString){
        System.out.println("Det her er currentstring" + currentString);
        String nextGen = "";
        String ruleToParse = "";

        for ( int i = 0; i < currentString.length(); i++) {
            char currentLetterinGen = currentString.charAt(i);

            for (int j = 0; j < ruleset.size(); j++) {
                char currentLetterInRuleset =ruleset.get(j).getAlfabet();

                if (currentLetterinGen == currentLetterInRuleset && genNo < 5) {
                    ruleToParse += ruleset.get(j).getRegel();
                    nextGen += makeString(ruleToParse);
                    genNo++;
                    treeSys += nextGen;
                    System.out.println("Jeg er rigtig: sammenligning er mellem: "+ i + currentLetterinGen + j + currentLetterInRuleset);
                }
                /*else {
                    treeSys += currentLetterinGen;
                }
                if (genNo > 5 ) {break;}
                System.out.println("Vi kalder MakeString igen med: "+nextGen);
                System.out.println("GenN0: "+genNo+"TreeSys er: " + treeSys);
                System.out.println(" ");
            }
        }
        return nextGen;
    }*/


    /*Grammatik gram;

    public RecursiveLsys(Grammatik gram){
        this.gram = gram;
    }

    public String generateLsys(int genNo, String genString) {
        String next = "";
        if (genNo > 0) {
            char[] charInString = genString.toCharArray();
            for (char c : charInString) {
                switch (c) {
                    case 'B':
                        next += generateLsys(genNo-1, "BAA");
                        break;
                    case 'A':
                        next += generateLsys(genNo-1, "B[+A]");
                        break;
                    default:
                        next += c;
                        break;
                }
            }
        }
        else {
            next=genString;
        }
        System.out.println("i gen: "+ genNo+ " er reglen:  " + genString);
        return next;
    }
}*/
