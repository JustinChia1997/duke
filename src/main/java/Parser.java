public class Parser {
    public static String findCommandWord(String input){
        if(input.length()>0) {
            return input.split(" ")[0];
        }
        else return "noCommand";
    }

    public static String getTodoDescription(String input){
        return input.substring(4).trim();
    }

}
