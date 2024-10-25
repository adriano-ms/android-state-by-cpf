package com.edu.fateczl.statebycpf;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Adriano M Sanchez
 */
public class Person {

    private String name;
    private String cpf;

    public Person(){
        super();
    }

    public Person(String name, String cpf) {
        this.name = name;
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<String> getStates(){
        switch (cpf.charAt(8)){
            case '1':
                return Arrays.asList("Distrito Federal", "Goiás", "Mato Grosso", "Mato Grosso do Sul", "Tocantins");
            case '2':
                return Arrays.asList("Pará", "Amazonas", "Acre", "Amapá", "Rondônia", "Roraima");
            case '3':
                return Arrays.asList("Ceará", "Maranhão", "Piauí");
            case '4':
                return Arrays.asList("Pernambuco", "Rio Grande do Norte", "Paraíba", "Alagoas");
            case '5':
                return Arrays.asList("Bahia", "Sergipe");
            case '6':
                return Collections.singletonList("Minas Gerais");
            case '7':
                return Arrays.asList("Rio de Janeiro", "Espírito Santo");
            case '8':
                return Collections.singletonList("São Paulo");
            case '9':
                return Arrays.asList("Paraná", "Santa Catarina");
            default:
                return Collections.singletonList("Rio Grande do Sul");
        }
    }
}
