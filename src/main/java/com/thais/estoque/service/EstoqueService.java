package com.thais.estoque.service;

import com.thais.estoque.domain.Estoque;
import com.thais.estoque.domain.Produtos;
import com.thais.estoque.dto.estoque.EstoqueRequest;
import com.thais.estoque.dto.estoque.EstoqueResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EstoqueService {

    public EstoqueService(Estoque estoque) {
        this.estoque = estoque;
    }

    private final Estoque estoque;

    public EstoqueResponse adicionarProdutos (EstoqueRequest request){

        List<Produtos> estoqueAtual = estoque.getEstoque();
        List<Produtos> novosProdutos = request.getEstoque();
        ArrayList<Produtos> produtos = new ArrayList<>();

        for (Produtos novoItem : novosProdutos) {
            Produtos produtoExistente = null;

            for (Produtos item : estoqueAtual) {
                if (item.getCodigoProduto() == novoItem.getCodigoProduto()) {
                    produtoExistente = item;
                    break;
                }
            }

            if (produtoExistente != null) {
                produtoExistente.setEstoque(produtoExistente.getEstoque() + novoItem.getEstoque());

                if (novoItem.getDescricaoProduto() != null && !novoItem.getDescricaoProduto().isBlank()) {
                    produtoExistente.setDescricaoProduto(novoItem.getDescricaoProduto());
                }

            } else {
                produtos.add(novoItem);
            }
        }
        this.estoque.getEstoque().addAll(produtos);

        return new EstoqueResponse(this.estoque.getEstoque());
    }
}
