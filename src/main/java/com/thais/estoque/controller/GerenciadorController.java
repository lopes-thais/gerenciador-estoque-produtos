package com.thais.estoque.controller;

import com.thais.estoque.domain.Estoque;
import com.thais.estoque.domain.Movimentacoes;
import com.thais.estoque.domain.Produtos;
import com.thais.estoque.dto.estoque.EstoqueRequest;
import com.thais.estoque.dto.estoque.EstoqueResponse;
import com.thais.estoque.dto.movimentacao.MovimentacaoRequest;
import com.thais.estoque.dto.movimentacao.MovimentacaoResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.thais.estoque.service.EstoqueService;
import com.thais.estoque.service.MovimentacaoService;

import java.util.List;

@RestController
@RequestMapping("/estoque")
public class GerenciadorController {

    private final EstoqueService estoque;
    private final MovimentacaoService movimentacao;
    private final Estoque estoqueList;

    public GerenciadorController(EstoqueService estoque, MovimentacaoService movimentacao, Estoque estoqueList) {
        this.estoque = estoque;
        this.movimentacao = movimentacao;
        this.estoqueList = estoqueList;
    }

    @PostMapping("/adicionar")
    public ResponseEntity<EstoqueResponse> adicionarProdutos(@RequestBody EstoqueRequest request){
        EstoqueResponse response = estoque.adicionarProdutos(request);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/movimentar")
    public ResponseEntity<MovimentacaoResponse> movimentarProdutos(@RequestBody MovimentacaoRequest request){
        MovimentacaoResponse response = movimentacao.movimentar(request);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/historico/movimentacoes")
    public ResponseEntity<List<Movimentacoes>> historicoMovimentacoes (){
        List<Movimentacoes> response = movimentacao.getHistorico();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/consultar")
    public ResponseEntity<List<Produtos>> consultarEstoque (){
        List<Produtos> estoque = estoqueList.getEstoque();

        return ResponseEntity.ok(estoque);
    }
}
