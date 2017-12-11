## About Project

When a class type object data array is sent from the main activity to the other activity, this data is received from the other activity and displayed in it, and then another data of object array is sent from here to the main activity and displayed in it by implementing parcelable interface.

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
c:\\...\Android Studio\lib\junit-4.12.jar => c:\users...\MyService1\app\libs\

## Reference Points

* intent.putParcelableArrayListExtra("datas", datas);
* datas = intent.getExtras().getParcelableArrayList("datas");
