package br.com.brq.argentum.reader;

import java.io.InputStream;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import br.com.brq.argentum.modelo.Negociacao;
import br.com.brq.argentum.xstream.LocalDateTimeConverter;

public class LeitorXml {
	
	public List<Negociacao> carrega(InputStream inputStream){
		XStream stream = new XStream(new DomDriver());
		stream.registerLocalConverter(Negociacao.class, "data", new LocalDateTimeConverter());
		stream.alias("negociacao", Negociacao.class);
		
		return (List<Negociacao>) stream.fromXML(inputStream);
	}

}
