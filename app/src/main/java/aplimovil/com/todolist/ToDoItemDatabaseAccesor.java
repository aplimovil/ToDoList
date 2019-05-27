package aplimovil.com.todolist;

import android.arch.persistence.room.Room;
import android.content.Context;


public class ToDoItemDatabaseAccesor {
    private static ToDoItemDatabase ToDoItemDatabaseInstance;
    //Constant about the name assigned to SQLite database
    private static final String TODO_DB_NAME = "todo_db";

    private ToDoItemDatabaseAccesor() {
    }

    public static ToDoItemDatabase getInstance(Context context) {
        if (ToDoItemDatabaseInstance == null) {
// Create or open a new SQLite database, and return it as a Room Database instance.
            ToDoItemDatabaseInstance = Room.databaseBuilder(context,
                    ToDoItemDatabase.class, TODO_DB_NAME).build();
        }
        return ToDoItemDatabaseInstance;
    }
}
