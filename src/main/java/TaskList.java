import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> taskList;

    public TaskList(){
        this.taskList = new ArrayList<>();
    }

    public TaskList(ArrayList<Task> taskList){
        this.taskList = taskList;
    }

    public ArrayList<Task> getTaskList(){
        return this.taskList;
    }

    public int size(){
        return this.taskList.size();
    }

    public Task getTask(int index){
        return this.taskList.get(index);
    }

    public void addTask(Task task){
        taskList.add(task);
    }

    public Task removeTask(int index){
        Task task = this.taskList.get(index);
        taskList.remove(index);
        return task;
    }


    public TaskList search(String searchQuery){
        ArrayList<Task> searchList = new ArrayList<>();
        for(Task task : this.taskList){
           if(task.getDescription().contains(searchQuery))
               searchList.add(task);
        }
        return new TaskList(searchList);
    }



}
