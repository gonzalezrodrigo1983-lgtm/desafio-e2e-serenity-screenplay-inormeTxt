package com.bancaecuador.e2e.tasks;

import com.bancaecuador.e2e.models.PurchaseProfile;
import com.bancaecuador.e2e.ui.SauceDemoPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public final class LoginToStore {
    private LoginToStore() {}
    public static Performable with(PurchaseProfile profile) {
        return Task.where("{0} inicia sesión con credenciales parametrizadas",
            Enter.theValue(profile.getUsername()).into(SauceDemoPage.USERNAME),
            Enter.theValue(profile.getPassword()).into(SauceDemoPage.PASSWORD),
            Click.on(SauceDemoPage.LOGIN_BUTTON)
        );
    }
}
