# VideoSensors modified by MicroscopeIT

The tool will be used to capture video and IMU data simultaneously for object learning purpose. 

The new compiled APK is available at https://drive.google.com/open?id=0B8HG9CD619ZeMmYtN2pnWHNRM2c 
The video and data files are stored on device's primary storage at elab/<date>.

App that records video and motion data from an android smartphone simultaneously. 
The app lets you choose the video quality and the rate at which data is saved.
It can be used to record video and accelerometer, gyroscope, compass, GPS data at the same time.

At the moment it records the following data,
- Video time
- Latitude
- Longitude 
- Speed
- Distance
- Time
- Accelerometer data - X axis
- Accelerometer data - Y axis
- Accelerometer data - Z axis
- Heading
- Heading data - X axis
- Heading data - Y axis
- Heading data - Z axis
- Gyroscope data - X axis
- Gyroscope data - Y axis
- Gyroscope data - Z axis


## Installation 
### Method 1 

 - Download Android Studio.
 - Import this repository into Android Studio.
 - Wait for the project to be loaded. 
 - Connect your android device. Make sure it has developer options enabled.
 - Run the app and choose the android deive when prompted.
 - Android Studio will then install the app on the device. 

### Method 2

- Download apk file (https://drive.google.com/open?id=0B8HG9CD619ZeMmYtN2pnWHNRM2c).
- The name of the file is "VideoSensors.apk".
- Make sure your phone allows installation of apps from unknown sources.
- Copy the app to your phone memory.
- Now on the phone, find the app in phone memory and click on it.
- Android will now install.

## To make changes to code: 

 - Download Android Studio.
 - Import this repository into Android Studio.
 - Wait for the project to be loaded. 
 - MainActivity.java contains code that runs the data and the video.
 - activity_main.xml is the file that contains code that shows how the UI will look like.
 - Make desired changes and click on the 'play' button or 'run' from the toolbar. 



### License

MIT
