
class LoadTasks extends AsyncTask<Void, Void, Void> {

/***************************************** Add this code ****************************************/

    //Method to parse the tasks.json file available in th server
    private void parseJSON(InputStream in) throws IOException {
        // Create a new Json Reader to parse the input.
        JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
        try {
            //JSON file starts with an array
            reader.beginArray();
            while (reader.hasNext()) {
                ToDoItem item = new ToDoItem(null);
                //Parse a specific object inside the array
                reader.beginObject();
                while (reader.hasNext()) {
                    String value = reader.nextName();
                    //It gets the property value and store it on the correct property of ToDoItem object
                    switch (value) {
                        case "name":
                            item.setTask(reader.nextString());
                            break;
                        case "timestamp":
                            item.setTimestamp(reader.nextLong());
                            break;
                        default:
                            reader.skipValue();
                            break;
                    }
                }
                reader.endObject();
                jsonTodoItems.add(item);
            }
            reader.endArray();
        } finally {
            reader.close();
        }
    }

    /***************************************** Add this code ****************************************/

}