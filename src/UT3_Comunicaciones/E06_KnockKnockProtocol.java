package UT3_Comunicaciones;

public class E06_KnockKnockProtocol {
    private static final int WAITING = 0;
    private static final int SENTKNOCKKNOCK = 1;
    private static final int SENTCLUE = 2;
    private static final int ANOTHER = 3;
 
    private static final int NUMJOKES = 5;
 
    private int state = WAITING;
    private int currentJoke = 0;
 
    private String[] clues = { "El servidor", "Una Ancianita", "Atch", "Quién", "Quién" };
    private String[] answers = { "El servidor enmascarado!",
                                 "Desconocía que sabías cantar!",
                                 "Jesús!",
                                 "Hay un buho aquí?",
                                 "Hay eco aquí?" };
 
    public String processInput(String theInput) {
        String theOutput = null;
 
        if (state == WAITING) {
            theOutput = "Knock! Knock!";
            state = SENTKNOCKKNOCK;
        } else if (state == SENTKNOCKKNOCK) {
            if (theInput.equalsIgnoreCase("Quién es?")) {
                theOutput = clues[currentJoke];
                state = SENTCLUE;
            } else {
                theOutput = "Se supone que debes decir \"Quién es?\"! " +
                "Otra vez. Knock! Knock!";
            }
        } else if (state == SENTCLUE) {
            if (theInput.equalsIgnoreCase(clues[currentJoke] + " qué?")) {
                theOutput = answers[currentJoke] + " Otra vez? (s/n)";
                state = ANOTHER;
            } else {
                theOutput = "Se supone que debes decir \"" +
                clues[currentJoke] +
                " qué?\"" +
                "! Inténtalo otra vez. Knock! Knock!";
                state = SENTKNOCKKNOCK;
            }
        } else if (state == ANOTHER) {
            if (theInput.equalsIgnoreCase("y")) {
                theOutput = "Knock! Knock!";
                if (currentJoke == (NUMJOKES - 1))
                    currentJoke = 0;
                else
                    currentJoke++;
                state = SENTKNOCKKNOCK;
            } else {
                theOutput = "Bye.";
                state = WAITING;
            }
        }
        return theOutput;
    }
}