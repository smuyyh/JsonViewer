# JsonViewer

Android JSON viewer, to convert JSON Strings to a Friendly Readable Format, it supports expend&collapsed JSON strings.

<img src="https://github.com/smuyyh/JsonViewer/blob/master/screenshot/screen.png?raw=true" width="270"/>


## Dependencies

```
compile 'com.yuyh.json:jsonviewer:1.0.3'
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