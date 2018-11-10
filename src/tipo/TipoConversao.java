package tipo;

public enum TipoConversao {
	
	DE_CELSIUS_PARA_FAHRENHEIT("Conversão de Celsius para Fahrenheit", "C", "F"),
	DE_CELSIUS_PARA_KELVIN("Conversão de Celsius para Kelvin", "C", "K"),
	DE_CELSIUS_PARA_REAUMUR("Conversão de Celsius para Reaumur", "C", "Re"),
	DE_CELSIUS_PARA_RANKINE("Conversão de Celsius para Rankine", "C", "R");
	
	private String descricao;
	private String deUnidade;
	private String paraUnidade;
	
	private TipoConversao(String descricao, String deUnidade, String paraUnidade) {
		this.descricao = descricao;
		this.deUnidade = deUnidade;
		this.paraUnidade = paraUnidade;
	}

	public static TipoConversao fromValue(Integer valor) {
		for (TipoConversao item : values()) {
			if(item.ordinal() == valor) {
				return item;
			}
		}
		return null;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getDeUnidade() {
		return deUnidade;
	}

	public String getParaUnidade() {
		return paraUnidade;
	}
}
