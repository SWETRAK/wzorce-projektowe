package com.example.services.delivery;

import com.example.services.delivery.mediator.Mediator;
import com.example.services.external.DHLDeliveryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.*;

// Tydzień 12, Testy jednostkowe, Kamil Pietrak
// Klasa testowa dla DHLServiceAdapter
class DHLServiceAdapterTest {

    private DHLDeliveryService deliveryServiceMock;
    private Mediator mediatorMock;
    private DHLServiceAdapter adapter;

    @BeforeEach
    void setUp() {
        deliveryServiceMock = mock(DHLDeliveryService.class);
        mediatorMock = mock(Mediator.class);
        adapter = new DHLServiceAdapter(mediatorMock, deliveryServiceMock);
    }

    @Test
    void testDeliverOrder_DelegatesToDHLService() {
        String orderId = "ORD123";
        adapter.deliverOrder(orderId);
        verify(deliveryServiceMock, times(1)).deliverOrder(orderId);
    }

    @Test
    void testGetOrderStatus_DelegatesToDHLService() {
        String orderId = "ORD456";
        adapter.getOrderStatus(orderId);
        verify(deliveryServiceMock, times(1)).getOrderStatus(orderId);
    }

    @Test
    void testReceiveMessage_PrintsMessage() {
        assertDoesNotThrow(() -> adapter.receiveMessage("UserX", "Test message"));
    }

    @Test
    void testPreparePackage_PrintsCorrectMessage() {
        assertDoesNotThrow(() -> adapter.preparePackage("PKG123"));
    }

    @Test
    void testSend_PrintsCorrectMessage() {
        assertDoesNotThrow(() -> adapter.send("PKG999"));
    }
}
// Koniec, Tydzień 12, Testy jednostkowe, Kamil Pietrak