
public class MainActivity extends AppCompatActivity {

/******************** Add this code ***************************/

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
        removeItem(index);
        return true;
        }
        }
        return false;
        }

/******************** Add this code ***************************/
