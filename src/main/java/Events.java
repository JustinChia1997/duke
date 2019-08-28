import java.util.Date;

public class Events extends Task {
    protected Date at;

    public Events(String description, Date at){
        super(description);
        this.at = at;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + at + ")";
    }


}
