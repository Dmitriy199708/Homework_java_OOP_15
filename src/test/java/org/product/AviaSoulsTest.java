package org.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AviaSoulsTest {
    Ticket ticket = new Ticket(
            "Нижний новгород",
            "Москва",
            18_000,
            18,
            22);
    Ticket ticket1 = new Ticket(
            "Магадан",
            "Кировск",
            1_000_000,
            11,
            14);
    Ticket ticket2 = new Ticket(
            "Великий Новгород",
            "Стамбул",
            5_000_000,
            13,
            21);
    Ticket ticket3 = new Ticket(
            "Нижний новгород",
            "Москва",
            17_000,
            13,
            21);
    Ticket ticket4 = new Ticket(
            "Санкт-Петербург",
            "Москва",
            3_000_000,
            13,
            21);

    @Test
    public void testCorpareteTo() {
        AviaSouls aviaSouls = new AviaSouls();

        aviaSouls.add(ticket);
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);

//        System.out.println(ticket.compareTo(ticket1));
//        System.out.println(ticket2.compareTo(ticket));
//        System.out.println(ticket.compareTo(ticket2));
        Ticket[] tickets = {ticket, ticket1, ticket2, ticket3, ticket4};

        int expected = -1;
        int actual = ticket.compareTo(ticket4);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void searchForTicketsByDeparturePoint() {
        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(ticket);
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);

        Ticket[] ecpected = {ticket3, ticket};
        Ticket[] actual = (aviaSouls.search("Нижний новгород", "Москва"));

        Assertions.assertArrayEquals(ecpected, actual);


    }

    @Test
    public void searchForTicketsAtNonExistentDeparturePoints() {
        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(ticket);
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);

        Ticket[] ecpected = {};
        Ticket[] actual = (aviaSouls.search("Магадан", "Киров"));

        Assertions.assertArrayEquals(ecpected, actual);
    }

    @Test

    public void searchingForShorterFlightTimes() {
        AviaSouls aviaSouls = new AviaSouls();

        aviaSouls.add(ticket);
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);

        TicketTimeComparator timeComparator = new TicketTimeComparator();
        Ticket[] tickets = {ticket, ticket1, ticket2, ticket3, ticket4};

        Ticket[] expected = {ticket, ticket3};
        Ticket[] actual = aviaSouls.searchAndSortBy("Нижний новгород", "Москва", timeComparator);
        Assertions.assertArrayEquals(expected, actual);
    }
}