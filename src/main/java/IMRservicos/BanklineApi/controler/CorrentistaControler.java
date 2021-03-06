package IMRservicos.BanklineApi.controler;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import IMRservicos.BanklineApi.DTO.NovoCorrentista;
import IMRservicos.BanklineApi.model.Correntista;
import IMRservicos.BanklineApi.repository.CorrentistaRepository;
import IMRservicos.BanklineApi.service.CorrentistaService;

@RestController
@RequestMapping ("/correntistas")
public class CorrentistaControler {
	
	@Autowired
	private CorrentistaRepository repository;
	
	@Autowired
	private CorrentistaService service;
	
	@GetMapping
	public List<Correntista> findAll(){
		return repository.findAll();
		
	}
	
	@PostMapping
	public void save(@RequestBody NovoCorrentista correntista) {
		service.save(correntista);
	}

}
