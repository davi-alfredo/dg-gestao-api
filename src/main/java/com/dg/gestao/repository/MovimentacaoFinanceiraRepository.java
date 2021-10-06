package com.dg.gestao.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dg.gestao.model.MovimentacaoFinanceiraModel;

public interface MovimentacaoFinanceiraRepository extends JpaRepository<MovimentacaoFinanceiraModel, Long> {
	
	
	@Query(value = "SELECT m.tipo_movimentacao_id, SUM(m.valor_pago), EXTRACT(MONTH FROM m.data_pagamento) "
			   + "  FROM movimentacao_financeira m "
			   + " WHERE EXTRACT(YEAR FROM m.data_pagamento) =?1  AND situacao_pagamento_id < 3"
			   + "  GROUP BY m.tipo_movimentacao_id, m.data_pagamento ", nativeQuery = true)
	List<?>getConsolidado(int ano);
	
	@Query(value = "SELECT m.tipo_movimentacao_id, SUM(m.valor_pago) "
			   + "  FROM movimentacao_financeira m "
			   + " WHERE EXTRACT(YEAR FROM m.data_pagamento) =?1  AND situacao_pagamento_id < 3"
			   + "  GROUP BY m.tipo_movimentacao_id", nativeQuery = true)
	List<?>getTotaisAnual(int ano);

	@Query(value = "SELECT * FROM movimentacao_financeira WHERE situacao_pagamento_id = 1", nativeQuery = true )
	List<MovimentacaoFinanceiraModel> getPagos();

	@Query(value = "SELECT * FROM movimentacao_financeira WHERE situacao_pagamento_id > 1", nativeQuery = true )
	List<MovimentacaoFinanceiraModel> getPendencias();
	
	@Query(value = "SELECT * FROM movimentacao_financeira WHERE veiculo_id=?1", nativeQuery = true )
	List<MovimentacaoFinanceiraModel> getByVeiculo(UUID idVeiculo);
	
	@Query(value = "SELECT * FROM movimentacao_financeira WHERE cliente_id=?1", nativeQuery = true )
	List<MovimentacaoFinanceiraModel> getByCliente(UUID idCliente);
}
