package LsysRecursive;

/**
 * Created by Lucas on 14-10-2016.
 */
public class Rule {
    private char alfabet;
    private String regel;

    public Rule(char input, String regel){
        this.setAlfabet(input);
        this.setRegel(regel);
        System.out.println("I rule klassen står: " + input + " og " + regel);
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
