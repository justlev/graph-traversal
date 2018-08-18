# CityMapper Walking Route Task
Actually a graph traversal-path-search challenge :)
<br />
Project was built using JDK 1.8. Please make sure you have the correct version of Java installed.


## Structure
I approached the task with a standart OOP approach. <br />
Separated the concerns, kept the objects clean and tidy, with a single responsibility.
<br />
<br />
Implemented a very simple DI container, and used DI everywhere so you could switch to another algorithm or implementations easily and hassle-free.

## Algorithm
There is a ITraversalAlgorithm interface, and I wrote my own implementation of the Dijkstra's algorithm.
It seemed like a perfect fit for this task, since it is exactly the algorithm we need for a weightened, unidirectional graph traversal.

## To run
Simply invoke the java program and pass in 3 arguments - the file with the data, the "from" node, and the "to" node.
You can also use the ```run.sh``` to run the program, just like the instruction required.
```./run.sh ./citymapper-coding-test-graph.dat 1524235806 876500321```
<br />
<br />
If for some reason the run.sh script is not working for you, please run it this way:
```java -jar ./citymapper.jar ./citymapper-coding-test-graph.dat 1524235806 876500321```  
 
## What else would I do?
1. I would add full unit-test and system-test coverage. I didn't, since the task forbids the use of any 3rd party libraries.
2. in ```DijkstraAlgorithm.java```, there is a method ```getClosestItem```. I do not like it's implementation, it's a bit ugly. I would have used the TreeSet or TreeMap in order to have a sorted representation of the nodes-to-distances.
