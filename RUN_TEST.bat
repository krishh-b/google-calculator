echo "regression run for google calculator functionality......."
cmd /k mvn test -Dcucumber.filter.tags="@Regression" -DthreadCount="4" -Dbrowser="chrome"