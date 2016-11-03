package course.examples.doodler;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;

import com.pes.androidmaterialcolorpickerdialog.ColorPicker;

public class MainActivity extends AppCompatActivity {

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
                return true;
            case R.id.randomize:
                _doodleView.randomize();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
