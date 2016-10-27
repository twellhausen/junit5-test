# junit5-test

This is the result of a little code exercise to try out some of the new
features of JUnit 5. 

In particular, I was interested in 

* nested test classes,
* parameter injection and 
* conditional test runs. 

For each of these cases, there is a package with some code.

In order to run the tests, let Gradle do the job:

```
./gradlew test
```

Note that one of the test is supposed to run at random and fail if it runs...
