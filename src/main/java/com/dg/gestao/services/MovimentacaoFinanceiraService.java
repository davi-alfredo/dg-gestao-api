package com.dg.gestao.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dg.gestao.dto.MovimentacaoDTO;
import com.dg.gestao.dto.MovimentacaoFinanceiraDTO;
import com.dg.gestao.entities.MovimentacaoFinanceira;
import com.dg.gestao.repositories.MovimentacaoFinanceiraRepository;


@Service
public class MovimentacaoFinanceiraService {

	@Autowired 
	MovimentacaoFinanceiraRepository repository;	
	
	
	public Page<MovimentacaoFinanceiraDTO> findAll(Pageable pageable) {		
		Page<MovimentacaoFinanceira> result = repository.findAll(pageable);		
		return result.map(x -> new MovimentacaoFinanceiraDTO(x));		
	}
	
	public List<MovimentacaoDTO> obterMovimentacaoAnual(int ano) {
		List<?> consolidado = repository.getConsolidado(ano);
		return  extrairConsolidado(consolidado);
	}
	
	public List<MovimentacaoDTO> getMovimentacaoAgrupada(int ano) {
		List<MovimentacaoDTO> consolidado = repository.getMovimentacaoAgrupada();
		return  consolidado;
	}
	
	
	public MovimentacaoDTO obterMovimentacaoTotaisAnual(int ano) {
		List<?> consolidado = repository.getTotaisAnual(ano);
		
		MovimentacaoDTO movimentacao = new MovimentacaoDTO();
		
		
		for (int i = 0; i < consolidado.size(); i++) {	
			Object[] objetos = (Object[]) consolidado.get(i);
			
			if((Integer)objetos[0] == 1)
				movimentacao.setEntradas((Double)objetos[1]);
			else
				movimentacao.setSaidas((Double)objetos[1]);
		}
		
		
		movimentacao.setTotal(movimentacao.getEntradas() - movimentacao.getSaidas());
		

		
		return movimentacao;
	}
	
	
	private List<MovimentacaoDTO> extrairConsolidado(List<?> consolidado) {
		
		List<MovimentacaoDTO> movimentacoes = new ArrayList<MovimentacaoDTO>();
		MovimentacaoDTO movimentacao = null;
		
		for (int j = 1; j < 12; j++) {			
			
			for (int i = 0; i < consolidado.size(); i++) {			
				
				// 0 - tipo | 1 - valor | 2 - mes
				Object[] objetos = (Object[]) consolidado.get(i);
				
				if((Double)objetos[2] == j) {
					if(movimentacao == null) {
						movimentacao = new MovimentacaoDTO();
						movimentacao.setMes(getMes((Double)objetos[2]));
						movimentacao.setMesNumerico(((Double)objetos[2]).intValue());
					}
					
					if((Integer)objetos[0] == 1)
						movimentacao.setEntradas((Double)objetos[1]);
					else
						movimentacao.setSaidas((Double)objetos[1]);
					
				}				
			}
			
			if(movimentacao != null) {
				movimentacao.setTotal(movimentacao.getEntradas() - movimentacao.getSaidas());
				movimentacoes.add(movimentacao);
			}
			
			movimentacao = null;
		}	
		return movimentacoes;
	}
	
	private String getMes(Double mes) {
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




}
