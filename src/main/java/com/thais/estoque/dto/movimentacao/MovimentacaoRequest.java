package com.thais.estoque.dto.movimentacao;

import com.thais.estoque.enums.TipoMovimentacao;

public class MovimentacaoRequest {
    private int codigoProduto;
    private int movimentacao;
    private TipoMovimentacao tipo;

    public MovimentacaoRequest(int codigoProduto, int movimentacao, TipoMovimentacao tipo) {
        this.codigoProduto = codigoProduto;
        this.movimentacao = movimentacao;
        this.tipo = tipo;
    }

    public int getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public int getMovimentacao() {
        return movimentacao;
    }

    public void setMovimentacao(int movimentacao) {
        this.movimentacao = movimentacao;
    }

    public TipoMovimentacao getTipo() {
        return tipo;
    }

    public void setTipo(TipoMovimentacao tipo) {
        this.tipo = tipo;
    }
}
