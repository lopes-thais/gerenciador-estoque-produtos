package com.thais.estoque.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Estoque {
    private List<Produtos> estoque = new ArrayList<>();

    public Estoque(){}

    public List<Produtos> getEstoque(){
        return estoque;
    }

    public void setEstoque(ArrayList<Produtos> estoque){
        this.estoque = estoque;
    }
}
