/**
 * This class takes in the input by the user and parses it into the command word and relevant inputs
 * */
public class Parser {
    /**
     * This method finds the command word by parsing the input string
     * @param input is the full user input {@link String}
     * @return a {@link String} which represents the command word given by the input
     * */
    public static String findCommandWord(String input){

        if(input.length()>0) {
            return input.split(" ")[0];
        }
        else return "noCommand";
    }

    /**
     * Extracts the description of _todo from full input string
     * @param input is the full user input {@link String}
     * @return a {@link String} of the description of the _todo
     * */
    public static String getTodoDescription(String input){
        return input.substring(4).trim();
    }

}
