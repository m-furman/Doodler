package course.examples.doodler;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;


/**
 * Main doodle area.
 */

public class DoodleView extends View {

    int currColor;
    int currWidth;
    int currAlpha;

    List<Stroke> fullDoodle = new ArrayList<Stroke>();
    Stack<Stroke> undoStack = new Stack<Stroke>();

    private class Stroke {
        private Path _path;
        private Paint _paint;
        /* Will capture an array of points for us and map them to the screen. */

        public Stroke(Path path, Paint paint) {
            _path = path;
            _paint = paint;
        }

        public Path getPath(){
            return _path;
        }

        public Paint getPaint() {
            return _paint;
        }
    }

    public DoodleView(Context context) {
        super(context);
        init(null,0);
    }

    public DoodleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs,0);
    }

    public DoodleView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet  attrs, int defStyle) {
        setBackgroundColor(getResources().getColor(R.color.white));
        currColor = Color.RED;
        currWidth = 32;
        currAlpha = 255;
        Paint paint = createPaint(Color.RED, 32, 255);
        fullDoodle.add(new Stroke(new Path(), paint));
    }

    private Paint createPaint(int color, float width, int alpha) {
        Paint paint = new Paint();
        paint.setColor(color);
        paint.setStrokeWidth(width);
        paint.setAlpha(alpha);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        return paint;
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (Stroke stroke: fullDoodle) {
            canvas.drawPath(stroke.getPath(), stroke.getPaint());
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float touchX = motionEvent.getX();
        float touchY = motionEvent.getY();

        switch(motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Stroke stroke = new Stroke(new Path(), createPaint(currColor, currWidth, currAlpha));
                stroke.getPath().moveTo(touchX, touchY);
                fullDoodle.add(stroke);
                break;
            case MotionEvent.ACTION_MOVE:
                fullDoodle.get(fullDoodle.size() - 1).getPath().lineTo(touchX, touchY);
                break;
            case MotionEvent.ACTION_UP:
                break;
        }

        invalidate();
        return true; // true if event was handled, false otherwise
    }

    public void undo() {
        if (fullDoodle.isEmpty()) {
            return;
        } else {
            Stroke lastStroke = fullDoodle.get(fullDoodle.size()-1);
            undoStack.push(lastStroke);
            fullDoodle.remove(fullDoodle.size() - 1);
            invalidate();
            }
    }

    public void redo() {
        if (undoStack.isEmpty()) {
            return;
        } else {
            Stroke toRedo = undoStack.pop();
            fullDoodle.add(toRedo);
            invalidate();
        }
    }

    public void randomize() {
        for (Stroke stroke: fullDoodle) {
            Random rnd = new Random();
            stroke.getPaint().setARGB(stroke.getPaint().getAlpha(), rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        }
        invalidate();
    }


    public void clear() {
        fullDoodle.clear();
        undoStack.clear();
        invalidate();
    }

    public int getCurrColor() {
        return currColor;
    }

    public void setCurrColor(int color) {
        currColor = color;
    }

    public int getCurrAlpha() {
        return currAlpha;
    }

    public void setCurrAlpha(int alpha) {
        currAlpha = alpha;
    }

    public int getCurrWidth() {
        return currWidth;
    }

    public void setCurrWidth(int width) {
        currWidth = width;
    }
}
