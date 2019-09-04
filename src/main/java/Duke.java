import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        ArrayList<Task> taskList = new ArrayList<>();
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
                    Deadline newDeadline = new Deadline(deadlineInfo[0], deadlineInfo[1]);
                    taskList.add(newDeadline);
                    System.out.println("Got it. I've added this task: ");
                    System.out.println("  " + newDeadline.toString());
                    System.out.println("Now you have " + taskList.size() + " tasks in the list");
                    break;

                case "event":
                    String[] eventInfo = input.substring(5).split(" /at ");
                    Events newEvent = new Events(eventInfo[0], eventInfo[1]);
                    taskList.add(newEvent);
                    System.out.println("Got it. I've added this task: ");
                    System.out.println("  " + newEvent.toString());
                    System.out.println("Now you have " + taskList.size() + " tasks in the list");
                    break;

                default:
                    System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");

            }



            /*
            if (command.equals("bye")){
                System.out.println("Bye. Hope to see you again soon!");
                System.exit(0);
            }

            else if(command.equals("list")){
                for(int i=0; i < taskList.size(); i+=1){
                    System.out.println("Here are the tasks in your list: ");
                    System.out.println(i+1 + "." + taskList.get(i).toString());
                }

            }

            else if(input.split(" ")[0].equals("done")){
                int taskNumber = Integer.parseInt(input.split(" ")[1]) -1;
                taskList.get(taskNumber).markAsDone();
                System.out.println("Nice! I've marked this task as done:");
                System.out.println("  " + taskList.get(taskNumber).toString());
            }

            else{
                Task newTask = new Task(input);
                taskList.add(newTask);
                System.out.println("added: " + input);
            }
             */
        }
    }
}
