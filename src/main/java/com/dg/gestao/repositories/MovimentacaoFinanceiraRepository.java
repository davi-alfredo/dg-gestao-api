package com.dg.gestao.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dg.gestao.dto.SumMovimentacaoDTO;
import com.dg.gestao.entities.MovimentacaoFinanceira;

public interface MovimentacaoFinanceiraRepository extends JpaRepository<MovimentacaoFinanceira, Long> {
	
	
	@Query("SELECT NEW com.dg.gestao.dto.SumMovimentacaoDTO(obj.tipoMovimentacao, SUM(obj.valorPago), EXTRACT(MONTH FROM obj.dataPagamento)) "
			+ " FROM MovimentacaoFinanceira AS obj "
			+ "  WHERE EXTRACT(YEAR FROM obj.dataPagamento) =?1  AND obj.situacaoPagamento < 3 "			
			+ " GROUP BY obj.tipoMovimentacao, EXTRACT(MONTH FROM obj.dataPagamento) ")
	List<SumMovimentacaoDTO> getMovimentacaoAgrupada(int ano);
	
	@Query("SELECT NEW com.dg.gestao.dto.SumMovimentacaoDTO(obj.tipoMovimentacao, SUM(obj.valorPago)) "
			   + "  FROM MovimentacaoFinanceira obj "
			   + " WHERE EXTRACT(YEAR FROM obj.dataPagamento) =?1  AND situacao_pagamento_id = 1"
			   + "  GROUP BY obj.tipoMovimentacao")
	List<SumMovimentacaoDTO>getTotaisAnual(int ano);

	@Query(value = "SELECT * FROM movimentacao_financeira WHERE situacao_pagamento_id=?1 order by data_vencimento desc", nativeQuery = true )
	List<MovimentacaoFinanceira> getBySituacaoPagamento(int situacao);
	
	
	@Query(value = "SELECT * FROM movimentacao_financeira order by data_vencimento desc limit 50", nativeQuery = true )
	List<MovimentacaoFinanceira> getAllLimit();
	
	@Query(value = "SELECT * FROM movimentacao_financeira WHERE tipo_movimentacao_id=?1 and situacao_pagamento_id < 3 order by data_vencimento desc limit 50", nativeQuery = true )
	List<MovimentacaoFinanceira> getByTipoMovimentacao(int tipoMovimentacao);
	
	@Query(value = "SELECT * FROM movimentacao_financeira WHERE situacao_pagamento_id > 1 order by data_vencimento desc", nativeQuery = true )
	List<MovimentacaoFinanceira> getComPendencia();
	
	@Query(value = "SELECT * FROM movimentacao_financeira WHERE situacao_pagamento_id = 1 order by data_vencimento desc", nativeQuery = true )
	List<MovimentacaoFinanceira> getPagos();

	@Query(value = "SELECT * FROM movimentacao_financeira WHERE situacao_pagamento_id > 1 order by data_vencimento desc", nativeQuery = true )
	List<MovimentacaoFinanceira> getPendencias();
	
	@Query(value = "SELECT * FROM movimentacao_financeira WHERE veiculo_id=?1 and situacao_pagamento_id > 1 order by data_vencimento desc" , nativeQuery = true )
	List<MovimentacaoFinanceira> getPendenciasByVeiculo(UUID idVeiculo);
	
	@Query(value = "SELECT * FROM movimentacao_financeira WHERE cliente_id=?1 and situacao_pagamento_id > 1 order by data_vencimento desc", nativeQuery = true )
	List<MovimentacaoFinanceira> getPendenciasByCliente(UUID idCliente);
	
	@Query(value = "SELECT * FROM movimentacao_financeira WHERE veiculo_id=?1 order by data_vencimento desc" , nativeQuery = true )
	List<MovimentacaoFinanceira> getByVeiculo(UUID idVeiculo);
	
	@Query(value = "SELECT * FROM movimentacao_financeira WHERE cliente_id=?1 order by data_vencimento desc", nativeQuery = true )
	List<MovimentacaoFinanceira> getByCliente(UUID idCliente);

	@Query(value= "SELECT * FROM movimentacao_financeira WHERE EXTRACT(YEAR FROM data_pagamento) =?1 and EXTRACT(MONTH FROM data_pagamento) =?2 order by data_vencimento desc", nativeQuery = true)
	List<MovimentacaoFinanceira> getMovimentacoesByMonthAndYear(int ano, int mes);
}
