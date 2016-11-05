package course.examples.doodler;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;

import com.pes.androidmaterialcolorpickerdialog.ColorPicker;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    public static final int PHOTO_REQUEST = 1;

    private DoodleView _doodleView;
    private ColorPicker colorPicker;
    private Dialog brushSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _doodleView = (DoodleView)findViewById(R.id.doodle_view);

        colorPicker = new ColorPicker(MainActivity.this,
                Color.red(_doodleView.getCurrColor()), Color.green(_doodleView.getCurrColor()), Color.blue(_doodleView.getCurrColor()));

        brushSettings = new Dialog(this);
        View dialogLayout = getLayoutInflater().inflate(R.layout.brush_settings_dialog, (ViewGroup)findViewById(R.id.dialog_root));
        brushSettings.setContentView(dialogLayout);

        SeekBar sizeSeekBar = (SeekBar) dialogLayout.findViewById(R.id.size_seekbar);
        sizeSeekBar.setMax(200);
        sizeSeekBar.setProgress(_doodleView.getCurrWidth());
        sizeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                _doodleView.setCurrWidth(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        SeekBar dialogSeekBar = (SeekBar) dialogLayout.findViewById(R.id.opacity_seekbar);
        dialogSeekBar.setMax(255);
        dialogSeekBar.setProgress(_doodleView.getCurrAlpha());
        dialogSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                _doodleView.setCurrAlpha(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        Button confirmButton = (Button)brushSettings.findViewById(R.id.confirm_button);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                brushSettings.dismiss();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.pen_settings:
                brushSettings.show();
                return true;
            case R.id.color:
                colorPicker.show();
                Button okButton = (Button) colorPicker.findViewById(R.id.okColorButton);
                okButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int selectedColor = colorPicker.getColor();
                        _doodleView.setCurrColor(selectedColor);
                        colorPicker.dismiss();
                    }
                });
                return true;
            case R.id.undo:
                _doodleView.undo();
                return true;
            case R.id.redo:
                _doodleView.redo();
                return true;
            case R.id.clear:
                _doodleView.clear();
                _doodleView.setBackgroundColor(getResources().getColor(R.color.white));
                return true;
            case R.id.randomize:
                _doodleView.randomize();
                return true;
            case R.id.remove_image:
                _doodleView.setBackgroundColor(getResources().getColor(R.color.white));
                return true;
            case R.id.save_image:
                _doodleView.setDrawingCacheEnabled(true);
                Bitmap toSave = _doodleView.getDrawingCache();
                File fPath = Environment.getExternalStorageDirectory();
                File f = null;
                f =  new File(fPath, "Doodler");
                try {
                    if(!f.exists()) {
                        f.mkdirs();
                    }
                    String filename = "d" + UUID.randomUUID().toString();
                    File myImageFile = new File(f.getAbsolutePath()+f.separator+filename+".png");
                    FileOutputStream stream = new FileOutputStream(myImageFile);
                    toSave.compress(Bitmap.CompressFormat.PNG, 80, stream);
                    stream.close();
                    Log.i("SAVE", "SAVE");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                _doodleView.destroyDrawingCache();
                return true;
            case R.id.camera:
                Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, PHOTO_REQUEST);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PHOTO_REQUEST) {
            //Bitmap image = (Bitmap) data.getExtras().get("data");
            //Drawable drawable = new BitmapDrawable(getResources(), image);
            //_doodleView.setBackground(drawable);
            // Find the last picture
            String[] projection = new String[]{
                    MediaStore.Images.ImageColumns._ID,
                    MediaStore.Images.ImageColumns.DATA,
                    MediaStore.Images.ImageColumns.BUCKET_DISPLAY_NAME,
                    MediaStore.Images.ImageColumns.DATE_TAKEN,
                    MediaStore.Images.ImageColumns.MIME_TYPE,
            };
            final Cursor cursor = getContentResolver()
                    .query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, projection, null,
                            null, MediaStore.Images.ImageColumns.DATE_TAKEN + " DESC");

            if (cursor.moveToFirst()) {
                String imageLocation = cursor.getString(1);
                File imageFile = new File(imageLocation);
                if (imageFile.exists()) {   // TODO: is there a better way to do this?
                    Bitmap bm = BitmapFactory.decodeFile(imageLocation);
                    String imagePath = imageFile.getAbsolutePath();
                    Bitmap rotatedBitmap = ExifUtil.rotateBitmap(imagePath,bm);
                    _doodleView.setBackground(new BitmapDrawable(getResources(), rotatedBitmap));
                }
            }
        }
    }
}
