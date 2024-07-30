****----------------------------------------------Assignment-3 : Queue-----------------------------------------------------------------****

There are 6 java files. (5 public class and 1 public interface. LL class has 1 nested class)

1.Queue - This is basically an interface which holds all the public functions that the ArrQ.java and LLQ.java implements and the users can use.
	 There are 5 functions which are public to the users.

2.ArrQ -  This has a public ArrQ<T> class. Here all the functions that are declared in Queue are implemented. It implements Queue interface.
	  And these functions are implemented with the help of arrays.And this is a generic class 
	  which means it can be used for any data types(i.e. Integer, Double, String etc.).

3.LLQ  -  This has a public LLQ<T> class. Here all the functions that are declared in Queue are implemented. It implements Queue interface.
	 And these functions are implemented with the help of linked list.And this is a generic class 
	 which means it can be used for any data types(i.e. Integer, Double, String etc.). This includes a nested class named "Node".

4.BankQueue - BankQueue class has a main function. BankQueue.java uses the ArrQ & LLQ implementation and designs a Bank service program.

5.Main - Main also has a main function. This is a piece of code that demonstrates the output or test results of ArrQ and LLQ implementations.

6.Customer - This represents the customers. Entry time and Service time are stored in Customer object. BankQueue.java uses this class.

