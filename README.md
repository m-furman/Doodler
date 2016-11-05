# Doodler
A simple drawing app for the Android platform.

## How to run program:
Run the app on your device by clicking the "Run" button in Android Studio or clicking on the app icon. After the app launches, you will 
see all the drawing options in the top action bar of the app. The first icon (from the left) in the action bar is the paint brush, 
which opens up a dialog that allows the user to select brush size and opacity. The second icon in the action bar is the color pallete, 
which opens up a dialog that allows the user to select a color for the brush (by default, the color of the brush is red and it is at full opacity). The third and fourth icons are the undo and redo icons, respectively. 

The overflow menu also contains various options. 'Clear all' allows the user to clear the entire canvas (WARNING: Once cleared, the drawing cannot be retrieved again!), 'Randomize!' recolors the doodle using random colors, 'Camera' allows the user to take a photo to set as the background of the image, and 'Remove image' removes the image from the background (if it is present). Note that the background image comes out somewhat blurry since only the thumbnail image is being used. However, for the purpose of this app, I didn't think it was necessary to use the full size image (since the user ends up drawing/tracing over the photo anyway).

## Online sources:

Used this color picker dialog:
https://github.com/Pes8/android-material-color-picker-dialog

Used this stackoverflow page to help implement undo/redo functionality:
http://stackoverflow.com/questions/18316382/change-path-color-without-changing-previous-paths

Used these icons for the various app options:
https://material.io/icons/

