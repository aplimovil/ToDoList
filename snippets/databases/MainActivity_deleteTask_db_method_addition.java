
public class MainActivity extends AppCompatActivity {


        /********************************** Update this code ************************************/

        //Handle the selection from Context Menu
        @Override
        public boolean onContextItemSelected(MenuItem item) {
            super.onContextItemSelected(item);
            switch (item.getItemId()) {
                case (REMOVE_TODO): {
                    AdapterView.AdapterContextMenuInfo menuInfo;
                    menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                    int index = menuInfo.position;
                    deleteTask(dbTodoItems.get(index));
                    return true;
                }
            }
            return false;
        }

        /********************************** Update this code ************************************/


    /********************************** Add this code ************************************/

    private void deleteTask(final ToDoItem task) {
        class DeleteTask extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... voids) {
                String s;
                ToDoItemDatabaseAccesor
                        .getInstance(getApplication()).toDoItemDAO().deleteToDoItem(task);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                getTasks();
            }
        }

        DeleteTask deleteTask= new DeleteTask();
        deleteTask.execute();
    }

    /********************************** Add this code ************************************/

}