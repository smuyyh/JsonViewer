# JsonViewer

Android JSON viewer, to convert JSON Strings to a Friendly Readable Format, it supports expend&collapsed JSON strings.

<img src="https://github.com/smuyyh/JsonViewer/blob/master/screenshot/screen.png?raw=true" width="270"/>


## Dependencies

```
compile 'com.yuyh.json:jsonviewer:1.0.0'
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