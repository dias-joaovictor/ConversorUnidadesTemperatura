package modelo;

import java.text.MessageFormat;

import tipo.TipoConversao;
import util.Conversor;

public class ValoresConversao {
	
	private static final String MENSAGEM_DEFAULT = "{0}: {1}{2} para {3}{4}";

	private Double valor;
	
	private Double valorConvertido;
	
	private TipoConversao tipoConversao;


	public ValoresConversao(Double valor, TipoConversao tipoConversao) {
		super();
		this.valor = valor;
		this.tipoConversao = tipoConversao;
		converter();
	}

	private void converter() {
		switch (tipoConversao) {
		case DE_CELSIUS_PARA_FAHRENHEIT:
			this.valorConvertido = Conversor.converterCelsiusFahrenheit(valor);
			break;
		case DE_CELSIUS_PARA_KELVIN:
			this.valorConvertido = Conversor.converterCelsiusKelvin(valor);
			break;
		case DE_CELSIUS_PARA_RANKINE:
			this.valorConvertido = Conversor.converterCelsiusRankine(valor);
			break;
		case DE_CELSIUS_PARA_REAUMUR:
			this.valorConvertido = Conversor.converterCelsiusReaumur(valor);
			break;
		default:
			break;
		}
		
	}

	protected Double getValor() {
		return valor;
	}

	protected void setValor(Double valor) {
		this.valor = valor;
	}

	protected Double getValorConvertido() {
		return valorConvertido;
	}

	protected void setValorConvertido(Double valorConvertido) {
		this.valorConvertido = valorConvertido;
	}


	protected TipoConversao getTipoConversao() {
		return tipoConversao;
	}

	protected void setTipoConversao(TipoConversao tipoConversao) {
		this.tipoConversao = tipoConversao;
	}
	
	
	public String obterTextoParaExibiao() {
		return MessageFormat.format(MENSAGEM_DEFAULT, 
				getTipoConversao().getDescricao(), 
				getValor(), 
				getTipoConversao().getDeUnidade(), 
				getValorConvertido(), 
				getTipoConversao().getParaUnidade());
	}

}
