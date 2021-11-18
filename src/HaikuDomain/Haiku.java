package HaikuDomain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Haiku {
    // instantiate date formatter
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

    // instance variables
    private String name;
    private int id;
    private String firstLine;
    private String middleLine;
    private String lastLine;
    private String dateTime;

    // haiku constructor
    public Haiku(int id, String name, String firstLine, String middleLine, String lastLine) {
        this.id = id;
        this.name = name;
        this.firstLine = firstLine;
        this.middleLine = middleLine;
        this.lastLine = lastLine;
        this.dateTime = LocalDateTime.now().format(formatter); // format date with formatter
    }

    // get id
    public int getId(){
        return this.id;
    }

    // get the name
    public String getName(){
        return this.name;
    }

    // get first line
    public String getFirstLine(){
        return this.firstLine;
    }

    // get middle line
    public String getMiddleLine(){
        return this.middleLine;
    }

    // get last line
    public String getLastLine(){
        return this.lastLine;
    }

    // get date and time
    public String getDateTime(){
        return this.dateTime;
    }



    // to string representation
    @Override
    public String toString(){
        return this.name + ";" + this.id + ";" + this.firstLine + ";" + this.middleLine + ";" + this.lastLine + ";" + this.dateTime;
    }
} // class ends here
