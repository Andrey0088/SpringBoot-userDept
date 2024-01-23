package com.andreySpring.userdept.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andreySpring.userdept.entities.User;
import com.andreySpring.userdept.repositories.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	//isso faz instanciar automaticamente para não precisar usar repository = new repository;
	//usando gestão de depencia
	private UserRepository repository;
	
	@GetMapping
	public List<User> findAll(){
		//busca todos os usuários do banco de dados
		List<User> result = repository.findAll();
		return result;
			//isso manda uma consulta do banco de dados para ver todo mundo e retorna uma lista						
		}
	
	
	@GetMapping(value = "/{id}")
	public User findById(@PathVariable Long id){
		//@PathVariable é para casar o id da URL com o id do parâmetro(linha 32 com linha 33)
		//busca todos os usuários do banco de dados
		User result = repository.findById(id).get();
		//isso retorna um objeto do tipo Optional, então usa o get para pegar o usuário que está dentro desse objeto.		
		return result;
			//isso manda uma consulta do banco de dados para ver todo mundo e retorna uma lista						
		}
	
	@PostMapping
	//para salvar algo novo, usa o verbo http "Post", não "Get"
	//esse método vai responder ao verbo post do http
	//ainda será no mesmo caminho "/users"
	public User insert(@RequestBody User user){
		User result = repository.save(user);	
		//o método save vai enviar pro banco de dados o método save com o objeto já convertido para relacional e vai me retornar uma nova referencia para o objeto salvo(o result) 
		return result;
		}
	}







