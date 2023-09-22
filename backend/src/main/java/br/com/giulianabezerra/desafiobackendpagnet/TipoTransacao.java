package br.com.giulianabezerra.desafiobackendpagnet;

public enum TipoTransacao {
  DEBITO(1), BOLETO(2), FINANCIAMENTO(3), CREDITO(4), RECEBIMENTO_EMPRESTIMO(5),
  VENDAS(6), RECEBIMENTO_TED(7), RECEBIMENTO_DOC(8), ALUGUEL(9);

  private int tipo;

  private TipoTransacao(int tipo) {
    this.tipo = tipo;
  }

  // Similar to Strategy Pattern
  public int getSinal() {
    return switch (tipo) {
      case 1, 4, 5, 6, 7, 8 -> 1;
      case 2, 3, 9 -> -1;
      default -> 0;
    };
  }

  public static TipoTransacao findByTipo(int tipo) {
    for (TipoTransacao tipoTransacao : values()) {
      if (tipoTransacao.tipo == tipo) {
        return tipoTransacao;
      }
    }
    throw new IllegalArgumentException("Invalid tipo: " + tipo);
  }
}
