package com.bancaecuador.e2e.tasks;

import com.bancaecuador.e2e.models.PurchaseProfile;
import com.bancaecuador.e2e.ui.SauceDemoPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public final class Checkout {
    private Checkout() {}
    public static Performable withCustomerData(PurchaseProfile profile) {
        return Task.where("{0} completa el formulario de checkout",
            Click.on(SauceDemoPage.CHECKOUT_BUTTON),
            Enter.theValue(profile.getFirstName()).into(SauceDemoPage.FIRST_NAME),
            Enter.theValue(profile.getLastName()).into(SauceDemoPage.LAST_NAME),
            Enter.theValue(profile.getPostalCode()).into(SauceDemoPage.POSTAL_CODE),
            Click.on(SauceDemoPage.CONTINUE_BUTTON)
        );
    }

    public static Performable finishOrder() {
        return Task.where("{0} finaliza la compra", Click.on(SauceDemoPage.FINISH_BUTTON));
    }
}
