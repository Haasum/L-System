package LsysRecursive;

/**
 * Denne klasse står for at få indputtet fra vores txt fil. Det indput skal kunne give et axiom og et regelsystem til vores Lsystem
 */
public class txt {

    public String inputFromTxt = "A:F[+A][-A],A:F[+A][-A],K:BCB,C:ACA,";
    public String endInput;
    public StringBuilder endOutput= new StringBuilder();
    public String txtInput;
    char letter;
    String rightSide = "";
    public txt() {
       // parseTextFile();
    }
    public void parseTextFile() {
        for (int i = 0; i < inputFromTxt.length() - 1; i++) {
            char current = inputFromTxt.charAt(i);
            if (inputFromTxt.charAt(i + 1) == ':') {
                char currentLetter = inputFromTxt.charAt(i);
                letter = currentLetter; //NJ
                StringBuilder currentRule = new StringBuilder();
                for (int j = i+1; j < inputFromTxt.length()-i; j++) {
                    char currentCheck = inputFromTxt.charAt(j);
                    if (currentCheck != ','){
                        rightSide += currentCheck;
                        System.out.println(rightSide);
                        break;
                    }
                }
            }
        }
    }
    public String getTxtInput() { //her er outputtet samlet efter randommetoder er kørt
        return this.inputFromTxt; // når input fra textFil skal virke
    }
}






//TEKST FIL
    /* public void checkTxt() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("C:\\Users\\naja\\IdeaProjects\\GITHUB\\Proto2\\src\\LsysRecursive\\testTxt.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            StringBuilder sb = new StringBuilder();
            String line = null;
            try {
                line = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                try {
                    line = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            String everything = sb.toString();
            System.out.println("textfilen er: " + everything); //fortæller os hvad tekstfilen er
            inputFromTxt = everything;
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    } */



