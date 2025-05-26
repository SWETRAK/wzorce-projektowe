package com.example.services.discount;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

// Tydzień 12, Testy jednostkowe, Joanna Kozar
// Klasa testowa dla PromotionEngine, która sprawdza różne funkcjonalności silnika promocji
class PromotionEngineTest {

    @Mock
    private PromotionRule rule1;

    @Mock
    private PromotionRule rule2;

    @Mock
    private PromotionRule rule3;

    private ByteArrayOutputStream outputStream;
    private PrintStream originalOut;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        outputStream = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
    }

    //Test sprawdza czy promocja zostanie przyznana gdy pierwsza reguła jest spełniona
    @Test
    void shouldGrantPromotionWhenFirstRuleIsApplicable() {
        String user = "testUser";
        when(rule1.isApplicable(user)).thenReturn(true);

        List<PromotionRule> rules = Arrays.asList(rule1, rule2, rule3);
        PromotionEngine engine = new PromotionEngine(rules);
        engine.evaluatePromotions(user);

        String output = outputStream.toString().trim();
        assertEquals("Promocja przyznana dla: testUser", output);

        System.setOut(originalOut);
    }

    //Test sprawdza czy promocja zostanie przyznana gdy druga reguła jest spełniona a pierwsza nie
    @Test
    void shouldGrantPromotionWhenSecondRuleIsApplicable() {
        String user = "premiumUser";
        when(rule1.isApplicable(user)).thenReturn(false);
        when(rule2.isApplicable(user)).thenReturn(true);

        List<PromotionRule> rules = Arrays.asList(rule1, rule2, rule3);
        PromotionEngine engine = new PromotionEngine(rules);

        engine.evaluatePromotions(user);

        String output = outputStream.toString().trim();
        assertEquals("Promocja przyznana dla: premiumUser", output);

        System.setOut(originalOut);
    }

    //Test sprawdza czy brak promocji zostanie zgłoszony gdy żadna reguła nie jest spełniona
    @Test
    void shouldNotGrantPromotionWhenNoRuleIsApplicable() {
        String user = "basicUser";
        when(rule1.isApplicable(user)).thenReturn(false);
        when(rule2.isApplicable(user)).thenReturn(false);
        when(rule3.isApplicable(user)).thenReturn(false);

        List<PromotionRule> rules = Arrays.asList(rule1, rule2, rule3);
        PromotionEngine engine = new PromotionEngine(rules);

        engine.evaluatePromotions(user);

        String output = outputStream.toString().trim();
        assertEquals("Brak promocji dla: basicUser", output);

        System.setOut(originalOut);
    }

    //Test sprawdza zachowanie gdy lista reguł jest pusta
    @Test
    void shouldNotGrantPromotionWhenRulesListIsEmpty() {
        String user = "anyUser";
        List<PromotionRule> emptyRules = Collections.emptyList();
        PromotionEngine engine = new PromotionEngine(emptyRules);

        engine.evaluatePromotions(user);

        String output = outputStream.toString().trim();
        assertEquals("Brak promocji dla: anyUser", output);

        System.setOut(originalOut);
    }

    //Test sprawdza czy ocena reguł zatrzymuje się po znalezieniu pierwszej spełnionej reguły
    @Test
    void shouldStopEvaluationAfterFirstApplicableRule() {
        String user = "vipUser";
        when(rule1.isApplicable(user)).thenReturn(false);
        when(rule2.isApplicable(user)).thenReturn(true);

        List<PromotionRule> rules = Arrays.asList(rule1, rule2, rule3);
        PromotionEngine engine = new PromotionEngine(rules);

        engine.evaluatePromotions(user);

        String output = outputStream.toString().trim();
        assertEquals("Promocja przyznana dla: vipUser", output);

        System.setOut(originalOut);
    }
}
//Koniec - Tydzień 12, Testy jednostkowe, Joanna Kozar