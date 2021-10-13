package com.dg.gestao.config;

public class FirebaseAuthenticationProvider {
	
	private static String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJkZ2xvY2Fkb3JhIiwibmFtZSI6ImRhdmlkZ2xlZHNvbmFwcGd5dmVyIiwiaWF0IjoyMDE5MzAwM30.k0kySZs-FeV9r3Y2UhYHRc7rndNMhrqK6aXRlr1v1kI";
	
	public  static boolean tokenIsValid(String tokenRequest) {
		return token.equals(tokenRequest);
	}

}
