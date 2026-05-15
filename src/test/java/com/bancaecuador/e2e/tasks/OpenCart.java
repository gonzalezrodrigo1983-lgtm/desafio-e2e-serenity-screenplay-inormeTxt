package com.bancaecuador.e2e.tasks;

import com.bancaecuador.e2e.ui.SauceDemoPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public final class OpenCart {
    private OpenCart() {}
    public static Performable page() {
        return Task.where("{0} abre el carrito", Click.on(SauceDemoPage.CART_LINK));
    }
}
