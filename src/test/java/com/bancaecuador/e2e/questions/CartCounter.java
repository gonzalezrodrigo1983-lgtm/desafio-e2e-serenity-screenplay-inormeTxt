package com.bancaecuador.e2e.questions;

import com.bancaecuador.e2e.ui.SauceDemoPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public final class CartCounter {
    private CartCounter() {}
    public static Question<Integer> value() {
        return actor -> Integer.parseInt(Text.of(SauceDemoPage.CART_BADGE).answeredBy(actor).trim());
    }
}
