# JsonViewer

Android JSON viewer, to convert JSON Strings to a Friendly Readable Format, it supports expend&collapsed JSON strings.

<img src="https://github.com/smuyyh/Js![Screenshot_20230919_215316_edit_29053291171807](https://github.com/DawallAzllon/JsonViewer/assets/143387831/5ccfadc9-b03a-4de1-839b-f14699bf654c)
![Screenshot_20230919_215319_edit_29065399561346](https://github.com/DawallAzllon/JsonViewer/assets/143387831/e40db1da-9c6e-4098-a10b-0c0e7d54847c)
![Screenshot_20230919_215316_edit_29053291171807](https://github.com/DawallAzllon/JsonViewer/assets/143387831/1c04c8d6-72c9-4468-820d-321bef9bbcaa)
![Screenshot_20230919_215319_edit_29065399561346](https://github.com/DawallAzllon/JsonViewer/assets/143387831/9ab3340d-48af-4a0b-ad60-f4d780948c8a)
onViewer/blob/master/screenshot/screen.png?raw=true" width="270"/>


## Dependencies

```
buildscript {
    repositories {
        ...
        maven { url "https://jitpack.io" }
    }
    dependencies {
        ...
    }
}
```

```
dependencies {
    implementation 'com.github.smuyyh:JsonViewer:1.0.7'
}
```

## Usage

**Step1**

```xml
<HorizontalScrollView
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:fillViewport="true"
    android:orientation="vertical">

	<com.yuyh.jsonviewer.library.JsonRecyclerView
	    android:id="@+id/rv_json"
	    android:layout_width="match_parent"
	    android:layout_height="wrap_content" />
</HorizontalScrollView>
```

**step2**

```java
JsonRecyclerView mRecyclewView = findViewById(R.id.rv_json);
// bind json
mRecyclewView.bindJson("your json strings." || JSONObject || JSONArray);
```

## Code Style

The default code style is like [https://www.json.cn](https://www.json.cn/).

```java
// Color
mRecyclewView.setKeyColor()
mRecyclewView.setValueTextColor()
mRecyclewView.setValueNumberColor()
mRecyclewView.setValueUrlColor()
mRecyclewView.setValueNullColor()
mRecyclewView.setBracesColor()

// TextSize
mRecyclewView.setTextSize()
```

## LICENSE

```
   Copyright 2017 smuyyh, All right reserved.

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
```
