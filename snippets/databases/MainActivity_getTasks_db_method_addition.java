
public class MainActivity extends AppCompatActivity {

    /********************************** Add this code ************************************/

    //Hold the ToDoItem objects from database
    private ArrayList<ToDoItem> dbTodoItems;

    /********************************** Add this code ************************************/

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    // Get references to UI widgets
    myListView = (ListView) findViewById(R.id.myListView);
    myEditText = (EditText) findViewById(R.id.myEditText);
    myButton = (Button) findViewById(R.id.myButton);

    // Create the array list of to do items
    /********************************** Add this code ************************************/

    dbTodoItems = new ArrayList<ToDoItem>();

    /********************************** Add this code ************************************/

    todoItems = (ArrayList<String>) getLastCustomNonConfigurationInstance();
    if (todoItems == null)
        todoItems = new ArrayList<String>();
    // Create the array adapter to bind the array to the listview
    aa = new ArrayAdapter<String>(this, R.layout.todolist_item, todoItems);
    // Bind the array adapter to the listview.
    myListView.setAdapter(aa);

    . . .

    /********************************** Add this code ************************************/

        getTasks();

    /********************************** Add this code ************************************/
        }


    /********************************** Add this code ************************************/

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

    /********************************** Add this code ************************************/

}