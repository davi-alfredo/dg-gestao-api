package com.dg.gestao.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.gestao.dto.MovimentacaoMensalDTO;
import com.dg.gestao.repository.MovimentacaoFinanceiraRepository;


@Service
public class MovimentacaoFinanceiraService {

	@Autowired 
	MovimentacaoFinanceiraRepository repository;	
	
	
	public List<MovimentacaoMensalDTO> obterMovimentacaoAnual(int ano) {
		
		List<?> consolidado = repository.getConsolidado(ano);
		
		return  extrairConsolidado(consolidado);
	}
	
	
	private List<MovimentacaoMensalDTO> extrairConsolidado(List<?> consolidado) {
		
		List<MovimentacaoMensalDTO> movimentacoes = new ArrayList<MovimentacaoMensalDTO>();
		MovimentacaoMensalDTO movimentacao = null;
		
		for (int j = 1; j < 12; j++) {			
			
			for (int i = 0; i < consolidado.size(); i++) {			
				
				// 0 - tipo | 1 - valor | 2 - mes
				Object[] objetos = (Object[]) consolidado.get(i);
				
				if((Double)objetos[2] == j) {
					if(movimentacao == null) {
						movimentacao = new MovimentacaoMensalDTO();
						movimentacao.setMes(getMes((Double)objetos[2]));
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
