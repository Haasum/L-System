package LsysRecursive;

/**
 * Her skal vores regler læses fra grammatik klassen, og gemmes til senere.
 */
public class Rule {
    private char alfabet;
    private String regel;
    int grow;
    public Rule(char input, String regel){
        this.setAlfabet(input);
        this.setRegel(regel);
       // System.out.println("I rule klassen står: " + input + " og " + regel);
    }

    public int getGrow(){
        return grow;
    }
    public void setGrow(int grow){
        this.grow = grow;
    }

    public char getAlfabet() {
        return alfabet;
    }

    public void setAlfabet(char alfabet) {
        this.alfabet = alfabet;
    }

    public String getRegel() {
        return regel;
    }

    public void setRegel(String regel) {
        this.regel = regel;
    }
}
