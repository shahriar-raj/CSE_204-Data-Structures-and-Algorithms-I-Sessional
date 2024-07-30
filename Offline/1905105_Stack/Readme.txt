****----------------------------------------------Assignment-1 : List------------------------------------------------------------------****

There are 7 java files. (6 public class and 1 interface. LL class has 1 nested class)

1.Stack - This is basically an interface which holds all the public functions that the Arr.java and LL.java implements and the users can use.
	 There are 5 functions which are public to the users.

2.Arr -  This has a public Arr<T> class. Here all the functions that are declared in Stack are implemented. It implements Stack interface.
	 And these functions are implemented with the help of arrays.And this is a generic class 
	 which means it can be used for any data types(i.e. Integer, Double, String etc.).

3.LL  -  This has a public LL<T> class. Here all the functions that are declared in Stack are implemented. It implements Stack interface.
	 And these functions are implemented with the help of linked list.And this is a generic class 
	 which means it can be used for any data types(i.e. Integer, Double, String etc.). This includes a nested class named "Node".

4.Dish - Dish class has a main function. Dish.java uses the Arr & LL implementation and designs a dish washing program.

5.Main - Main also has a main function. This is a piece of code that demonstrates the output or test results of Arr and LL implementations.

6.d_t - This represents the dishes. dish numbers and other infos are stored in d_t object. Dish.java uses this class.

7.One_Arr_2_Stack - this implements the dishwasher program by one array and two stack. This file is incomplete.