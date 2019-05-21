public class MainActivity extends AppCompatActivity {

    /********************* Add this code **************************************/

    //Defines the remove option for the context menu
    static final private int REMOVE_TODO = Menu.FIRST;

    /********************* Add this code **************************************/





    @Override
    protected void onCreate(Bundle savedInstanceState) {

/********************* Add this code **************************************/

        //Register a context menu for the ListView
        registerForContextMenu(myListView);

/********************* Add this code **************************************/

    }



    /********************* Add this code **************************************/

    //Create the context menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle(R.string.menu_title);
        menu.add(0, REMOVE_TODO, Menu.NONE, R.string.remove);
    }

/********************* Add this code **************************************/