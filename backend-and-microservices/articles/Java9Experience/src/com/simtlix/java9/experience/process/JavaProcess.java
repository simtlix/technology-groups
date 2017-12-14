package com.simtlix.java9.experience.process;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


/**
 * This class shows some of the new features to manage SO process. This class
 * is designed to be used in Windows. The user can change it in order to explore
 * more options and also use a different operative system.
 */
public class JavaProcess {

	public static void checkProcessAPI() {
		getJavaVersion();
		getProcessInfo();
	    startAndFinishProcess();
	}
	
	/**
	 * This method get the process info of a current program.
	 */
	private static void getProcessInfo() {
		ProcessHandle processHandle = ProcessHandle.current();
	    ProcessHandle.Info processInfo = processHandle.info();
	    System.out.println("PID: " + processHandle.pid());
	    System.out.println("User: " + processHandle.info().user());
	    System.out.println("Name: " + processInfo.command().get());
	}
	
	/**
	 * This method get the Java Version by creating a ProcessBuilder object and then
	 * shows the info kept in ProcessHandler.
	 */
	private static void getJavaVersion() {
	    //Get version
	    ProcessBuilder processBuilder = new ProcessBuilder("java", "--version");
	    ProcessHandle processHandle = null;
		try {
			Process process = processBuilder.inheritIO().start();
		    processHandle = process.toHandle();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	    System.out.println("Java CMD: " + processHandle.toString());

	}
	
	
	/**
	 * This method starts and finishes a process. It uses CompletableFuture which starts a process
	 * asynchronously and then print the PID when user finishes it.
	 */
	private static void startAndFinishProcess() {
	    Process p=null;
		try {
			p = new ProcessBuilder("notepad.exe").start();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	    ProcessHandle processHandle = p.toHandle();
	    System.out.println("Started PID:" + processHandle.pid());
	    CompletableFuture<ProcessHandle> onProcessExit = processHandle.onExit();
	    try {
			onProcessExit.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	    onProcessExit.thenAccept(ph -> {
	    	System.out.println("Stopped PID:" + ph.pid());
	    });

	}
	
}
