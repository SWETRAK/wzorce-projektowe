package com.example.services.recommendation;

//Tydzień 5, Wzorzec Interpreter, Joanna Kozar
//Implementacja łączenia (dla rekomendacji)
public class AndExpression implements Expression {
    private final Expression expr1;
    private final Expression expr2;

    public AndExpression(Expression expr1, Expression expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    @Override
    public boolean interpret(BookRecommendationContext context) {
        return expr1.interpret(context) && expr2.interpret(context);
    }
}
//Koniec - Tydzień 5, Wzorzec Interpreter, Joanna Kozar