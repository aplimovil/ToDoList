
public class MainActivity extends AppCompatActivity {


/******************************* Add this code ********************************************/

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

/******************************* Add this code ********************************************/

}