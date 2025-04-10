package com.example.models.bookhistory;

//Tydzień 6, wzorzec Memento, Joanna Kozar
//Implementacja klasy do historii edycji książki przez administratora
public class EditableBook {
    private String title;
    private String description;

    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }

    public BookMemento save() {
        return new BookMemento(title, description);
    }

    public void restore(BookMemento memento) {
        this.title = memento.getTitle();
        this.description = memento.getDescription();
    }

    public void print() {
        System.out.println("Tytuł: " + title + ", Opis: " + description);
    }
}
//Tydzień 6, wzorzec Memento, Joanna Kozar
