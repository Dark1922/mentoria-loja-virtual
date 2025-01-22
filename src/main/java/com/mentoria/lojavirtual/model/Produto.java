package com.mentoria.lojavirtual.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "produto")
@SequenceGenerator(name = "seq_produto", sequenceName = "seq_produto", allocationSize = 1)
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_produto")
    private Long id;

    @NotNull(message = "O tipo da unidade deve ser informado")
    @Column(nullable = false)
    private String tipoUnidade;

    @Size(min = 10, message = "Nome do produto deve ter mais de 10 letras")
    @NotNull(message = "Nome do produto deve ser informado")
    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Boolean ativo = Boolean.TRUE;

    @NotNull(message = "Descrição do produto deve ser informada")
    @Column(columnDefinition = "text", length = 2000, nullable = false)
    private String descricao;

    /** Nota item nota produto - ASSOCIAR **/

    @NotNull(message = "Peso deve ser informado")
    @Column(nullable = false)
    private Double peso; /* 1000.55 G */

    @NotNull(message = "Largura deve ser informado")
    @Column(nullable = false)
    private Double largura;

    @NotNull(message = "Altura deve ser informado")
    @Column(nullable = false)
    private Double altura;

    @NotNull(message = "Profundidade")
    @Column(nullable = false)
    private Double profundidade;

    @NotNull(message = "Valor de venda deve ser informado")
    @Column(nullable = false)
    private BigDecimal valorVenda = BigDecimal.ZERO;

    @Column(nullable = false)
    private Integer qtdEstoque = 0;

    private Integer qtdeAlertaEstoque = 0;

    private String linkYoutube;

    private Boolean alertaQtdeEstoque = Boolean.FALSE;

    private Integer qtdeClique = 0;

    @NotNull(message = "A empresa responsável deve ser informada")
    @ManyToOne(targetEntity = Pessoa.class)
    @JoinColumn(name = "empresa_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "empresa_id_fk"))
    private PessoaJuridica empresa;



    @NotNull(message = "A Categoria do Produto deve ser informada")
    @ManyToOne(targetEntity = CategoriaProduto.class)
    @JoinColumn(name = "categoria_produto_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "categoria_produto_id_fk"))
    private CategoriaProduto categoriaProduto = new CategoriaProduto();



    @NotNull(message = "A Marca do Produto deve ser informada")
    @ManyToOne(targetEntity = MarcaProduto.class)
    @JoinColumn(name = "marca_produto_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "marca_produto_id_fk"))
    private MarcaProduto marcaProduto = new MarcaProduto();


    @OneToMany(mappedBy = "produto", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ImagemProduto> imagens = new ArrayList<>();

    public void setImagens(List<ImagemProduto> imagens) {
        this.imagens = imagens;
    }

    public List<ImagemProduto> getImagens() {
        return imagens;
    }

    public void setMarcaProduto(MarcaProduto marcaProduto) {
        this.marcaProduto = marcaProduto;
    }

    public MarcaProduto getMarcaProduto() {
        return marcaProduto;
    }

    public void setCategoriaProduto(CategoriaProduto categoriaProduto) {
        this.categoriaProduto = categoriaProduto;
    }


    public CategoriaProduto getCategoriaProduto() {
        return categoriaProduto;
    }

    public PessoaJuridica getEmpresa() {
        return empresa;
    }

    public void setEmpresa(PessoaJuridica empresa) {
        this.empresa = empresa;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoUnidade() {
        return tipoUnidade;
    }

    public void setTipoUnidade(String tipoUnidade) {
        this.tipoUnidade = tipoUnidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getLargura() {
        return largura;
    }

    public void setLargura(Double largura) {
        this.largura = largura;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getProfundidade() {
        return profundidade;
    }

    public void setProfundidade(Double profundidade) {
        this.profundidade = profundidade;
    }

    public BigDecimal getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(BigDecimal valorVenda) {
        this.valorVenda = valorVenda;
    }

    public Integer getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(Integer qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public Integer getQtdeAlertaEstoque() {
        return qtdeAlertaEstoque;
    }

    public void setQtdeAlertaEstoque(Integer qtdeAlertaEstoque) {
        this.qtdeAlertaEstoque = qtdeAlertaEstoque;
    }

    public String getLinkYoutube() {
        return linkYoutube;
    }

    public void setLinkYoutube(String linkYoutube) {
        this.linkYoutube = linkYoutube;
    }

    public Boolean getAlertaQtdeEstoque() {
        return alertaQtdeEstoque;
    }

    public void setAlertaQtdeEstoque(Boolean alertaQtdeEstoque) {
        this.alertaQtdeEstoque = alertaQtdeEstoque;
    }

    public Integer getQtdeClique() {
        return qtdeClique;
    }

    public void setQtdeClique(Integer qtdeClique) {
        this.qtdeClique = qtdeClique;
    }

}