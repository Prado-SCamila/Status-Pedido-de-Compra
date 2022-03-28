package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Cliente {

    // CORES.............................................................

    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_BRIGHT_YELLOW = "\u001B[93m";
    public static final String ANSI_BRIGHT_BLUE = "\u001B[94m";

    public static final String ANSI_RESET = "\u001B[0m";
    // ......................................................................

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    private String nome;

    private String email;

    private Date birthdate;

    public String getNome() {
        return nome;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setDate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cliente() {

    }

    public Cliente(String nome, String email, Date birthdate) {
        this.nome = nome;
        this.email = email;
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {

        return (ANSI_BRIGHT_YELLOW + "  Nome: " + ANSI_RESET + nome + ANSI_BRIGHT_YELLOW + " Data de nascimento: "
                + ANSI_RESET + (sdf.format(birthdate)) + ANSI_BRIGHT_YELLOW + " Email:  " + ANSI_RESET + email);
    }

}