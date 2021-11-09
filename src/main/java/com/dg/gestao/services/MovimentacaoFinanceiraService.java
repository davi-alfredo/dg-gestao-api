package com.dg.gestao.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.stereotype.Service;

import com.dg.gestao.dto.MovimentacaoConsolidadaDTO;
import com.dg.gestao.dto.MovimentacaoFinanceiraDTO;
import com.dg.gestao.dto.MovimentacaoMensalDTO;
import com.dg.gestao.dto.SumMovimentacaoDTO;
import com.dg.gestao.entities.MovimentacaoFinanceira;
import com.dg.gestao.repositories.MovimentacaoFinanceiraRepository;

@Service
public class MovimentacaoFinanceiraService {

	@Autowired
	MovimentacaoFinanceiraRepository repository;

	/**
	 * Método Responsável pela busca paginada de movimentações financeiras
	 * @param pageable
	 * @return List com objetos do tipo MovimentacaoFinanceiraDTO quem contém informações das movimentações financeiras
	 */
	public Page<MovimentacaoFinanceiraDTO> findAll(Pageable pageable) {
		Page<MovimentacaoFinanceira> result = repository.findAll(pageable);
		return result.map(x -> new MovimentacaoFinanceiraDTO(x));
	}

	/**
	 * Método responsável pela consulta Movimentação anual agrupando as movimentacoes por mes de acordo com o ano informado
	 * @param ano 
	 * @return Objeto com as informações das Movmentações de acordo com o ano informado
	 */
	public MovimentacaoConsolidadaDTO getMovimentacaoByYear(int ano) {
		List<SumMovimentacaoDTO> consolidado = repository.getMovimentacaoAgrupada(ano);
		return complementarDadosMovimentacaoAnual(consolidado);
	}

	/**
	 * Método responsável pela organização das informaçõess das movimsntações e complemento de informações com os cálculos totais
	 * @param movimentacoes
	 * @return
	 */
	private MovimentacaoConsolidadaDTO complementarDadosMovimentacaoAnual(List<SumMovimentacaoDTO> movimentacoes) {

		List<MovimentacaoMensalDTO> movimentacoesMensais = new ArrayList<MovimentacaoMensalDTO>();
		
		MovimentacaoConsolidadaDTO movimentacaoConsolidada = new MovimentacaoConsolidadaDTO(); 
		MovimentacaoMensalDTO movimentacao = null;
		 

		for (int j = 1; j < 12; j++) {
			for (int i = 0; i < movimentacoes.size(); i++) {

				if (movimentacoes.get(i).getMes() == j) {
					if (movimentacao == null) {
						movimentacao = new MovimentacaoMensalDTO();
						movimentacao.setMes(getMes(movimentacoes.get(i).getMes()));
						movimentacao.setMesNumerico(movimentacoes.get(i).getMes());
					}
					

					if (movimentacoes.get(i).getTipoMovimentacao() == 1) {
						movimentacao.setEntradas(movimentacoes.get(i).getTotal());
						movimentacaoConsolidada.setTotalEntradas(movimentacaoConsolidada.getTotalEntradas() + movimentacao.getEntradas());
					}
					else {
						movimentacao.setSaidas(movimentacoes.get(i).getTotal());
						movimentacaoConsolidada.setTotalSaidas(movimentacaoConsolidada.getTotalSaidas() + movimentacao.getSaidas());
					}

				}
			}

			if (movimentacao != null) {
				movimentacao.setTotal(movimentacao.getEntradas() - movimentacao.getSaidas());
				movimentacaoConsolidada.setTotal(movimentacaoConsolidada.getTotal() + movimentacao.getTotal());
				movimentacoesMensais.add(movimentacao);
			}

			movimentacao = null;
		}
		movimentacaoConsolidada.setMovimentacoesMensais(movimentacoesMensais);
		

		return movimentacaoConsolidada;
	}

