package com.bancaecuador.e2e.stepdefinitions;

import com.bancaecuador.e2e.models.PurchaseData;
import com.bancaecuador.e2e.models.PurchaseProfile;
import com.bancaecuador.e2e.questions.CartCounter;
import com.bancaecuador.e2e.questions.OrderConfirmation;
import com.bancaecuador.e2e.tasks.AddProducts;
import com.bancaecuador.e2e.tasks.Checkout;
import com.bancaecuador.e2e.tasks.LoginToStore;
import com.bancaecuador.e2e.tasks.OpenCart;
import com.bancaecuador.e2e.tasks.OpenStore;
import com.bancaecuador.e2e.ui.SauceDemoPage;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;

public class PurchaseStepDefinitions {
    private PurchaseProfile profile;

    @Before
    public void prepareStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("que {actor} ingresa a la tienda pública SauceDemo")
    public void ingresaTienda(Actor actor) {
        actor.attemptsTo(OpenStore.sauceDemo());
    }

    @Cuando("inicia sesión con el perfil de compra {string}")
    public void iniciaSesionConPerfil(String profileName) {
        profile = PurchaseData.profile(profileName);
        OnStage.theActorInTheSpotlight().attemptsTo(LoginToStore.with(profile));
    }

    @Y("agrega los productos parametrizados al carrito")
    public void agregaProductos() {
        OnStage.theActorInTheSpotlight().attemptsTo(AddProducts.toCart(profile.getProducts()));
    }

    @Entonces("debe visualizar el carrito con los productos seleccionados")
    public void validaCarrito() {
        OnStage.theActorInTheSpotlight().attemptsTo(
            Ensure.that(CartCounter.value()).isEqualTo(profile.getProducts().size()),
            OpenCart.page()
        );
        profile.getProducts().forEach(product ->
            OnStage.theActorInTheSpotlight().attemptsTo(Ensure.that(SauceDemoPage.productInCart(product)).isDisplayed())
        );
    }

    @Cuando("completa el checkout con los datos parametrizados")
    public void completaCheckout() {
        OnStage.theActorInTheSpotlight().attemptsTo(Checkout.withCustomerData(profile));
    }

    @Y("confirma la orden de compra")
    public void confirmaOrden() {
        OnStage.theActorInTheSpotlight().attemptsTo(
            Ensure.that(Text.of(SauceDemoPage.SUMMARY_TOTAL)).contains("Total"),
            Checkout.finishOrder()
        );
    }

    @Entonces("debe visualizar la confirmación exitosa de la compra")
    public void validaCompraExitosa() {
        OnStage.theActorInTheSpotlight().attemptsTo(
            Ensure.that(OrderConfirmation.message()).isEqualTo(profile.getExpectedConfirmation())
        );
    }

    @Entonces("debe visualizar el error de autenticación esperado")
    public void validaErrorLogin() {
        OnStage.theActorInTheSpotlight().attemptsTo(
            Ensure.that(Text.of(SauceDemoPage.LOGIN_ERROR)).contains(profile.getExpectedError())
        );
    }
}
