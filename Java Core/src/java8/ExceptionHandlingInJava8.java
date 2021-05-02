package java8;

import java.util.function.BiConsumer;

public class ExceptionHandlingInJava8 {
	
	public static void main(String[] args) {
		
		/*So here we are going to perform some mathematical operation on an array of elements of type int with the help of the key using the lambda expression*/
		int[] someNumbers= {1,2,3,4};
		/*Will perform the divide operation and as we know if we will divide anything by 0 in java it throws an ArithmeticException so we are going to handle that exception*/
		int key=0;
		/*process is the method which will be used by the lambda expression, invoking the wrapperLambda() which is  returning the lambda expression which is invoking the actual lambda expression. */
		process(someNumbers, key,wrapperLambda((v,k)->System.out.println(v/k)));
		
	}
	
	/*BiConsumer is a functional interface which have only one abstract method which takes two arguments and returns nothing so we need something like that for our lambda expression as we would be 
	 * taking two arguments and would be doing syso only*/
	private static void process(int[] someNumbers, int key, BiConsumer<Integer,Integer> biConsumer)
	{
		for(int i: someNumbers)
			/*So from here wrapper lambda expression will get called and that lambda expression will invoke the actual lambda expression*/
			biConsumer.accept(i, key);
	}
	
	/*this method is getting used for exception handling as we want our actual lambda expression to be precise and concise, this method can be defined separately as well in generic way and can
	 * be used for the Exception handling for BiConsumer interface. This lambda expression will get called from process method.*/
	private static BiConsumer<Integer,Integer> wrapperLambda(BiConsumer<Integer,Integer> biConusmer)
	{
		return (v,k)->
		{
			try
			{
				biConusmer.accept(v, k);
			}
			catch(ArithmeticException ae)
			{
				System.out.println("arithemetic Exception occured...");
			}
		};
	}

}