	/**
	 * Método responsável por retornar a descrição do mês de acordo com o respectivo numeral.
	 * @param mes
	 * @return
	 */
	private String getMes(Integer mes) {
		String mesRetorno = "";
		switch (mes.byteValue()) {
		case 1:
			mesRetorno = "JANEIRO";
			break;
		case 2:
			mesRetorno = "FEVEREIRO";
			break;
		case 3:
			mesRetorno = "MARÇO";
			break;
		case 4:
			mesRetorno = "ABRIL";
			break;
		case 5:
			mesRetorno = "MAIO";
			break;
		case 6:
			mesRetorno = "JUNHO";
			break;
		case 7:
			mesRetorno = "JULHO";
			break;
		case 8:
			mesRetorno = "AGOSTO";
			break;
		case 9:
			mesRetorno = "SETEMBRO";
			break;
		case 10:
			mesRetorno = "OUTUBRO";
			break;
		case 11:
			mesRetorno = "NOVEMBRO";
			break;
		case 12:
			mesRetorno = "DEZEMBRO";
			break;
		default:
			break;
		}

		return mesRetorno;
	}

	public List<MovimentacaoFinanceiraDTO> getMovimentacoesByMonthAndYear(int ano, int mes) {		
		List<MovimentacaoFinanceira> result = repository.getMovimentacoesByMonthAndYear(ano, mes);
		return result.stream().map(movimentacao -> new MovimentacaoFinanceiraDTO(movimentacao)).collect(Collectors.toList());
	}

	
	public List<MovimentacaoFinanceiraDTO> getMovimentacoesByCliente(UUID id) {
		List<MovimentacaoFinanceira> result = repository.getByCliente(id);
		return result.stream().map(movimentacao -> new MovimentacaoFinanceiraDTO(movimentacao)).collect(Collectors.toList());

	}

	public List<MovimentacaoFinanceiraDTO> getMovimentacoesByVeiculo(UUID id) {
		List<MovimentacaoFinanceira> result = repository.getByVeiculo(id);
		return result.stream().map(movimentacao -> new MovimentacaoFinanceiraDTO(movimentacao)).collect(Collectors.toList());
	}

	public List<MovimentacaoFinanceiraDTO> getPendenciasByCliente(UUID id) {
		List<MovimentacaoFinanceira> result = repository.getPendenciasByCliente(id);
		return result.stream().map(movimentacao -> new MovimentacaoFinanceiraDTO(movimentacao)).collect(Collectors.toList());
	}
	
	public List<MovimentacaoFinanceiraDTO> getPendenciasByVeiculo(UUID id) {
		List<MovimentacaoFinanceira> result = repository.getPendenciasByVeiculo(id);
		return result.stream().map(movimentacao -> new MovimentacaoFinanceiraDTO(movimentacao)).collect(Collectors.toList());
	}
	
	public MovimentacaoFinanceiraDTO save(MovimentacaoFinanceira entity) throws Exception {
		try {
			repository.save(entity);
			return new MovimentacaoFinanceiraDTO(entity);
		}catch(Exception e){
			throw new Exception("Houve um erro ao tentar cadastrar a movimentação!");			
		}		
	}
	
	public MovimentacaoFinanceiraDTO update(MovimentacaoFinanceira entity) throws JpaObjectRetrievalFailureException {
		try {
			repository.getById(entity.getId());
			repository.save(entity);
			return new MovimentacaoFinanceiraDTO(entity);
		}catch(JpaObjectRetrievalFailureException e){
			throw e;			
		}		
	}

	public List<MovimentacaoFinanceiraDTO>  getMovimentacoesBySituacaoPagamento(int situacao) {
		
		List<MovimentacaoFinanceira> result = null;
		if (situacao == 0)
			result = repository.findAll(Sort.by(Sort.Direction.DESC, "dataVencimento"));
		else 
			result = repository.getBySituacaoPagamento(situacao);
		
		return result.stream().map(movimentacao -> new MovimentacaoFinanceiraDTO(movimentacao)).collect(Collectors.toList());
		
	}

	public List<MovimentacaoFinanceiraDTO>  getMovimentacoesByTipoMovimentacao(int tipoMovimentacao) {
		
		List<MovimentacaoFinanceira> result = null;
		if (tipoMovimentacao == 0)
			result = repository.getAllLimit();
		else 
			result = repository.getByTipoMovimentacao(tipoMovimentacao);			
		
		return result.stream().map(movimentacao -> new MovimentacaoFinanceiraDTO(movimentacao)).collect(Collectors.toList());
			
	}
	
	

}
