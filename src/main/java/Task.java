import java.io.Serializable;

public class Task implements Serializable {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    public String getDescription(){
        return(this.description);
    }

    public void markAsDone(){
        this.isDone = true;
    }

    @Override
    public String toString(){
        return String.format("[%s] %s" , getStatusIcon(), description);
    }


}