
public class ToDoListItemView extends AppCompatTextView {

    /***************************** Update this code ****************************/

@Override
public void onDraw(Canvas canvas) {
        // Color as paper
        canvas.drawColor(paperColor);
        // Draw ruled lines
        canvas.drawLine(0, 0, getMeasuredWidth(), 0, linePaint);
        canvas.drawLine(0, getMeasuredHeight(), getMeasuredWidth(), getMeasuredHeight(), linePaint);
        // Draw margin
        canvas.drawLine(margin, 0, margin, getMeasuredHeight(), marginPaint);
        // Move the text across from the margin
        canvas.save();
        canvas.translate(margin, 0);
        // Use the TextView to render the text.
        super.onDraw(canvas);
        canvas.restore();
        }

    /***************************** Update this code ****************************/
}