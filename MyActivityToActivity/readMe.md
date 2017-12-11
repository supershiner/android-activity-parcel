## About Project

When a class type object data array is sent from main activity to other activity, 
it is received from the service and displayed in this activity, 
and then displayed in mainactivity after sent back to the mainactivity by implementing parcel.

## Build Settings
```
compileSdkVersion 25
buildToolsVersion "25.0.0"
...
    minSdkVersion 15
    targetSdkVersion 22
...  

    compile 'com.android.support:appcompat-v7:25.+'
    ...
    compile files('libs/junit-4.12.jar')
```
> c:\\...\Android Studio\lib\junit-4.12.jar => c:\users\...\MyService1\app\libs\


