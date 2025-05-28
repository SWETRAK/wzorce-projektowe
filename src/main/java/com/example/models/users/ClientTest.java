package com.example.models.users;

import com.example.models.users.memento.ClientMemento;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    @Test
    void testBuilder_CreatesClientWithAllData() {
        Client client = new Client.Builder("Jan", "Kowalski", "jan@example.com")
                .paymentMethod("Credit Card")
                .phoneNumber("123456789")
                .address("ul. Przykładowa 1")
                .build();

        assertEquals("Jan", client.getFirstName());
        assertEquals("Kowalski", client.getLastName());
        assertEquals("jan@example.com", client.getEmail());
        assertEquals("Credit Card", client.getPaymentMethod());
        assertEquals("123456789", client.getPhoneNumber());
        assertEquals("ul. Przykładowa 1", client.getAddress());
    }

    @Test
    void testSaveAndRestoreEmailUsingMemento() {
        Client client = new Client.Builder("Anna", "Nowak", "anna@example.com").build();
        ClientMemento memento = client.save();

        client.setEmail("changed@example.com");
        client.restore(memento);

        assertEquals("anna@example.com", client.getEmail());
    }

    @Test
    void testUpdate_DoesNotThrowException() {
        Client client = new Client.Builder("Piotr", "Zieliński", "piotr@example.com").build();
        assertDoesNotThrow(() -> client.update("Wielka promocja!"));
    }

    @Test
    void testSetters_ChangeFirstAndLastName() {
        Client client = new Client.Builder("Ewa", "Malinowska", "ewa@example.com").build();
        client.setFirstName("Eva");
        client.setLastName("Nowicka");

        assertEquals("Eva", client.getFirstName());
        assertEquals("Nowicka", client.getLastName());
    }

    @Test
    void testPrintInfo_DoesNotThrow() {
        Client client = new Client.Builder("Adam", "Wójcik", "adam@example.com").build();
        assertDoesNotThrow(client::printInfo);
    }
}
