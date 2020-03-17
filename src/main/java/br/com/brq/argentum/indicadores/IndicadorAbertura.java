package br.com.brq.argentum.indicadores;

import br.com.brq.argentum.indicadores.Indicador;
import br.com.brq.argentum.modelo.SerieTemporal;

public class IndicadorAbertura implements Indicador{

	@Override
	public double calcula(int posicao, SerieTemporal serie) {
		return serie.getCandle(posicao).getAbertura();
	}

	@Override
	public String toString() {
		return "Abertura";
	}
}
