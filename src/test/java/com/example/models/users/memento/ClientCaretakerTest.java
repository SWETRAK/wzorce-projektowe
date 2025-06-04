package com.example.models.users.memento;

import com.example.models.users.Client;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

// Tydzień 12, Testy jednostkowe, Kamil Pietrak
// Klasa testowa dla Caretaker
class ClientCaretakerTest {

    private ClientCaretaker clientCaretaker;
    private Client client;
    private ClientMemento memento;

    @BeforeEach
    void setUp() {
        clientCaretaker = new ClientCaretaker();
        client = mock(Client.class);
        memento = mock(ClientMemento.class);
    }

    @Test
    void testSaveShouldCallClientSaveAndPushToHistory() {
        when(client.save()).thenReturn(memento);

        clientCaretaker.save(client);

        verify(client, times(1)).save();
    }

    @Test
    void testUndoShouldCallClientRestoreWithLastMemento() {
        when(client.save()).thenReturn(memento);
        clientCaretaker.save(client);

        clientCaretaker.undo(client);

        verify(client, times(1)).restore(memento);
    }

    @Test
    void testUndoShouldDoNothingWhenHistoryIsEmpty() {
        clientCaretaker.undo(client);
        verify(client, never()).restore(any());
    }

    @Test
    void testMultipleSaveAndUndo() {
        ClientMemento memento1 = mock(ClientMemento.class);
        ClientMemento memento2 = mock(ClientMemento.class);

        when(client.save()).thenReturn(memento1).thenReturn(memento2);

        clientCaretaker.save(client);
        clientCaretaker.save(client);

        clientCaretaker.undo(client);
        clientCaretaker.undo(client);

        verify(client, times(2)).restore(any());
    }

    @Test
    void testUndoAfterSingleSave() {
        when(client.save()).thenReturn(memento);

        clientCaretaker.save(client);
        clientCaretaker.undo(client);

        verify(client).restore(memento);
    }
}
// Koniec, Tydzień 12, Testy jednostkowe, Kamil Pietrak