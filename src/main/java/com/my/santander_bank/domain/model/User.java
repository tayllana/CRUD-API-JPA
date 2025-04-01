package com.my.santander_bank.domain.model;
import jakarta.persistence.*;

import java.util.List;

@Entity(name = "tb_user")
public class User {

    @Id // Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment
    private Long id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL) // Conexão entre as tabelas
    private Account account;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER) // fetch = FetchType.EAGER`: Ao buscar um `User` do banco de dados, todas as suas `Feature` serão carregadas imediatamente.
    private List<Feature> features;

    @OneToOne(cascade = CascadeType.ALL)
    private Card card;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER) // fetch = FetchType.EAGER`: Ao buscar um `User` do banco de dados, todas as suas `News` serão carregadas imediatamente.
    private List<News> news;

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public Account getAccount() {return account;}
    public void setAccount(Account account) {this.account = account;}

    public List<Feature> getFeatures() {return features;}
    public void setFeatures(List<Feature> features) {this.features = features;}

    public Card getCard() {return card;}
    public void setCard(Card card) {this.card = card;}

    public List<News> getNews() {return news;}
    public void setNews(List<News> news) {this.news = news;}
}
