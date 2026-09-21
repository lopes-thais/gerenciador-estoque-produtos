package com.thais.estoque.dto.estoque;

import com.thais.estoque.domain.Produtos;
import java.util.ArrayList;

public class EstoqueRequest {
    private ArrayList<Produtos> estoque;

    public ArrayList<Produtos> getEstoque() {
        return estoque;
    }

    public void setEstoque(ArrayList<Produtos> estoque) {
        this.estoque = estoque;
    }
}
