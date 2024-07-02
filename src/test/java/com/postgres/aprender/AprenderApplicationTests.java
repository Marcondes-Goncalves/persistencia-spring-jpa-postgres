package com.postgres.aprender;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.postgres.aprender.dao.InterfaceTelefone;
import com.postgres.aprender.dao.interfaceSpringDataUser;
import com.postgres.aprender.model.Telefone;
import com.postgres.aprender.model.UsuarioSpringData;

@SpringBootTest
class AprenderApplicationTests {

	@Autowired
	private interfaceSpringDataUser interfaceSpringDataUser;

	@Autowired
	private InterfaceTelefone interfaceTelefone;

	@Test
	void testeInserir() {

		System.out.println("Conectado com sucesso");

		UsuarioSpringData usuarioSpringData = new UsuarioSpringData();
		usuarioSpringData.setEmail("goncalves@gmail.com");
		usuarioSpringData.setIdade(23);
		usuarioSpringData.setLogin("teste2");
		usuarioSpringData.setSenha("123456");
		usuarioSpringData.setNome("Teste2 Silva");

		interfaceSpringDataUser.save(usuarioSpringData);

	}

	@Test
	void testeConsulta() {

		System.out.println("Conectado com sucesso");

		Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(2L);

		System.out.println(usuarioSpringData.get().getId());
		System.out.println(usuarioSpringData.get().getNome());
		System.out.println(usuarioSpringData.get().getLogin());
		System.out.println(usuarioSpringData.get().getEmail());
		System.out.println(usuarioSpringData.get().getSenha());
		
	}

	@Test
	void testeConsultaTodos() {

		System.out.println("Conectado com sucesso");

		Iterable<UsuarioSpringData> lista = interfaceSpringDataUser.findAll();

		for (UsuarioSpringData usuarioSpringData : lista) {
			System.out.println(usuarioSpringData.getEmail());
			System.out.println("------------------");
		}

	}

	@Test
	void testeUpdates() {

		System.out.println("Conectado com sucesso");

		Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(2L);

		UsuarioSpringData data = usuarioSpringData.get();

		data.setNome("Marcondes Update Data");

		interfaceSpringDataUser.save(data);

	}

	@Test
	void testeDelete() {

		System.out.println("Conectado com sucesso");

		interfaceSpringDataUser.deleteById(2L);

	}

	@Test
	void testeConsultaNome() {

		System.out.println("Conectado com sucesso");

		List<UsuarioSpringData> lista = interfaceSpringDataUser.buscaPornome("Marcondes");

		for (UsuarioSpringData usuarioSpringData : lista) {
			System.out.println(usuarioSpringData.getNome());
			System.out.println("------------------");
		}

	}

	@Test
	void testeConsultaNomeParam() {

		System.out.println("Conectado com sucesso");

		UsuarioSpringData obj = interfaceSpringDataUser.buscaPorNomeParam("Goncalves Silva");
		
		System.out.println(obj.getNome());
		System.out.println("------------------");
		
	}

	@Test
	void testeDeletarNome() {

		System.out.println("Conectado com sucesso");

		interfaceSpringDataUser.deletePorNome("Goncalves Silva");
		
	}

	@Test
	void testeUpdateEmailPorNome() {

		System.out.println("Conectado com sucesso");

		interfaceSpringDataUser.updateEmailPorNome("marcondes@alterado.com", "Marcondes Goncalves");
		
	}

	@Test
	void testeInserirTelefone() {

		System.out.println("Conectado com sucesso");

		Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(1L);

		Telefone telefone = new Telefone();
		telefone.setTipo("celular");
		telefone.setNumero("82993819188");
		telefone.setUsuarioSpringData(usuarioSpringData.get());
		
		interfaceTelefone.save(telefone);
	}

}
