package br.com.alura.argentum.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class OlaMundoBean {
	
	private String mensagem = "Essa mensagem veio direto do meu Bean\n";
	private String nome;
	
	public String getMensagem() {
		return mensagem;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void botaoClicado() {
		System.out.println("O botao foi clicado!! Seu nome é " + this.nome);
	}

}
