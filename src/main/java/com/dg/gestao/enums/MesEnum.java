/**
 * 
 */
package com.dg.gestao.enums;

public enum MesEnum {

	JANEIRO(1), FEREVEREIRO(2), MARCO(3), ABRIL(4), MAIO(5), JUNHO(6), JULHO(7), AGOSTO(8),SETEMBRO(9), OUTUBRO(10), NOVEMBRO(11), DEZEMBRO(12) ;
	
	private final int value;
	
    private MesEnum(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    
    public String getDescription(final int mes) {
    	
    	String mesRetorno = "";
		switch (mes) {
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
