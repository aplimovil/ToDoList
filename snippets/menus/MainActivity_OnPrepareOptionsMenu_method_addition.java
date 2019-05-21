//Prepare the menu before display
@Override
public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        int idx = myListView.getSelectedItemPosition();
        //If addingNew flag is set, user is adding a task so cancel option is displayed; otherwise, remove option is available
        String removeTitle = getString(addingNew ? R.string.cancel
        : R.string.remove);
        MenuItem removeItem = menu.findItem(R.id.removeItem);
        removeItem.setTitle(removeTitle);
        //Cancel option is displayed if user is adding a task and remove option is displayed if list has at least one element
        removeItem.setVisible(addingNew || idx > -1);
        return true;
        }