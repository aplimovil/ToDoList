
public class MainActivity extends AppCompatActivity {

    //Defines the remove option for the context menu
static final private int REMOVE_TODO = Menu.FIRST;

/******************* Add this code ************************/

private ArrayList<String> todoItems;
private ListView myListView;
private EditText myEditText;
private ArrayAdapter<String> aa;
private boolean addingNew = false;
private Button myButton;

/******************* Add this code ************************/


/******************* Update this code ************************/

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    // Get references to UI widgets
    myListView = (ListView) findViewById(R.id.myListView);
    myEditText = (EditText) findViewById(R.id.myEditText);
    myButton = (Button) findViewById(R.id.myButton);

    // Create the array list of to do items
    todoItems = new ArrayList<String>();
    // Create the array adapter to bind the array to the listview
    aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, todoItems);
    // Bind the array adapter to the listview.
    myListView.setAdapter(aa);

    myButton.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            todoItems.add(0,
                    myEditText.getText().toString());
            aa.notifyDataSetChanged();
            myEditText.setText("");
        }
    });

    //Register a context menu for the ListView
    registerForContextMenu(myListView);


}

/******************* Update this code ************************/