package com.thais.estoque.service;

import com.thais.estoque.domain.Estoque;
import com.thais.estoque.domain.Movimentacoes;
import com.thais.estoque.domain.Produtos;
import com.thais.estoque.dto.movimentacao.MovimentacaoRequest;
import com.thais.estoque.dto.movimentacao.MovimentacaoResponse;
import com.thais.estoque.enums.TipoMovimentacao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovimentacaoService {

    private final ArrayList<Movimentacoes> historico = new ArrayList<>();
    private final Estoque estoque;

    public MovimentacaoService(Estoque estoque) {
        this.estoque = estoque;
    }

    public MovimentacaoResponse movimentar (MovimentacaoRequest movimentacaoRequest){

        List<Produtos> listaProdutos = estoque.getEstoque();
        int movimentacao = movimentacaoRequest.getMovimentacao();
        int codigoProduto = movimentacaoRequest.getCodigoProduto();
        TipoMovimentacao tipo = movimentacaoRequest.getTipo();

        Produtos produtoEncontrado = null;

        for(Produtos produto : listaProdutos){
            if(produto.getCodigoProduto() == codigoProduto) {
                produtoEncontrado = produto;
                break;
            }
        }

        if (produtoEncontrado == null){
            throw new RuntimeException("Não foi possível localizar o código do produto.");
        }

        if (tipo == TipoMovimentacao.SAIDA) {
            if (movimentacao > produtoEncontrado.getEstoque()) {
                throw new RuntimeException("Quantidade de saída maior que o estoque atual. Estoque atual: " + produtoEncontrado.getEstoque());
            }
            int estoqueAtualizado = produtoEncontrado.getEstoque() - movimentacao;
            produtoEncontrado.setEstoque(estoqueAtualizado);

        } else if (tipo == TipoMovimentacao.ENTRADA) {
            int estoqueAtualizado = produtoEncontrado.getEstoque() + movimentacao;
            produtoEncontrado.setEstoque(estoqueAtualizado);
        }

        Movimentacoes movimentacaoRealizada = criarHistorico(codigoProduto, movimentacao, tipo, produtoEncontrado.getDescricaoProduto());

        return new MovimentacaoResponse(
                codigoProduto,
                produtoEncontrado.getDescricaoProduto(),
                movimentacao,
                tipo,
                produtoEncontrado.getEstoque()
        );
    }

    private Movimentacoes criarHistorico (int codigoProduto, int quantidade, TipoMovimentacao tipo, String descricaoProduto){
        Movimentacoes movimentacoes = new Movimentacoes();

        movimentacoes.setId(historico.size() + 1);
        movimentacoes.setCodigoProduto(codigoProduto);
        movimentacoes.setDescricaoProduto(descricaoProduto);
        movimentacoes.setMovimentacao(quantidade);
        movimentacoes.setTipo(tipo);

        this.historico.add(movimentacoes);

        return movimentacoes;
    }

    public List<Movimentacoes> getHistorico(){
        return historico;
    }
}
