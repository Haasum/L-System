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

    public RecursiveLsys(Grammatik grammatik){

        this.grammatik = grammatik;
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
