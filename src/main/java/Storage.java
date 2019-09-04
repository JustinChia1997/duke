import java.io.*;
import java.util.ArrayList;

public class Storage {
    private String filePath;
    public Storage(String filePath){
        this.filePath = filePath;
    }

    public ArrayList<Task> load(){
        try{
            FileInputStream fileInput = new FileInputStream(filePath);
            ObjectInputStream input = new ObjectInputStream(fileInput);
            ArrayList<Task> taskList = (ArrayList<Task>)input.readObject();

            input.close();
            fileInput.close();
            return taskList;
        } catch(IOException | ClassNotFoundException e){
            throw new DukeException("Loading failed");
        }
    }

    public void save(ArrayList<Task> taskList){
        try{
            FileOutputStream fileOutput = new FileOutputStream(filePath);
            ObjectOutputStream output = new ObjectOutputStream(fileOutput);
            output.writeObject(taskList);

            output.close();
            fileOutput.close();

        } catch(IOException e){
            throw new DukeException("File could not save");
        }
    }

}
