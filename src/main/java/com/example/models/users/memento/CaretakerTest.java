package com.example.models.users.memento;

import com.example.models.users.Client;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class CaretakerTest {

    private Caretaker caretaker;
    private Client client;
    private ClientMemento memento;

    @BeforeEach
    void setUp() {
        caretaker = new Caretaker();
        client = mock(Client.class);
        memento = mock(ClientMemento.class);
    }

    @Test
    void testSaveShouldCallClientSaveAndPushToHistory() {
        when(client.save()).thenReturn(memento);

        caretaker.save(client);

        verify(client, times(1)).save();
    }

    @Test
    void testUndoShouldCallClientRestoreWithLastMemento() {
        when(client.save()).thenReturn(memento);
        caretaker.save(client);

        caretaker.undo(client);

        verify(client, times(1)).restore(memento);
    }

    @Test
    void testUndoShouldDoNothingWhenHistoryIsEmpty() {
        caretaker.undo(client);
        verify(client, never()).restore(any());
    }

    @Test
    void testMultipleSaveAndUndo() {
        ClientMemento memento1 = mock(ClientMemento.class);
        ClientMemento memento2 = mock(ClientMemento.class);

        when(client.save()).thenReturn(memento1).thenReturn(memento2);

        caretaker.save(client);
        caretaker.save(client);

        caretaker.undo(client);
        caretaker.undo(client);

        verify(client, times(2)).restore(any());
    }

    @Test
    void testUndoAfterSingleSave() {
        when(client.save()).thenReturn(memento);

        caretaker.save(client);
        caretaker.undo(client);

        verify(client).restore(memento);
    }
}
