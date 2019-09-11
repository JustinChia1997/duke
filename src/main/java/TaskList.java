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


    /**
     * Removes the task from the tasklist using the index given
     * @param index is the index of the targeted class for deletion
     * @return a {@link Task} which is the deleted task as requested
     * */
    public Task removeTask(int index){
        Task task = this.taskList.get(index);
        taskList.remove(index);
        return task;
    }

    /**
     * Searches the current tasklist for a task with the relevant description
     * @param searchQuery is the string which the users wants to match with a description of a task in the tasklist
     * @return a {@link TaskList} which is the list of {@link Task} which matches the search query
     * */
    public TaskList search(String searchQuery){
        ArrayList<Task> searchList = new ArrayList<>();
        for(Task task : this.taskList){
           if(task.getDescription().contains(searchQuery))
               searchList.add(task);
        }
        return new TaskList(searchList);
    }



}
