package com.bancaecuador.e2e.tasks;

import com.bancaecuador.e2e.ui.SauceDemoPage;
import java.util.List;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public final class AddProducts {
    private AddProducts() {}
    public static Performable toCart(List<String> products) {
        return Task.where("{0} agrega productos parametrizados al carrito",
            actor -> products.forEach(product -> actor.attemptsTo(Click.on(SauceDemoPage.addToCartButtonFor(product))))
        );
    }
}
