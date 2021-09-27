/**
 * File: NodeMultipleEvents.java
 * Creation: 7 nov. 2020, Jean-Philippe.Prost@univ-amu.fr
 * Template étudiants
 */
package TP2;

import java.util.Scanner;
/**
 * @author prost
 *
 */
public class Event extends NodeMultiple {
    public static final String ERROR_MSG_UNEXPECTED_END = "Sorry, for some unexpected reason the story ends here...";
    public static final String PROMPT_ANSWER = "Answer: ";
    public static final String WARNING_MSG_INTEGER_EXPECTED = "Please input a integer within range!";
    private String playerAnswer;
    private GUIManager gui;
    private int chosenPath;
    private Scanner reader;

    public Event(GUIManager gui, String id)
    {
        this.gui = gui;
        this.id = id;
        this.daughters = new NodeMultiple[10];
        this.reader = new Scanner(System.in);

    }

    public Event(){
        this.gui = null;
    }

    public String toString() {
        return "Event " + '#' + getId() + '(' + getClass().getSimpleName() + " ) : " + getData();
    }
    /**
     * @return the playerAnswer
     */
    public String getPlayerAnswer() {
        return this.playerAnswer;
    }

    /**
     * @param playerAnswer the playerAnswer to set
     */
    public void setPlayerAnswer(String playerAnswer) {
        this.playerAnswer = playerAnswer;
    }

    /**
     * @return the reader
     */
    public Scanner getReader() {
        return this.reader;
    }

    /**
     * @param reader the reader to set
     */
    public void setReader(Scanner reader) {
        this.reader =  reader;
    }

    /**
     * @return the chosenPath
     */
    public int getChosenPath() {
        return this.chosenPath;
    }

    /**
     * @param chosenPath the chosenPath to set
     */
    public void setChosenPath(int chosenPath) {
        this.chosenPath = chosenPath;
    }

    /* Methods */
    /**
     * @see TP2.NodeMultiple#getData()
     */
    public Object getData() {
        return this.data;
    }

    /**
     * @see TP2.NodeMultiple#setData(Object)
     * @param data
     */
    public void setData(String data) {
        this.setData(data);
    }

    /**
     * @see TP2.NodeMultiple#getDaughter(int)
     */
    @Override
    public Event getDaughter(int i) {
        return (Event) this.daughters[i];
    }

    /**
     * @see TP2.NodeMultiple#setDaughter(NodeMultiple, int)
     * @param daughters
     * @param i
     */
    public void setDaughter(Event daughters, int i) {
        this.daughters[i] = daughters;
    }

    /**
     * @return the gui
     */
    public GUIManager getGui() {
        return this.gui;
    }

    /**
     * @param gui the gui to set
     */
    public void setGui(GUIManager gui) {
        this.gui = gui;
    }

    /**
     * @return the id
     */
    public String getId() {
        return this.id;
    }

    /* Methods */
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    public int interpretAnswer() {
        if (isFinal()) {
            gui.outputln(ERROR_MSG_UNEXPECTED_END);
            return 0;
        }

        if (isInRange(playerAnswer)) {
            if (isNumeric(playerAnswer)) {
                return Integer.parseInt(playerAnswer);
            } else {
                gui.outputln(WARNING_MSG_INTEGER_EXPECTED);
                return 0;
            }
        } else { gui.outputln(ERROR_MSG_INDEX_OUT_OF_RANGE);
            return 0;
        }
    }

    public boolean isInRange(String index) {

            if (Integer.parseInt(index) <= NODE_MAX_ARITY && Integer.parseInt(index) > 0) return true;
        return false;
    }

    public boolean isFinal(){
       if (this.hasDaughters() == false) return true;
       return false;
    }
    public Event run () {
        gui.outputln(this.toString());
        gui.outputln(PROMPT_ANSWER);
        playerAnswer = reader.next();
        chosenPath = interpretAnswer();
        Event thedaughter = getDaughter(chosenPath);
        return thedaughter;

    }

}

// eof