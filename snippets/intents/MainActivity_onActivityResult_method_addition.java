
public class MainActivity extends AppCompatActivity {

    /***************************** Add this code *****************************/

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (resultCode == RESULT_OK) {
            IntentResult scanResult = IntentIntegrator.parseActivityResult(
                    requestCode, resultCode, intent);
            if (scanResult != null) {
                // Handle successful scan
                String contents = scanResult.getContents();
                saveTask(new ToDoItem(contents));
            }
        } else if (resultCode == RESULT_CANCELED) {
            Toast.makeText(this, R.string.scan_canceled, Toast.LENGTH_SHORT)
                    .show();
        }

    }

    /***************************** Add this code *****************************/
}