package aplimovil.com.todolist;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

//Create an Entity ToDoItem which is mapped to a table in the database
//with id, task and timestamp fields
@Entity
public class ToDoItem {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String task;
    private long timestamp;

    public ToDoItem(String _task) {
        this(_task, java.lang.System.currentTimeMillis());
    }

    public ToDoItem(String task, long timestamp) {
        this.task = task;
        this.timestamp = timestamp;
    }


    public int getId() {
        return id;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }


    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public long getTimestamp() {
        return java.lang.System.currentTimeMillis();
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

}
