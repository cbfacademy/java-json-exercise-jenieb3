# JSON Data and Java

[![Java Language](https://img.shields.io/badge/PLATFORM-OpenJDK-3A75B0.svg?style=for-the-badge)][1]
[![JUnit5 Testing Framework](https://img.shields.io/badge/testing%20framework-JUnit5-26A162.svg?style=for-the-badge)][2]
[![Maven Dependency Manager](https://img.shields.io/badge/dependency%20manager-Maven-AA215A.svg?style=for-the-badge)][3]

The goal of these programming exercises is to practise I/O concepts:
- Reading JSON data from a JSON file
- Writing JSON data to a JSON file

For the exercise below, we've provided the starter project above.

This exercise uses the [Gson](https://github.com/google/gson) library. Javadocs can be found [here](https://www.javadoc.io/doc/com.google.code.gson/gson/latest/com.google.gson/module-summary.html).

## Prerequisites

This starter project uses the Java programming language.

Before getting started, ensure you have Java 17 LTS (or higher) installed locally. The following commands should output the version of Java installed.

```bash
$ javac -version

javac 17.0.4
```


```bash
$ java -version

openjdk version "17.0.4" 2022-07-19 LTS
OpenJDK Runtime Environment Zulu17.36+13-CA (build 17.0.4+8-LTS)
OpenJDK 64-Bit Server VM Zulu17.36+13-CA (build 17.0.4+8-LTS, mixed mode, sharing)
```

## Getting Started

1. Clone this repository to your local machine.
```bash
git clone git@github.com:cbfacademy/java-json-exercise-[your student identifier].git
cd java-json-exercise-[your student identifier]
git checkout -b ${your-branch-name}
```

3. Open in Visual Studio Code (or your preferred IDE).
4. Install the project dependencies and validate your project by running the following command in a terminal at the root of your project:

```bash
./mvnw clean validate
```

If you are on a Windows machine, that will be:

```bash
mvnw clean validate
```

You should see the following console output:

```bash
$ ./mvnw clean validate

[INFO] Scanning for projects...
[INFO] 
[INFO] ------------------------< com.cbfacademy:apis >-------------------------
[INFO] Building apis 1.0.0
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- clean:3.2.0:clean (default-clean) @ apis ---
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.127 s
[INFO] Finished at: 2023-10-02T18:13:03+01:00
[INFO] ------------------------------------------------------------------------
```

## :pushpin: Read JSON file

Create a class called `JSONFileHandler` with the following `static` methods:

```java
public List<String> readFile(String filename)
```

The `readFile` method should:
- return a `List<Employee>` object, where each list item is an Employee object (the `Employee.java` class has been provided for you.)

## :pushpin: Write to JSON file

Add the following `static` method to the `JSONFileHandler` class:

```java
public void save(Employee employee, String outputFile)
```

The `save` method should:
- save the given `employee` to the path defined by `outputFile`.
- create `outputFile` if it doesn't exist and update the file to include the new object, if it does.

### :bookmark: Note:
The paths to `inputFile` and `outputFile` are relative to the root directory of this repository. 

## :white_check_mark: Verify Your Implementation

To verify that your code works as expected, run the provided unit tests.

In your terminal, ensure that you are in the folder for this exercise. Then run the following command in your terminal:

```shell
./mvnw clean test
```

If you are on Windows, run this command instead:

```shell
mvnw.cmd clean test
```

### Tests Results

Your implementation is correct when all tests pass:

```shell
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] ├─ App Test Suite - 0.021s
[INFO] │  └─ ✔ creates the app - 0.013s
[INFO] ├─ JSON File Exercise - 0.153s
[INFO] │  ├─ ✔ readFile() throws FilenameException when file is not a .json file - 0.121s
[INFO] │  ├─ ✔ save() adds data to existing file - 0.021s
[INFO] │  ├─ ✔ readFile() returns file contents - 0.003s
[INFO] │  └─ ✔ save() creates new file when file does not yet exist - 0.004s
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 5, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  1.400 s
[INFO] Finished at: 2023-09-29T06:17:43+01:00
[INFO] ------------------------------------------------------------------------

```
## Class usage
Once you've verified your class works correctly, you can utilise it in `App.java`.

Add the following methods and call them from the `main` method:

```java
public static List<Employee> readFile(String filePath) {}

public static void saveToFile(Employee employee, String targetPath) {}
```

The `readFile` method should:
- use the static readFile method in `JSONFileHandler` to read the contents of the sample file we've provided at `resources/example.json`
- return a `List` of `Employee` objects

The `saveToFile` method should:
- use the static `save` method in `JSONFileHandler`  to save a new `Employee` object to a new file at `resources/employees.json`

[1]: https://docs.oracle.com/javase/11/docs/api/index.html
[2]: https://junit.org/junit5/
[3]: https://maven.apache.org/
