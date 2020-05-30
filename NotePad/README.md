# 期中实验_NotePad笔记本应用
## 一、NoteList中显示条目增加时间戳显示
### 过程及重要代码
要增加时间戳，首先要获取当前时间，北京时间要用GMT时间加八小时得到（这里是创建Note时获取的时间）<br>
```java
    Date date = new Date(now);
    SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    format.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
    String formatDate = format.format(date);
```
原程序已经在数据库SQLite定义好了时间变量，所以可以把获取到的时间赋值给时间变量<br>
![](https://github.com/ZHY-JOE/MyProject/blob/master/NotePad/4.png)<br>
```java
    if (values.containsKey(NotePad.Notes.COLUMN_NAME_CREATE_DATE) == false) {
            values.put(NotePad.Notes.COLUMN_NAME_CREATE_DATE, formatDate);
        }

    if (values.containsKey(NotePad.Notes.COLUMN_NAME_MODIFICATION_DATE) == false) {
        values.put(NotePad.Notes.COLUMN_NAME_MODIFICATION_DATE, formatDate);
    }
```
时间戳是显示在每条Note的下面，所以在noteslist_item.xml添加一个用于显示时间戳的TextView<br>
```java
    <TextView
        android:id="@+id/text1_date"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:textSize="17dp"
        android:paddingLeft="5dip"
    />
```
接着在它的java文件NoteList.java中关于显示Note的函数里加上时间的显示<br>
```java
    private static final String[] PROJECTION = new String[] {
            NotePad.Notes._ID, // 0
            NotePad.Notes.COLUMN_NAME_TITLE, // 1
            NotePad.Notes.COLUMN_NAME_MODIFICATION_DATE //日期
    };
    private static final int COLUMN_INDEX_TITLE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setDefaultKeyMode(DEFAULT_KEYS_SHORTCUT);
        Intent intent = getIntent();
        if (intent.getData() == null) {
            intent.setData(NotePad.Notes.CONTENT_URI);
        }
        getListView().setOnCreateContextMenuListener(this);
        Cursor cursor = managedQuery(
            getIntent().getData(),            // Use the default content URI for the provider.
            PROJECTION,                       // Return the note ID and title for each note.
            null,                             // No where clause, return all records.
            null,                             // No where clause, therefore no where column values.
            NotePad.Notes.DEFAULT_SORT_ORDER  // Use the default sort order.
        );
        String[] dataColumns = {
                NotePad.Notes.COLUMN_NAME_TITLE,
                NotePad.Notes.COLUMN_NAME_MODIFICATION_DATE
        } ;
        int[] viewIDs = {
                android.R.id.text1,
                R.id.text1_date
        };
        SimpleCursorAdapter adapter
            = new SimpleCursorAdapter(
                      this,                             // The Context for the ListView
                      R.layout.noteslist_item,          // Points to the XML for a list item
                      cursor,                           // The cursor to get items from
                      dataColumns,
                      viewIDs
              );
```
还要在NoteEditor.java里也添加获取时间的功能（这里是编辑Note时获取的时间）
![](https://github.com/ZHY-JOE/MyProject/blob/master/NotePad/5.png)<br>
### 效果截图
![](https://github.com/ZHY-JOE/MyProject/blob/master/NotePad/1.png)<br>
## 二、添加笔记查询功能（根据标题查询） 
### 过程及重要代码
先在顶部的栏中添加查找的图标,这里用的是Android Studio自带图标库里的ic_menu_search<br>
![](https://github.com/ZHY-JOE/MyProject/blob/master/NotePad/6.png)<br>
```java
    <item
        android:id="@+id/menu_search"
        android:icon="@android:drawable/ic_menu_search"
        android:title="Search"
        app:showAsAction="always" />
```
### 效果截图
![](https://github.com/ZHY-JOE/MyProject/blob/master/NotePad/2.png)<br>
![](https://github.com/ZHY-JOE/MyProject/blob/master/NotePad/3.png)<br>
