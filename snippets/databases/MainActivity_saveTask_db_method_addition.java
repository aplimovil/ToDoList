
public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Get references to UI widgets
        myListView = (ListView) findViewById(R.id.myListView);
        myEditText = (EditText) findViewById(R.id.myEditText);
        myButton = (Button) findViewById(R.id.myButton);

    . . .

        /********************************** Update this code ************************************/

        myButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                saveTask();
            }
        });

        /********************************** Update this code ************************************/
    }


    /********************************** Add this code ************************************/

    private void saveTask() {
        class SaveTask extends AsyncTask<Void, Void, Void> {
            ToDoItem task = new ToDoItem(myEditText.getText().toString());

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

    /********************************** Add this code ************************************/

}