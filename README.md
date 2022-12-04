# Schedulize

Schedulize is a desktop application that allows users to keep track of tasks, when
they committed to working on them, and keep track of multiple task groups - called "curriculums" - at the same time.

## Design Patterns

With the significant size of our project, it was paramount that we include various design patterns to avoid
creating code violations or allowing code smells to crop up. While many are primarily included in the backend,
we've also included more front-facing patterns as well, especially in terms of moving from window to window.

### Factories
Our entities make _ample_ use of factories. Each one of our concrete implementations includes a factory to allow for
decoupling between use cases and specific implementations, allowing for far better abstraction. This will allow
us to add more entity implementations in the future, should the need ever arise.

Furthermore, we've also included factories _within_ other factories, for our more complicated entities. The Schedule and
Curriculum factories, in particular, require the ability to create empty, default, values for some of their attributes
in order to avoid any NullPointExceptions during the program lifetime. We've created similarly decoupled versions of
these that take in factories at initialization, as well as factories we've labeled "Prebuilt" that are coupled with
particular instances of dependent factories by choice. This is to simplify testing and to make the Driver more concise;
however, the decoupled versions still exist, should we realize they are simpler for the purposes of any additional
functionality we may want to add in the future.

### Singletons
Our program employs the use of two Singletons. One is for the logged-in user, saved in the InMemoryUser class. This allows all interactors
to reference the currently logged-in user without having an actual reference to the user in their code, which 
makes it far more difficult to create any errors as far as changing the attributes of an inactive user.

The second, the PathManager. This class allows us to easily reconfigure the paths to access certain icons, and it also allows
for easy user saving in a consistent directory within the program files. Furthermore, this class allows us to adhere strictly
to SRP by delegating file access to only one class that holds all relevant information about where requisite data is being stored.

### Observers
We came across an issue while designing out UIs: we knew that UIs had to depend on controllers, so we built our controllers
first. Then, our controllers had to have input boundaries, so we made interactors before that. In order for these
interactors to present information, however, they had to use dependency inversion to depend on an output boundary. The presenters
that implemented these boundaries, however, had to be dependent on an interface that the UI would implement.

Each class needed to be dependent on the one before it, causing an ouroboros of architecture classes. The answer was a simple
Observer pattern: instead of having the presenter be directly dependent on an instance of a ViewInterface, we could instead
give the presenter a list of these interfaces as observers which would be empty at initialization. Then, when all the other
classes were complete, we would add the UI as an observer _to_ that presenter, thus closing the loop. This
allows for void-return controllers that do not provide output, while simultaneously giving the presenters the necessary
information from the entities layer. All presenters in the use_cases package follow this design pattern except 
for the display_task_tree use case.

### Iterators
The TimeBlockManager interface extends the Iterable interface, allowing client code to loop over the TimeBlocks
while encapsulating the particular implementation of the aforementioned TimeBlocks. This allows very easy change in the
implementation of how TimeBlocks are stored; client code doesn't need to be readjusted after this change is made.

### Patterns not implemented
#### Builders
In creating the CreateCurriculum use case, it seemed like a reasonable decision to use a Builder for the creation of a curriculum,
rather than using a simple factory. A curriculum has a lot of attributes, and perhaps segmenting the assignment of these
attributes would have made for cleaner code. This is certainly an alternative that may be considered in the future life
of this project.

## SOLID / Clean Architecture
Following from our TA, we made sure to continue writing our program to adhere to the principles learned in class
as best as possible. Each one of our controllers is linked exclusively to one interactor, which, in turn, links exclusively
to one presenter. Our simplified observer pattern even assures that we follow dependency inversion throughout the entire
output process. We've packaged each of our use cases into their folders, and then placed all entities and UIs in their respective
packages, as well, in order to represent the general nature of the UI and the interconnected nature of the backend. The individual
use case code then allows us to keep each controller-interactor-presenter relationship in an isolated environment, so that
we never break the Single Responsibility Principle. We've made sure to label each architecture class as final within other
such class' attributes, so that they are unchanged during runtime. Furthermore, our consistent abstraction and use of interfaces
assures that we do not break the Open-Closed Principle; should we decide to change an algorithm, or a functionality, we need
only write a new class that implements the relevant interface, and call that in the driver instead of the original. No pre-existing
code requires modification.

***

## Important information regarding running the program

**Because of the way Gradle deals with .form files, running this program with IntelliJ's default build configurations
may result in an exit code error.**

In order to properly run this program, a few configurations must be set:

1. From IntelliJ, go to File &#8594; Settings &#8594; Build, Execution, Deployment &#8594; Build Tools
2. Under the Gradle menu, navigate to the "Build and Run" subsection
3. Set "Build and run using" to "IntelliJ IDEA"
4. Apply changes

From here, the program should run, and the user should be greeted with a login screen.

**Running Tests**

1. Following the same steps from above, ensure that you run the _test_ module using Gradle
2. NOTE: Some tests may appear as having errors because your IDE may not detect classes from within the testing module, 
but when runnning the testing module they will still compile and pass.

