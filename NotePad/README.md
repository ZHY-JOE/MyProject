# 期中实验_NotePad笔记本应用
## 一、NoteList中显示条目增加时间戳显示
### 过程及重要代码
要增加时间戳，首先要获取当前时间，北京时间要用GMT时间加八小时得到</br>
```java
    Date date = new Date(now);
    SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    format.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
    String formatDate = format.format(date);
```
原程序已经在数据库SQLite定义好了时间变量，<br>所以可以把获取到的时间赋值给时间变量
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

## 二、添加笔记查询功能（根据标题查询） 
