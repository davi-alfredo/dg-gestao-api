package com.dg.gestao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dg.gestao.model.MovimentacaoFinanceiraModel;

public interface MovimentacaoFinanceiraRepository extends JpaRepository<MovimentacaoFinanceiraModel, Long> {
	
	
	@Query(value = "SELECT m.tipo_movimentacao_id, AVG(m.valor_pago), EXTRACT(MONTH FROM m.data_pagamento) "
			   + "  FROM movimentacao_financeira m "
			   + " WHERE EXTRACT(YEAR FROM m.data_pagamento) =?1  AND situacao_pagamento_id < 3"
			   + "  GROUP BY m.tipo_movimentacao_id, m.data_pagamento ", nativeQuery = true)
	List<?>getConsolidado(int ano);

	@Query(value = "SELECT * FROM movimentacao_financeira WHERE tipo_movimentacao_id=?1", nativeQuery = true )
	List<MovimentacaoFinanceiraModel> getByTipo(int tipo);
}
