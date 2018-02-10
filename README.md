# Teams
Home assignment project for Forza Football

## Technical Information

 - **[OkHttp](http://square.github.io/okhttp/)** is used for network operations, such as getting Json data.
 - **[GreenDao](http://greenrobot.org/greendao/)** is used for database ORM. In addition, it helps application to access data while offline
 - **[Gson](https://github.com/google/gson)** is used for parsing json data and converting them into object model. But also a custom json parser is used since unit testing of Gson makes no sense. Both parsers are available in [Controller.java](https://github.com/pouria-faraji/Teams/blob/master/app/src/main/java/com/forza/home/assignments/teams/controller/Controller.java)
 - **[ButterKnife](http://jakewharton.github.io/butterknife/)** is used for binding views more easily.
 - **RecyclerView** is used for showing data as list.
 - **JUnit 4** is used for testing integrity of received data, and equality of expected and actual data, which is available in [ExampleInstrumentedTest.java](https://github.com/pouria-faraji/Teams/blob/master/app/src/androidTest/java/com/forza/home/assignments/teams/ExampleInstrumentedTest.java)

