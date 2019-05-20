@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Get references to UI widgets
        ListView myListView = findViewById(R.id.myListView);
final EditText myEditText = findViewById(R.id.myEditText);
        Button myButton = findViewById(R.id.myButton);


/************************* Add this code ***************************************************/
        myButton.setOnClickListener(new View.OnClickListener() {
public void onClick(View v) {
        todoItems.add(0,
        myEditText.getText().toString());
        aa.notifyDataSetChanged();
        myEditText.setText("");
        }
        });
/************************* Add this code ***************************************************/

        }