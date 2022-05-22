package IMRservicos.BanklineApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import IMRservicos.BanklineApi.model.Movimentacao;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Integer>{

}
