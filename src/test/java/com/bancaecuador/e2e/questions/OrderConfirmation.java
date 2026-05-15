package com.bancaecuador.e2e.questions;

import com.bancaecuador.e2e.ui.SauceDemoPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public final class OrderConfirmation {
    private OrderConfirmation() {}
    public static Question<String> message() {
        return actor -> Text.of(SauceDemoPage.COMPLETE_HEADER).answeredBy(actor).trim();
    }
}
