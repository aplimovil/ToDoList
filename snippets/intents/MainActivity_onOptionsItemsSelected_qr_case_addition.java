
public class MainActivity extends AppCompatActivity {


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
        /******************** Add this code *******************/

        case (R.id.addQR): {
        addQR();
        return true;
        }

        /******************** Add this code *******************/
        }
        return false;
        }

}