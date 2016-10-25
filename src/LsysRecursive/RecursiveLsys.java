package LsysRecursive;

/**s
 * Denne klasse har metoden generateLsys. Ideen med denne: Den skal have en streng som parameter og gennemløbe den.
 * For hver gang den finder et bogstav fra Grammatik, skal den lave et rekursivt kald parametermed bogstavets
 * repræsentative regel, også fundet i Grammatik.
 * Mangler lige nu: Hente regler (ruleobjekter), som er lagret i Grammatik. Hvad skal stoppe rekursionen?
 * Spørgsmål til John: Hvordan gemmes hver streng bedst?
 */
public class RecursiveLsys {

    Grammatik grammatik;
    char Axiom; // TODO tjek Johns eksempler; Axiom som String?
    String treeSys;
    int genNo = 0;

    public RecursiveLsys(Grammatik grammatik){
        this.grammatik = grammatik;
        setAxiom();
    }
    public void setAxiom() {
        Axiom = grammatik.getAxiom();
        treeSys = ""+Axiom;
        makeString(treeSys);
    }

    public void makeString(String currentString){
        System.out.println(currentString);
        String nextGen = "";

        for ( int i = 0; i < currentString.length(); i++) {
            if (genNo > 6){
                break;
            }
            char currentLetterinGen = currentString.charAt(i);


            for (int j = 0; j < grammatik.getRuleset().size(); j++) {
                char currentLetterInRuleset = grammatik.getRuleset().get(j).getAlfabet();

                if (currentLetterinGen == currentLetterInRuleset) {
                    nextGen += grammatik.getRuleset().get(j).getRegel();
                    treeSys += nextGen;
                }
                /*else {
                    treeSys += currentLetterinGen;
                }*/
                genNo ++;
                makeString(treeSys);
                System.out.println("Vi kalder MakeString igen med: "+nextGen);
                System.out.println("GenN0: "+genNo+"TreeSys er: " + treeSys);

            }
        }
    }
}

    /*Grammatik gram;

    public RecursiveLsys(Grammatik gram){
        this.gram = gram;
    }

    public String generateLsys(int genNo, String genString) {
        String next = "";
        if (genNo > 0) {


            char[] charInString = genString.toCharArray();

            for (char c : charInString) {

                /*switch (c) {

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
