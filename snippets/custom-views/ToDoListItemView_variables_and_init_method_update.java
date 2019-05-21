public class ToDoListItemView extends AppCompatTextView {

    /***************************** Add this code ****************************/

    private Paint marginPaint;
    private Paint linePaint;
    private int paperColor;
    private float margin;

    /***************************** Add this code ****************************/


    /***************************** Update this code ****************************/

    private void init() {
        // Get a reference to our resource table.
        Resources myResources = getResources();
        // Create the paint brushes we will use in the onDraw method.
        marginPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        marginPaint.setColor(myResources.getColor(R.color.notepad_margin));
        linePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        linePaint.setColor(myResources.getColor(R.color.notepad_lines));
        // Get the paper background color and the margin width.
        paperColor = myResources.getColor(R.color.notepad_paper);
        margin = myResources.getDimension(R.dimen.notepad_margin);
    }

    /***************************** Update this code ****************************/

}