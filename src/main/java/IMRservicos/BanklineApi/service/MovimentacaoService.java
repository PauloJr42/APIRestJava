package IMRservicos.BanklineApi.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import IMRservicos.BanklineApi.DTO.NovaMovimentacao;
import IMRservicos.BanklineApi.model.Correntista;
import IMRservicos.BanklineApi.model.Movimentacao;
import IMRservicos.BanklineApi.model.MovimentacaoTipo;
import IMRservicos.BanklineApi.repository.CorrentistaRepository;
import IMRservicos.BanklineApi.repository.MovimentacaoRepository;

@Service
public class MovimentacaoService {
	
	
	@Autowired
	private MovimentacaoRepository repository;
	
	@Autowired
	private CorrentistaRepository correntistaRepository;
	
	public void save (NovaMovimentacao novaMovimentacao) {
		
		Movimentacao movimentacao = new Movimentacao();
		
		Double valor = novaMovimentacao.getValor();
		if (novaMovimentacao.getTipo() == MovimentacaoTipo.DESPESA)
			valor = valor * -1;
		
		movimentacao.setDatahora(LocalDateTime.now());
		movimentacao.setDescricao(novaMovimentacao.getDescricao());
		movimentacao.setIdConta(novaMovimentacao.getIdConta());
		movimentacao.setTipo(novaMovimentacao.getTipo());
		movimentacao.setValor(valor);
		
		Correntista correntista = correntistaRepository.findById(novaMovimentacao.getIdConta()).orElse(null);
		if(correntista != null ) {
			correntista.getConta().setSaldo(correntista.getConta().getSaldo() + valor);
			correntistaRepository.save(correntista);
		}
		
		repository.save(movimentacao);
		
		
	}
}
