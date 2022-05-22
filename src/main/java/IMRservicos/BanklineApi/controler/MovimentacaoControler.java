package IMRservicos.BanklineApi.controler;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import IMRservicos.BanklineApi.DTO.NovoCorrentista;
import IMRservicos.BanklineApi.model.Movimentacao;
import IMRservicos.BanklineApi.repository.MovimentacaoRepository;
import IMRservicos.BanklineApi.service.CorrentistaService;

@RestController
@RequestMapping ("/movimentacoes")
public class MovimentacaoControler {
	
	@Autowired
	private MovimentacaoRepository repository;
	
	@Autowired
	private CorrentistaService service;
	
	@GetMapping
	public List<Movimentacao> findAll(){
		return repository.findAll();
		
	}
	
	@PostMapping
	public void save(@RequestBody NovoCorrentista correntista) {
		service.save(correntista);
	}

}
