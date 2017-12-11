## About Project

When a class type object data array is sent from the main activity to the service, 
it is received from the service and sent back to the mainactivity by implementing parcel.

## build settings
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

## Reference Points

* in MainActivity.java

> intent.putParcelableArrayListExtra("users", users);

* in MyService.java

> users = intent.getExtras().getParcelableArrayList("users");
