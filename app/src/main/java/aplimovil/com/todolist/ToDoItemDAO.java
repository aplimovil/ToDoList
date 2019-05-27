package aplimovil.com.todolist;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;


@Dao
public interface ToDoItemDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertToDoItems(List<ToDoItem> items);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertToDoItem(ToDoItem item);

    @Update
    public void updateToDoItem(ToDoItem item);

    @Delete
    public void deleteToDoItem(ToDoItem item);

    @Query("SELECT * FROM todoitem ORDER BY timestamp DESC")
    public List<ToDoItem> loadAllItems();
}
