import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        TaskList taskList;
        String saveFilePath = "data/duke.txt";
        Storage storage = new Storage(saveFilePath);
        taskList = new TaskList(storage.load());

        Scanner scan  = new Scanner(System.in);
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        
        while(scan.hasNext()){
            String input = scan.nextLine();
            String command = Parser.findCommandWord(input);
            switch(command){
                case "bye":
                    System.out.println("Bye. Hope to see you again soon!");
                    System.exit(0);

                case "list":
                    System.out.println("Here are the tasks in your list: ");
                    for(int i=0; i < taskList.size(); i+=1){
                        System.out.println(i+1 + "." + taskList.getTask(i).toString());
                    }
                    break;

                case "done":
                    int taskNumber = Integer.parseInt(input.split(" ")[1]) -1;
                    taskList.getTask(taskNumber).markAsDone();
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println("  " + taskList.getTask(taskNumber).toString());
                    break;

                case "todo" :
                    String description = Parser.getTodoDescription(input);
                    if(description.length()>0) {
                        ToDo newToDo = new ToDo(description);
                        taskList.addTask(newToDo);
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
                    taskList.addTask(newDeadline);
                    System.out.println("Got it. I've added this task: ");
                    System.out.println("  " + newDeadline.toString());
                    System.out.println("Now you have " + taskList.size() + " tasks in the list");
                    break;

                case "event":
                    String[] eventInfo = input.substring(5).split(" /at ");
                    Events newEvent = new Events(eventInfo[0], eventInfo[1]);
                    taskList.addTask(newEvent);
                    System.out.println("Got it. I've added this task: ");
                    System.out.println("  " + newEvent.toString());
                    System.out.println("Now you have " + taskList.size() + " tasks in the list");
                    break;
                    
                case "find":
                    String searchText = input.substring(4).trim();
                    TaskList searchList = taskList.search(searchText);
                    for(int i=0; i < searchList.size(); i+=1){
                        System.out.println(i+1 + "." + searchList.getTask(i).toString());
                    }
                    if(searchList.size() == 0){
                        System.out.println("Could not find such a task");
                    }

                    break;

                case "delete":
                    int index = Integer.parseInt(input.substring(6).trim());
                    System.out.println("Noted. I've removed this task:");
                    System.out.println(taskList.getTask(index-1).toString());
                    taskList.removeTask(index-1);
                    System.out.println("Now you have " + taskList.size() + " tasks in the list");
                    break;

                default:
                    System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");

            }

            storage.save(taskList.getTaskList());



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
