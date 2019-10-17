package br.com.pom.automationpractice.model;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;

import java.util.Locale;

public class DadosCliente {

    private String primeiroNome;
    private String ultimoNome;
    private String pass;
    private String endereco;
    private String cidade;
    private Faker faker;

    public DadosCliente() {
        faker = new Faker(new Locale("pt-BR"));
        setPrimeiroNome(faker.name().firstName());
        setUltimoNome(faker.name().lastName());
        setCidade(faker.address().cityName());
        setEndereco(faker.address().streetName());
        setPass("1234@1234");
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getUltimoNome() {
        return ultimoNome;
    }

    public void setUltimoNome(String ultimoNome) {
        this.ultimoNome = ultimoNome;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
