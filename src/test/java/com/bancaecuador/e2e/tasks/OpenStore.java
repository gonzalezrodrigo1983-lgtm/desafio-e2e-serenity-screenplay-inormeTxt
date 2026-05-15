package com.bancaecuador.e2e.tasks;

import com.bancaecuador.e2e.ui.SauceDemoPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public final class OpenStore {
    private OpenStore() {}
    public static Performable sauceDemo() {
        return Task.where("{0} abre la tienda pública SauceDemo", Open.browserOn().the(SauceDemoPage.class));
    }
}
