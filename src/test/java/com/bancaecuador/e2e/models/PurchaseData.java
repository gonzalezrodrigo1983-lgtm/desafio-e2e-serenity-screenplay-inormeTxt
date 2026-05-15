package com.bancaecuador.e2e.models;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public final class PurchaseData {
    private static final String DATA_FILE = "/data/purchase-data.json";
    private static final Map<String, PurchaseProfile> PROFILES = loadProfiles();

    private PurchaseData() {}

    public static PurchaseProfile profile(String profileName) {
        PurchaseProfile profile = PROFILES.get(profileName);
        if (profile == null) {
            throw new IllegalArgumentException("No existe el perfil de compra: " + profileName);
        }
        return profile;
    }

    private static Map<String, PurchaseProfile> loadProfiles() {
        try (InputStream stream = PurchaseData.class.getResourceAsStream(DATA_FILE)) {
            if (stream == null) {
                throw new IllegalStateException("No se encontró el archivo de datos: " + DATA_FILE);
            }
            return new ObjectMapper().readValue(stream, new TypeReference<Map<String, PurchaseProfile>>() {});
        } catch (IOException e) {
            throw new IllegalStateException("No fue posible cargar los datos de compra", e);
        }
    }
}
