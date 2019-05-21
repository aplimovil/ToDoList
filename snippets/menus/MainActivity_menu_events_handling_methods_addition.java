
public class MainActivity extends AppCompatActivity {


        @Override
        protected void onCreate(Bundle savedInstanceState) {


                myButton.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                                todoItems.add(0,
                                        myEditText.getText().toString());
                                aa.notifyDataSetChanged();
                                myEditText.setText("");

/*************************** Add this code ****************************/
                                cancelAdd();
/*************************** Add this code ****************************/

                        }
                });


        }


/********************** Add this code ************************/

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

/********************** Add this code ************************/