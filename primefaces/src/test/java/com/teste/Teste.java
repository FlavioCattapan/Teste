package com.teste;

import org.junit.Test;

import com.teste.integration.JerseyClientGet;

public class Teste {

	@Test
	public void test() {
		JerseyClientGet jerseyClientGet = new JerseyClientGet();
		jerseyClientGet.run();
	}

}
