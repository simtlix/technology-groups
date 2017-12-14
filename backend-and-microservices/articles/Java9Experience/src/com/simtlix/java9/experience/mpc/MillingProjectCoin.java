package com.simtlix.java9.experience.mpc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;


/**
 * This class presents the enhancement in the Milling Project Coin.
 * Try to modify the class to understand and explore the different features 
 *
 */
public class MillingProjectCoin {

	/*
	 * Variables named _ (underscore) are not longer allowed
	 */
	//private String _="hola";
	private String _stream = "allowed";
	{
		System.out.println(_stream);
	}
	
	public static void checkMillingProjectCoin() {
		tryWithResources();
		checkPrivateMethodsInterface();
		checkGenericInAnonymous();
		
		
		checkSafeVarargsMethod(List.of("one", "two", "three"));
	}
	
	/**
	 * This method tests the try-with-resources in which the resource does not need to
	 * be a fresh variable 
	 */
	private static void tryWithResources() {
		/*
		 * Java 7 requirement:
		 * 
		 * InputStream inputStream = new FileInputStream("test.txt");
			try (InputStream stream = inputStream) {
			
			} catch (IOException e) {}
		 */
		try {
			InputStream inputStream = new FileInputStream( new File("text.txt"));
			try (inputStream) {

				System.out.println("Total file size to read (in bytes) : "
						+ inputStream.available());

				int content;
				while ((content = inputStream.read()) != -1) {
					System.out.print((char) content);
				}

			} catch (IOException e) {
				System.out.println("Error reading file.");
				e.printStackTrace();
			}
		} catch (FileNotFoundException ex) {
			System.out.println("File not found.");
			ex.printStackTrace();
		}
	}

	/**
	 * This method shows that it is possible to create and use an interface 
	 * with privates methods.
	 */
	private static void checkPrivateMethodsInterface() {
		Animal dog = new Dog();
		dog.eat();
		dog.sleep();
		dog.makeSound();
		
		Animal lion = new Lion();
		lion.eat();
		lion.sleep();
		lion.makeSound();	
	}
	
	/**
	 * This method shows that it is possible to add Generic operator in an 
	 * Anonymous class.
	 */
	private static void checkGenericInAnonymous() {
		String[] greetings = { "Hello", "Hi", "Hola", "Ciao" };
	    Iterator<String> iter = new Iterator<>() {
	             int i = 0;

                 @Override
                 public boolean hasNext()
                 {
                    return i < greetings.length;
                 }

                 @Override
                 public String next()
                 {
                    if (!hasNext())
                       throw new NoSuchElementException();
                    return greetings[i++];
                 }
        };
	    
        while (iter.hasNext()) {
	         System.out.println(iter.next());
        }
	 }

	/**
	 * This method shows the utility of the @SafeVarargs. Try removing this 
	 * annotation and check that the compiler will warning you.
	 * @param ls
	 */
	@SafeVarargs
	private static void checkSafeVarargsMethod(List<String>... ls)
	{
	   for (List<String> los: ls)
	      System.out.println(los);
	}

}

