package ru.netology.manager;

import lombok.Data;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


class MovieManagerTest {

    @Test //новый тест
    void getLastMovieIsLimit() {
        Movie first = new Movie(1, "Leon", 2003);
        Movie second = new Movie(2, "Stalker", 2004);
        Movie third = new Movie(3, "1+1", 2005);
        Movie fourth = new Movie(4, "Invisible", 2006);
        Movie fifth = new Movie(5, "Troll's tour", 2007);
        Movie sixth = new Movie(6, "I BelieveInLove", 2008);
        Movie seventh = new Movie(7, "Pinocchio", 2009);
        Movie eighth = new Movie(8, "House of Cards", 2010);
        Movie ninth = new Movie(9, "The man is unknown", 2011);
        Movie tenth = new Movie(10, "Method", 2012);

        MovieManager man = new MovieManager();
        man.add(first);
        man.add(second);
        man.add(third);
        man.add(fourth);
        man.add(fifth);
        man.add(sixth);
        man.add(seventh);
        man.add(eighth);
        man.add(ninth);
        man.add(tenth);

        Movie[] expected = new Movie[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};
        Movie[] actual = man.findAll();

        System.out.println(Arrays.toString(actual));

        assertArrayEquals(expected, actual);
    }

    @Test //новый тест
    void getLastFilmsUnderLimit() {
        Movie first = new Movie(1, "Leon", 2003);
        Movie second = new Movie(2, "Stalker", 2004);
        Movie third = new Movie(3, "1+1", 2005);
        Movie fourth = new Movie(4, "Invisible", 2006);

        MovieManager man = new MovieManager();
        man.add(first);
        man.add(second);
        man.add(third);
        man.add(fourth);

        Movie[] expected = new Movie[]{first, second, third, fourth};
        Movie[] actual = man.findAll();

        System.out.println(Arrays.toString(actual));

        assertArrayEquals(expected, actual);
    }

    @Test //новый тест
    public void NoArg() {
        MovieManager man = new MovieManager();
        Movie first = new Movie();
        Movie[] actual = man.findLast();
        Movie[] expected = new Movie[] {};

        System.out.println(Arrays.toString(actual));

        assertArrayEquals(expected, actual);
    }

    @Test// добавление фильмов
    public void shouldAddMovie() {
        Movie first = new Movie(1, "Leon", 2003);
        Movie second = new Movie(2, "Stalker", 2004);
        Movie third = new Movie(3, "1+1", 2005);
        Movie fourth = new Movie(4, "Invisible", 2006);
        Movie fifth = new Movie(5, "Troll's tour", 2007);
        Movie sixth = new Movie(6, "I BelieveInLove", 2008);
        Movie seventh = new Movie(7, "Pinocchio", 2009);
        Movie eighth = new Movie(8, "House of Cards", 2010);
        Movie ninth = new Movie(9, "The man is unknown", 2011);
        Movie tenth = new Movie(10, "Method", 2012);
        Movie elevan = new Movie(11, "Method new", 2013);

        MovieManager man = new MovieManager();
        man.add(first);
        man.add(second);
        man.add(third);
        man.add(fourth);
        man.add(fifth);
        man.add(sixth);
        man.add(seventh);
        man.add(eighth);
        man.add(ninth);
        man.add(tenth);
        man.add(elevan);

        Movie[] expected = {first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, elevan};
        Movie[] actual = man.findAll();

        System.out.println(Arrays.toString(actual));

        assertArrayEquals(expected, actual);
    }

    @Test // вывод в обратном порядке
    public void shouldFindLast() {
        MovieManager man = new MovieManager(5);

        for (int i = 1; i <= 10; i++) {
            man.add(new Movie(i, "Leon" + i, 2003 - 1));
        }
        Movie[] actual = man.findLast();

        System.out.println(Arrays.toString(actual));

        assertEquals(5, actual.length);
    }

    @Test // вывод в обратном порядке
    public void shouldFindLast2() {
        MovieManager man = new MovieManager();

        for (int i = 1; i <= 10; i++) {
            man.add(new Movie(i, "Leon" + i, 2003 - 1));
        }
        Movie[] actual = man.findLast();

        System.out.println(Arrays.toString(actual));

        assertEquals(10, actual.length);
    }

    @Test // вывод в обратном порядке
    public void shouldFindLast3() {
        MovieManager man = new MovieManager(11);

        for (int i = 1; i <= 10; i++) {
            man.add(new Movie(i, "Leon" + i, 2003 - 1));
        }
        Movie[] actual = man.findLast();

        System.out.println(Arrays.toString(actual));

        assertEquals(10, actual.length);
    }

    @Test // вывод в обратном порядке
    public void shouldFindLast4() {
        MovieManager man = new MovieManager(0);

        for (int i = 1; i <= 10; i++) {
            man.add(new Movie(i, "Leon" + i, 2003 - 1));
        }
        Movie[] actual = man.findLast();

        System.out.println(Arrays.toString(actual));

        assertEquals(0, actual.length);
    }
}