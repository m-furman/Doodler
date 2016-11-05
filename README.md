# Doodler
A simple drawing app for the Android platform that I created for CMSC434 (Introduction to Human-Computer Interaction) at the University of Maryland.

## How to run program:
Run the app on your device by clicking the "Run" button in Android Studio or clicking on the app icon. After the app launches, you will 
see all the drawing options in the top action bar of the app. The first icon (from the left) in the action bar is the paint brush, 
which opens up a dialog that allows the user to select brush size and opacity. The second icon in the action bar is the color pallete, 
which opens up a dialog that allows the user to select a color for the brush (by default, the color of the brush is red and it is at full opacity). The third and fourth icons are the undo and redo icons, respectively. 

The overflow menu also contains various options. 'Clear all' allows the user to clear the entire canvas (WARNING: Once cleared, the drawing cannot be retrieved again!), 'Randomize!' recolors the doodle using random colors, 'Camera' allows the user to take a photo to set as the background of the image, and 'Remove image' removes the image from the background (if it is present). To obtain the image for the background, the most recently captured photo is retrieved from the user's device.

**NOTE :** Depending on the particular device you are using to run this app, simply putting permissions in the Application Manifest file may not be enough. It may be necessary to explicitly allow the Doodler app to excess the camera and storage of the device. See the image below: //TODO

## Online sources:

Used this color picker dialog:
https://github.com/Pes8/android-material-color-picker-dialog

Used this stackoverflow page to help implement undo/redo functionality:
http://stackoverflow.com/questions/18316382/change-path-color-without-changing-previous-paths

Used these icons for the various app options:
https://material.io/icons/

Used this utility code to rotate image taken by the camera into the correct orientation:
https://gist.github.com/9re/1990019

Used this for help with saving a view to an image file:
http://stackoverflow.com/questions/3107527/android-save-view-to-jpg-or-png


