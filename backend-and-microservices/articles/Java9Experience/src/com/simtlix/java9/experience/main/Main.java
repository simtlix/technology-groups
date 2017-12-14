package com.simtlix.java9.experience.main;

import com.simtlix.java9.experience.http2.HTTP2Java;
import com.simtlix.java9.experience.immutable.ImmutableFactory;
import com.simtlix.java9.experience.mpc.MillingProjectCoin;
import com.simtlix.java9.experience.process.JavaProcess;

public class Main {

	public static void main(String[] args) {
		System.out.println("Java 9 experience starts...");
		
		//Immutable objects test
		ImmutableFactory.checkImmutability();
		
		//Java Milling Project Coint test
		MillingProjectCoin.checkMillingProjectCoin();
		
		//Process APIs
		JavaProcess.checkProcessAPI();
		
		//HTTP2 Features
		HTTP2Java.checkHTTP2Feature();
	}

}
