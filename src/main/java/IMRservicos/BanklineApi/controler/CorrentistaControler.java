package IMRservicos.BanklineApi.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import IMRservicos.BanklineApi.model.Correntista;
import IMRservicos.BanklineApi.repository.CorrentistaRepository;

@RestController
@RequestMapping ("/correntistas")
public class CorrentistaControler {
	
	@Autowired
	private CorrentistaRepository repository;
	
	@GetMapping
	public List<Correntista> findAll(){
		return repository.findAll();
		
	}

}
