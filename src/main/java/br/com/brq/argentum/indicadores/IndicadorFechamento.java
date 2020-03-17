package br.com.brq.argentum.indicadores;

import br.com.brq.argentum.modelo.SerieTemporal;

public class IndicadorFechamento implements Indicador{

	@Override
	public double calcula(int posicao, SerieTemporal serie) {
		return serie.getCandle(posicao).getFechamento();
	}
	@Override
	public String toString() {
	
		return "Fechamento";
	}
}
