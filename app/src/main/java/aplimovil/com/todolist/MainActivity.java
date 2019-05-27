package aplimovil.com.todolist;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Defines the remove option for the context menu
    static final private int REMOVE_TODO = Menu.FIRST;
    private ArrayList<String> todoItems;
    private ListView myListView;
    private EditText myEditText;
    private ArrayAdapter<String> aa;
    private boolean addingNew = false;
    private Button myButton;
    //Hold the ToDoItem objects from database
    private ArrayList<ToDoItem> dbTodoItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Get references to UI widgets
        myListView = (ListView) findViewById(R.id.myListView);
        myEditText = (EditText) findViewById(R.id.myEditText);
        myButton = (Button) findViewById(R.id.myButton);

        // Create the array list of to do items
        dbTodoItems = new ArrayList<ToDoItem>();
        todoItems = (ArrayList<String>) getLastCustomNonConfigurationInstance();
        if (todoItems == null)
           todoItems = new ArrayList<String>();
        // Create the array adapter to bind the array to the listview
        aa = new ArrayAdapter<String>(this, R.layout.todolist_item, todoItems);
        // Bind the array adapter to the listview.
        myListView.setAdapter(aa);

        myButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ToDoItem task = new ToDoItem(myEditText.getText().toString());
                saveTask(task);
            }
        });

        //Register a context menu for the ListView
        registerForContextMenu(myListView);
        getTasks();

    }

    //Use this method to save EditText/Button status when phone goes to landscape/portrait mode
    protected void onSaveInstanceState(Bundle instanceState) {
        super.onSaveInstanceState(instanceState);
        instanceState.putInt("visualState", myEditText.getVisibility());
    }

    //Use this method to recover EditText/Button status when phone goes to landscape/portrait mode
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState.getInt("visualState") == View.VISIBLE) {
            myEditText.setVisibility(View.VISIBLE);
            myButton.setVisibility(View.VISIBLE);
        }
    }

    //Use this method to recover the ListView items when phone goes to portrait/landscape mode
    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        return (todoItems);
    }


    //Create the options menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.todo_menu, menu);
        return true;
    }

    //Create the context menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle(R.string.menu_title);
        menu.add(0, REMOVE_TODO, Menu.NONE, R.string.remove);
    }

    //Prepare the menu before display
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        int idx = myListView.getSelectedItemPosition();
        //If addingNew flag is set, user is adding a task so cancel option is displayed; otherwise, remove option is available
        String removeTitle = getString(addingNew ? R.string.cancel
                : R.string.remove);
        MenuItem removeItem = menu.findItem(R.id.removeItem);
        removeItem.setTitle(removeTitle);
        //Cancel option is displayed if user is adding a task and remove option is displayed if list has at least one element
        removeItem.setVisible(addingNew || idx > -1);
        return true;
    }

    //Handle the selection from Options Menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        //Get the position from the list
        int index = myListView.getSelectedItemPosition();
        switch (item.getItemId()) {
            case (R.id.removeItem): {
                //addingNew = true means the user is adding a task
                if (addingNew) {
                    cancelAdd();
                } else {
                    removeItem(index);
                }
                return true;
            }
            case (R.id.addItem): {
                addNewItem();
                return true;
            }
        }
        return false;
    }

    //Handle the selection from Context Menu
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        super.onContextItemSelected(item);
        switch (item.getItemId()) {
            case (REMOVE_TODO): {
                AdapterView.AdapterContextMenuInfo menuInfo;
                menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                int index = menuInfo.position;
                deleteTask(dbTodoItems.get(index));
                return true;
            }
        }
        return false;
    }

    private void cancelAdd() {
        addingNew = false;
        myEditText.setVisibility(View.GONE);
        myButton.setVisibility(View.GONE);
        invalidateOptionsMenu();
    }

    private void addNewItem() {
        addingNew = true;
        myEditText.setVisibility(View.VISIBLE);
        myButton.setVisibility(View.VISIBLE);
        myEditText.requestFocus();
        invalidateOptionsMenu();
    }

    private void removeItem(int _index) {
        todoItems.remove(_index);
        aa.notifyDataSetChanged();
    }

    private void getTasks() {
        class GetTasks extends AsyncTask<Void, Void, List<ToDoItem>> {

            @Override
            protected List<ToDoItem> doInBackground(Void... voids) {
                List<ToDoItem> taskList = ToDoItemDatabaseAccesor
                        .getInstance(getApplication()).toDoItemDAO().loadAllItems();
                return taskList;
            }

            @Override
            protected void onPostExecute(List<ToDoItem> tasks) {
                super.onPostExecute(tasks);
                todoItems.clear();
                dbTodoItems.clear();
                for (int i = 0; i < tasks.size(); i++) {
                    todoItems.add(tasks.get(i).getTask());
                    dbTodoItems.add(tasks.get(i));
                }
                aa.notifyDataSetChanged();
            }
        }
        GetTasks getTasks = new GetTasks();
        getTasks.execute();

    }

    private void saveTask(final ToDoItem task) {
        class SaveTask extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... voids) {
                //adding to database
                ToDoItemDatabaseAccesor.getInstance(getApplication()).toDoItemDAO().insertToDoItem(task);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                getTasks();
                myEditText.setText("");
                cancelAdd();
            }
        }

        SaveTask saveTask = new SaveTask();
        saveTask.execute();
    }

    private void deleteTask(final ToDoItem task) {
        class DeleteTask extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... voids) {
                String s;
                ToDoItemDatabaseAccesor
                        .getInstance(getApplication()).toDoItemDAO().deleteToDoItem(task);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                getTasks();
            }
        }

        DeleteTask deleteTask= new DeleteTask();
        deleteTask.execute();
    }
}
