package br.com.brq.argentum.indicadores;

import br.com.brq.argentum.modelo.SerieTemporal;

public interface Indicador {

	double calcula(int posicao, SerieTemporal serie);

}