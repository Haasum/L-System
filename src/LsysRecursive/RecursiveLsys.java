package LsysRecursive;

import com.sun.org.apache.xml.internal.resolver.readers.TR9401CatalogReader;

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
    char axiom1 = 'A';
    char LetterA = 'A';
    String ruleA = "[+A]";
    String treeLsys1 = "";
    int genNo1 = 3;

    public RecursiveLsys(Grammatik grammatik) {
        this.grammatik = grammatik;
        this.ruleset = grammatik.ruleset;
        treeLsys1 += axiom1;
        expand(treeLsys1, genNo1);
    }

    public String expand(String s, int genNo1) {
        String next = "";
        if (genNo1 == 0) {
            System.out.println("done");
            return s;
        }

        /*
        *
        * */


        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            String expandRule = checkLetterInAlpha(curr);
            if (expandRule != "") {
                next += expand(expandRule, genNo1 - 1);

            }
            else {
                next += curr;

            }
            /*for (int j = 0; j < ruleset.size(); j++) {
                char alphaCurr = ruleset.get(j).getAlfabet();
                if (curr == alphaCurr) {
                    next += LetterA + expand(ruleset.get(j).getRegel(), genNo1 + 1);
                    //next += LetterA + expand(ruleA, genNo1+1);
                    break;
                } else {
                    next += curr;
                    break;
                }
            }
*/
        }
        System.out.println("generation: " + genNo1 + "current alphabet " + next);
        return next;
    }
    public String checkLetterInAlpha(char c) {
        String k = "";
        for (int i = 0; i < ruleset.size(); i++) {
            char currAlpha = ruleset.get(i).getAlfabet();
            if (currAlpha == c) {
                k = ruleset.get(i).getRegel();
            }
        }
        return k;

    }

    public void setAxiom() {
        Axiom = grammatik.getAxiom();
        treeSys = "" + Axiom;
    }
}