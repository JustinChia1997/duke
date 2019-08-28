import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Duke {
    static String saveFilePath = "data/duke.txt";

private static Date parseDate(String dateString) throws ParseException{
    return new SimpleDateFormat("dd/MM/yyyy HHmm").parse(dateString);
}

    public static void main(String[] args) throws ParseException {
        ArrayList<Task> taskList = new ArrayList<>();
        try{
            FileInputStream fileInput = new FileInputStream(saveFilePath);
            ObjectInputStream inputter = new ObjectInputStream(fileInput);
            taskList = (ArrayList<Task>)inputter.readObject();

            inputter.close();
            fileInput.close();

        } catch(IOException | ClassNotFoundException e){
            throw new DukeException("Loading failed");
        }

        Scanner scan  = new Scanner(System.in);
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        while(scan.hasNext()){
            String input = scan.nextLine();
            String command = input.split(" ")[0];
            switch(command){
                case "bye":
                    System.out.println("Bye. Hope to see you again soon!");
                    System.exit(0);

                case "list":
                    System.out.println("Here are the tasks in your list: ");
                    for(int i=0; i < taskList.size(); i+=1){
                        System.out.println(i+1 + "." + taskList.get(i).toString());
                    }
                    break;

                case "done":
                    int taskNumber = Integer.parseInt(input.split(" ")[1]) -1;
                    taskList.get(taskNumber).markAsDone();
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println("  " + taskList.get(taskNumber).toString());
                    break;

                case "todo" :
                    String description = input.substring(4).trim();
                    if(description.length()>0) {
                        ToDo newToDo = new ToDo(description);
                        taskList.add(newToDo);
                        System.out.println("Got it. I've added this task: ");
                        System.out.println("  " + newToDo.toString());
                        System.out.println("Now you have " + taskList.size() + " tasks in the list");
                    } else {
                        System.out.println("☹ OOPS!!! The description of a todo cannot be empty.");
                    }
                    break;

                case "deadline":
                    String[] deadlineInfo = input.substring(8).split(" /by ");
                    Date deadLineDate = parseDate(deadlineInfo[1]);
                    Deadline newDeadline = new Deadline(deadlineInfo[0], deadLineDate);
                    taskList.add(newDeadline);
                    System.out.println("Got it. I've added this task: ");
                    System.out.println("  " + newDeadline.toString());
                    System.out.println("Now you have " + taskList.size() + " tasks in the list");
                    break;

                case "event":
                    String[] eventInfo = input.substring(5).split(" /at ");
                    Date eventDate = parseDate(eventInfo[1]);
                    Events newEvent = new Events(eventInfo[0], eventDate);
                    taskList.add(newEvent);
                    System.out.println("Got it. I've added this task: ");
                    System.out.println("  " + newEvent.toString());
                    System.out.println("Now you have " + taskList.size() + " tasks in the list");
                    break;

                default:
                    System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(, please input valid command");

            }

            try{
                FileOutputStream fileOutput = new FileOutputStream(saveFilePath);
                ObjectOutputStream outputter = new ObjectOutputStream(fileOutput);
                outputter.writeObject(taskList);

                outputter.close();
                fileOutput.close();

            } catch(IOException e){
                throw new DukeException("File could not save");
            }

        }
    }
}
