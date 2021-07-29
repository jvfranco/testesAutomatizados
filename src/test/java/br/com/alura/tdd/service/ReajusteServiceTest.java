package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class ReajusteServiceTest {

    private ReajusteService service;
    private Funcionario funcionario;

    @BeforeEach // Informa para que o JUnit chame este método antes de cada teste
    public void inicializarInstancias() {
        System.out.println("Inicializar()");
        this.service = new ReajusteService();
        this.funcionario = new Funcionario("Joao", LocalDate.now(), BigDecimal.valueOf(1000.00));
    }

    @AfterEach // Informa para que o JUnit chame o método após a execucação de cada teste
    public void finalizar() {
        System.out.println("Finalizar()");
    }

    @BeforeAll // Os métodos anotados com @BeforeAll e @AfterAll devem ser anotados com static
    public static void antes() {
        System.out.println("Antes de todos os testes");
    }

    @AfterAll
    public static void depois() {
        System.out.println("Após todos os testes");
    }

    @Test
    @DisplayName("Reajuste de 3% p/ status \"A Desejar\"")
    public void reajusteDeveriaSerDeTresPorcentoQuandoDesempenhoForADesejar() {
        service.concederReajuste(funcionario, Desempenho.A_DESEJAR);

        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    @DisplayName("Reajuste de 15% p/ status \"Bom\"")
    public void reajusteDeveriaSerDeQuinzePorcentoQuandoDesempenhoForBom() {
        service.concederReajuste(funcionario, Desempenho.BOM);

        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    @DisplayName("Reajuste de 20% p/ status \"Otimo\"")
    public void reajusteDeveriaSerDeVintePorcentoQuandoDesempenhoForBom() {
        service.concederReajuste(funcionario, Desempenho.OTIMO);

        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }
}
