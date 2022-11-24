# Schedulize

Schedulize is a desktop application that allows users to keep track of tasks, when
they committed to working on them, and keep track of multiple task groups - called "curriculums" - at the same time.

## Important information regarding running the program

**Because of the way Gradle deals with .form files, running this program with IntelliJ's default build configurations
may result in an exit code error.**

In order to properly run this program, a few configurations must be set:

1. From IntelliJ, go to File &#8594; Settings &#8594; Build, Execution, Deployment &#8594; Build Tools
2. Under the Gradle menu, navigate to the "Build and Run" subsection
3. Set "Build and run using" to "IntelliJ IDEA"
4. Apply changes

From here, the program should run, and the user should be greeted with a login screen.