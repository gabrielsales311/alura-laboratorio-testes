package br.com.brq.argentum.indicadores;

import java.lang.reflect.Constructor;

public class IndicadorFactory {

	private Object nomeMedia;
	private String nomeIndicadorBase;

	public IndicadorFactory(String nomeMedia, String nomeIndicadorBase) {
		this.nomeMedia = nomeMedia;
		this.nomeIndicadorBase = nomeIndicadorBase;
	}

	public  Indicador defineIndicador() {
		if (nomeMedia == null || nomeIndicadorBase == null) {
			return new MediaMovelSimples(new IndicadorFechamento());
		}
		try {
			String pacote = "br.com.brq.argentum.indicadores.";

			Class<?> classeIndicadorBase = Class.forName(pacote + nomeIndicadorBase);
			Indicador indicadorBase = (Indicador) classeIndicadorBase.newInstance();

			Class<?> classeMedia = Class.forName(pacote + nomeMedia);
			Constructor<?> construtor = classeMedia.getConstructor(Indicador.class);
			Indicador indicador = (Indicador) construtor.newInstance(indicadorBase);

			return indicador;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
