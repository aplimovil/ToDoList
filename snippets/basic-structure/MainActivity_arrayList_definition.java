@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Get references to UI widgets
        ListView myListView = findViewById(R.id.myListView);
final EditText myEditText = findViewById(R.id.myEditText);
        Button myButton = findViewById(R.id.myButton);


/************************* Add this code ***************************************************/
// Create the array list of to do items
final ArrayList<String> todoItems = new ArrayList<String>();
// Create the array adapter to bind the array to the listview
final ArrayAdapter<String> aa;
        aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, todoItems);
        // Bind the array adapter to the listview.
        myListView.setAdapter(aa);
/************************* Add this code ***************************************************/

        }