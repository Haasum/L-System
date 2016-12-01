package LsysRecursive;
import java.util.ArrayList;
public class RecursiveLsys {
    ArrayList<Rule> ruleset;
    Grammatik grammatik;
    char axiom1 = 'K';
    String treeLsys1 = "";
    int genNo1 = 2;
    String tree;
    ArrayList<String> rulesForRand;



    public RecursiveLsys(Grammatik grammatik, String expandString, int genNo) {
        System.out.println("expanding string " + expandString);
        this.grammatik = grammatik;
        this.ruleset = grammatik.ruleset;
       tree = expand(expandString, genNo);
       // treeLsys1 += axiom1;
      //  tree = expand(treeLsys1, genNo1);

    }

    //public RecursiveLsys(Grammatik grammatik, String newString, int number) {
     //   this.grammatik = grammatik;
      //  this.ruleset = grammatik.ruleset;
      //  tree = expand(newString, number);
    //}
    public String expand(String s, int genNo1) {
        String next = "";


        if (genNo1 == 0) {
            return s;
        }
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            String expandRule = checkLetterInAlpha(curr);
            if (expandRule != "" && expandRule != null) {
                next += expand(expandRule, genNo1 - 1);
            }
            else {
                next += curr;
            }
        }
        return next;
    }
    public String checkLetterInAlpha(char c) {
        String k = "";
        rulesForRand = new ArrayList<String>();
        for (int i = 0; i < ruleset.size(); i++) {
            char currAlpha = ruleset.get(i).getAlfabet();
            if (currAlpha == c) {
                k = ruleset.get(i).getRegel();
                rulesForRand.add(k);
            }
        }
        if (rulesForRand.size() > 1) {
            Rand rand = new Rand(rulesForRand);
            k = rand.getRandRule();
        }

        return k;
    }

    public void setTree(String tree2) {
        this.tree = tree2;
    }
    public String getTree(){
        return tree;
    }
}