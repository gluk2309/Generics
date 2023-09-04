package ru.netology.AviaSouls;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {
    AviaSouls manager = new AviaSouls();
    Ticket ticket1 = new Ticket("Санкт-Петербург", "Воронеж", 80_000, 1, 2);
    Ticket ticket2 = new Ticket("Воронеж", "Москва", 25_000, 3, 9);
    Ticket ticket3 = new Ticket("Архангельск", "Москва", 49_000, 21, 24);
    Ticket ticket4 = new Ticket("Саратов", "Воронеж", 21_000, 7, 9);
    Ticket ticket5 = new Ticket("Воронеж", "Саратов", 23_000, 20, 22);
    Ticket ticket6 = new Ticket("Воронеж", "Архангельск", 39_000, 15, 22);
    Ticket ticket7 = new Ticket("Архангельск", "Саратов", 29_000, 11, 23);
    Ticket ticket8 = new Ticket("Архангельск", "Москва", 45_000, 3, 5);
    Ticket ticket9 = new Ticket("Санкт-Петербург", "Воронеж", 15_000, 3, 12);
    Ticket ticket10 = new Ticket("Воронеж", "Москва", 30_000, 19, 23);


    @Test
    public void testMultipleResultsAndSorting() {

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Ticket[] actual = manager.search("Архангельск", "Москва");
        Ticket[] expected = {ticket8, ticket3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testNoResults() {

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Ticket[] actual = manager.search("Архангельск", "Санкт-Петербург");
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testOneResult() {

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Ticket[] actual = manager.search("Саратов", "Воронеж");
        Ticket[] expected = {ticket4};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testNoTickets() {

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.searchAndSortBy("Архангельск", "Санкт-Петербург", comparator);
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testMultipleTicketsAndSorting() {

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.searchAndSortBy("Воронеж", "Москва", comparator);
        Ticket[] expected = {ticket10, ticket2};

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testOneTicket() {

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.searchAndSortBy("Воронеж", "Саратов", comparator);
        Ticket[] expected = {ticket5};

        Assertions.assertArrayEquals(expected, actual);
    }


}

