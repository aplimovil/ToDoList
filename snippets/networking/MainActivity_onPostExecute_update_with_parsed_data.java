
class LoadTasks extends AsyncTask<Void, Void, Void> {

    @Override
    protected Void doInBackground(Void... voids) {

        if (responseCode == HttpURLConnection.HTTP_OK) {
            InputStream in = httpConnection.getInputStream();

            /******************* Add this code ******************/

            jsonTodoItems = new ArrayList<>();
            //Parse the answer in JSON format
            parseJSON(in);

            /******************* Add this code ******************/
        }

    }

    /****************************** Update this code ******************************/

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        //Update the tasks list after downloading the content from Internet
        todoItems.clear();
        for (int i = 0; i < jsonTodoItems.size(); i++) {
            todoItems.add(jsonTodoItems.get(i).getTask());
        }
        aa.notifyDataSetChanged();
    }

    /****************************** Update this code ******************************/

}