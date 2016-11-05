# Doodler
A simple drawing app for the Android platform that I created for CMSC434 (Introduction to Human-Computer Interaction) at the University of Maryland.


<img src="https://lh3.googleusercontent.com/HFj0dURbxINqvgSwiSyKTFy7QJgzc8hhax6pDfvhnltSI0NUCD2zlV_jKCIR7vq1jfadLkjucdkqxo0PBDT8TeDldDNNJ_ESjGtAp7hsDLa4Uf8bjlZVm2QJhm1Ol1iRp6hlXNMHCIK2X2GP-cXtTiS6opjZERbM8HVM4bt41MJlUUjkgwNnuh2e0JBJm44jIjnSzGuY2jLgxeFViPD2mAPS9BZfygqdI35luWBW9nlcOYEbCIVTzvzpOab5X_PodlqHyUBgfxkd7Yqm4BfrddD5m7e1wKMpN4QTWxc86FqbCzRhGC8J0uN4lcnpiGBGinez518He0SSA5OxbK4x4Mi3v3eCq41Za4dYln8kuYW3PqK6Bqqqh8on66e_FKjRG5utsuK0WUao2K3cc3ULQHi632VE2TcamXsFk8-pYMI6oLQmtZqyQXWfDlrS5RJ1WEd7GAKZ1eXJjBf2L4LYdAdamWrpsLfpxu_8z7qc2e-G4yEU0LUNAcM_-ZBflCsPBOGsKopNIOByirhEVxlK39H2uXfmkZ_ns9VOI_hvQ8Ln9G9DFJ32XtEmFhvEB047I9mRgarusSp_UjhrwZHq7YvpIlkl2R3dAhLcbDkRCGxrun7q=w900-h1598-no" width="230" height="400" />
<img src="https://lh3.googleusercontent.com/Qgiu6UxKvXFikZbEnGjVEVDOVoOZVd2M0NHr5U977oik-IFE6WAH0zUuzrAUGRSGS9z8x3mM7jT4Ntwk81VMCPlAp8z0J2c1m9j0NLqweQkTZapS-ZQ_VKk9FucLEEOfBmu0yUWxZ2qgCd8YUyxTTux6sTTMFtbMobprkMpHzKE9R1yw-IxVyelvoZfZ0SofQe7ONGlTOJEOBWBqLTZpxxd-f7W-6YJV9_nYkvfKr-iKzAbN3D2OchGIFaW0Psa0bms4Y57rnQHDZIVS8sNbBofQMtGTdff2iBb3VZX28koIwzIZ9bgesb5hHWRHwxVng5pUrspWP-Jxg2-x2bnrZB3MP1NQZReyf7kyRovQoC1kD64SH35EvyOA68DN8ztot4tH7YOomrl_D0NaDA_BDubOeeR0QxaO61EmhXqMzWa7gYnfzg0HswxLKXV1lqV7UDq7FKTEREZQuEF8j1iRVOxpsrbEIDqPu3Ql5x9iMNFhY3H9k2kVkmAOx45jwk0JOrMu9AQ2kE6_88EAbtU98c5z2NiC2Msaggttk3nSYIJKJ_DrfzqsbCVLiOwZA3XSfxTsjiqFW6jFrASwwpSdj2QI2I2_T5FRGaEFuZHPTYnRRuRS=w900-h1598-no" width="230" height="400" />

## How to run program:
Run the app on your device by clicking the "Run" button in Android Studio or clicking on the app icon. After the app launches, you will 
see all the drawing options in the top action bar of the app. The first icon (from the left) in the action bar is the paint brush, 
which opens up a dialog that allows the user to select brush size and opacity. The second icon in the action bar is the color pallete, 
which opens up a dialog that allows the user to select a color for the brush (by default, the color of the brush is red and it is at full opacity). The third and fourth icons are the undo and redo icons, respectively. 

The overflow menu also contains various options. 'Clear all' allows the user to clear the entire canvas (WARNING: Once cleared, the drawing cannot be retrieved again!), 'Randomize!' recolors the doodle using random colors, 'Camera' allows the user to take a photo to set as the background of the image, and 'Remove image' removes the image from the background (if it is present). To obtain the image for the background, the most recently captured photo is retrieved from the user's device.

**NOTE :** Depending on the particular device you are using to run this app, simply putting permissions in the Application Manifest file may not be enough. It may be necessary to explicitly allow the Doodler app to excess the camera and storage of the device. See the image below: 

<img src="https://lh3.googleusercontent.com/iEmmx20B3JatwOpZojxI5BGZeEx9Owu1qMoOcJf-uiTsPViV3PKtbLmSxV46HZ1RqaHP2RlLaGXLxQcf7qOzYD5gbKvJNckXx1HGvGrKQnYxJK4v1kw5_IYyya9Rd0iSEZKaOX1aK45fD0-mHcFTsQikFCJEXfqHd7sY4bYJ0CZYFqhoWtmP0ExHYISC2O1pdXB6uifYpfLhxoKzqhKVzXsHq4581Pjo6pRgmEhPgk_DDs2Ekl4srTD7BFPbpUBb2gG6iI3vHYK8zOEcVp4hXMh-dQ0AEHl87Q9XtlIq1DicpftIspHqyvf8FWirK-GeEiO_jP8wZzjMHpOrcnCdK_-4rRNZ870gV67DM4rPfg4EguEvTWTliyqzZQm8570vhuOFhh5VIun_LeleLtNMF6bMGfPc87lTBnhTFaOUgAht4YvS81x_yR-kGZTxT8thFBsuI2GewLg8AzaV7uoFnliL8BIZ6WQoTMw93u7PvCx8gYp1GKntVaRbbgiOLr9ShL_g6SJbqmk6ldcPZ7piLfAdTnSyN93ZFp3QvhiY8Di_UbmBLcdPO_gVT-NiqKGG_9OffIQBKjIbkU8vLo19ViJoTqB7mroOveJfMX1GIl3ufHt8=w900-h1598-no" width="230" height="400" />

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


