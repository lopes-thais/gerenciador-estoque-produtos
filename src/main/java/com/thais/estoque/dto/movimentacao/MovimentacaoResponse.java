package com.thais.estoque.dto.movimentacao;

import com.thais.estoque.enums.TipoMovimentacao;

public class MovimentacaoResponse {
    private int codigoProduto;
    private String descricaoProduto;
    private int movimentacao;
    private TipoMovimentacao tipo;
    private int estoque;

    public int getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
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

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoqueResponse) {
        this.estoque = estoqueResponse;
    }

    public MovimentacaoResponse(int codigoProduto,  String descricaoProduto, int movimentacao, TipoMovimentacao tipo, int estoque) {
        this.codigoProduto = codigoProduto;
        this.descricaoProduto = descricaoProduto;
        this.movimentacao = movimentacao;
        this.tipo = tipo;
        this.estoque = estoque;
    }
}
