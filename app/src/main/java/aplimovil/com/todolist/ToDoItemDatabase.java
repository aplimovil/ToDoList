package aplimovil.com.todolist;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {ToDoItem.class}, version = 1)
public abstract class ToDoItemDatabase extends RoomDatabase {
    public abstract ToDoItemDAO toDoItemDAO();
}
