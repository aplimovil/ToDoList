public class MainActivity extends AppCompatActivity {

    /************************************ Add this code *****************************/

    private void loadTasks() {

        class LoadTasks extends AsyncTask<Void, Void, Void> {

            private static final String TAG = "ToDo";
            private ArrayList<ToDoItem> jsonTodoItems;

            @Override
            protected Void doInBackground(Void... voids) {

                ArrayList<String> result = new ArrayList<>(0);
                String myFeed = getApplication().getString(R.string.todo_feed);
                try {
                    URL url = new URL(myFeed);
                    // Create a new HTTP URL connection
                    URLConnection connection = url.openConnection();
                    HttpURLConnection httpConnection = (HttpURLConnection) connection;
                    int responseCode = httpConnection.getResponseCode();
                    if (responseCode == HttpURLConnection.HTTP_OK) {
                        InputStream in = httpConnection.getInputStream();
                    }
                    httpConnection.disconnect();
                } catch (MalformedURLException e) {
                    Log.e(TAG, "Malformed URL Exception.", e);
                } catch (IOException e) {
                    Log.e(TAG, "IO Exception.", e);
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
            }

        }
        LoadTasks loadTasks = new LoadTasks();
        loadTasks.execute();
    }

    /************************************ Add this code *****************************/

}