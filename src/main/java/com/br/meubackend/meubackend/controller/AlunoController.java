package com.br.meubackend.meubackend.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import model.dao.AlunoDao;
import model.dao.DaoFactory;
import model.entities.Aluno;

@RestController
public class AlunoController {
	
	private AlunoDao dao = DaoFactory.createAlunoDao();

    @RequestMapping(value = "/aluno", method = RequestMethod.GET)
    public String Get() {
    	
    	List<Aluno> findAll = findAll();
    	
    	List<String> retorno = new ArrayList<String>();
    	
    	/*
    	for (Aluno aluno : findAll) {
			retorno.add(aluno.getName());
		}*/
    	
    	Gson gson = new Gson();
    	String json = gson.toJson(findAll);
        
    	//Dados dados = gson.fromJson(new String(output.getBytes()), Dados.class);
    	
    	//retorno.add("Hellow word");
        return json;
    }
    
    @RequestMapping(value = "/saveAluno", method =  RequestMethod.POST)
    public void Post(@Valid @RequestBody String nomeAluno)
    {
    	Aluno alunObj = new Aluno();
    	alunObj.setName(nomeAluno); 
        dao.insert(alunObj);
    }
    
    @RequestMapping(value = "/deleteAluno", method =  RequestMethod.POST)
    public void Delete(@Valid @RequestBody String id)
    {
    	 
        dao.deleteById(Integer.parseInt(id));
    }

    public List<Aluno> findAll() {
    	return dao.findAll();
    }
}
