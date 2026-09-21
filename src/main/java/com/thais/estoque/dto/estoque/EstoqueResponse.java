package com.thais.estoque.dto.estoque;

import com.thais.estoque.domain.Produtos;
import java.util.List;

public class EstoqueResponse {
    private List<Produtos> estoque;

    public EstoqueResponse() {
    }

    public EstoqueResponse(List<Produtos> estoque) {
        this.estoque = estoque;
    }

    public List<Produtos> getEstoque() {
        return estoque;
    }

    public void setEstoque(List<Produtos> estoque) {
        this.estoque = estoque;
    }
}
