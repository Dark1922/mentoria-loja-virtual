package com.mentoria.lojavirtual;

import com.mentoria.lojavirtual.controller.AcessoController;
import com.mentoria.lojavirtual.model.Acesso;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = Application.class)
public class ApplicationTests {

	@Autowired
	private AcessoController acessoController;

	@Test
	public void testeCadastraAcesso() {
		Acesso acesso = new Acesso();
		acesso.setDescricao("ROLE_ADMIN");
		acessoController.salvarAcesso(acesso);
	}

}
