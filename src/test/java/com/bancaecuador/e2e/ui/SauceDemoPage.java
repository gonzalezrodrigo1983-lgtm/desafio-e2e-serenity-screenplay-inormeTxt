package com.bancaecuador.e2e.ui;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

@DefaultUrl("https://www.saucedemo.com/")
public class SauceDemoPage extends PageObject {
    public static final Target USERNAME = Target.the("campo usuario").locatedBy("#user-name");
    public static final Target PASSWORD = Target.the("campo contraseña").locatedBy("#password");
    public static final Target LOGIN_BUTTON = Target.the("botón login").locatedBy("#login-button");
    public static final Target LOGIN_ERROR = Target.the("mensaje de error de login").locatedBy("[data-test='error']");
    public static final Target INVENTORY_TITLE = Target.the("título del inventario").locatedBy(".title");
    public static final Target CART_BADGE = Target.the("contador del carrito").locatedBy(".shopping_cart_badge");
    public static final Target CART_LINK = Target.the("ícono carrito").locatedBy(".shopping_cart_link");
    public static final Target CHECKOUT_BUTTON = Target.the("botón checkout").locatedBy("#checkout");
    public static final Target FIRST_NAME = Target.the("nombre comprador").locatedBy("#first-name");
    public static final Target LAST_NAME = Target.the("apellido comprador").locatedBy("#last-name");
    public static final Target POSTAL_CODE = Target.the("código postal comprador").locatedBy("#postal-code");
    public static final Target CONTINUE_BUTTON = Target.the("botón continuar checkout").locatedBy("#continue");
    public static final Target FINISH_BUTTON = Target.the("botón finalizar compra").locatedBy("#finish");
    public static final Target COMPLETE_HEADER = Target.the("mensaje de compra completada").locatedBy(".complete-header");
    public static final Target SUMMARY_TOTAL = Target.the("total de compra").locatedBy(".summary_total_label");

    public static Target addToCartButtonFor(String productName) {
        return Target.the("botón agregar al carrito para " + productName)
            .locatedBy("//div[contains(@class,'inventory_item') and .//div[@class='inventory_item_name' and normalize-space()='" + productName + "']]//button");
    }

    public static Target productInCart(String productName) {
        return Target.the("producto en carrito " + productName)
            .locatedBy("//div[@class='cart_item']//div[@class='inventory_item_name' and normalize-space()='" + productName + "']");
    }
}
