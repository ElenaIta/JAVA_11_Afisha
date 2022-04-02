package ru.netology.manager;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.Movie;

@Data

public class MovieManager {
    private Movie[] items = new Movie[0];
    private int lastCount = 10;

    public MovieManager(int lastCount) {
        this.lastCount = lastCount;
    }

    public MovieManager() {
    }

    // добавление фильмов
    public void add(Movie item) {
        Movie[] tmp = new Movie[items.length + 1];
        System.arraycopy(items, 0, tmp, 0, items.length);
        tmp[tmp.length - 1] = item;
        this.items = tmp;
    }

    // вывод всех фильмов
    public Movie[] findAll() {
        return this.items;
    }

    // вывод в обратном порядке
    public Movie[] findLast() {
        int resultLength = Math.min(items.length, lastCount);
        //        if (items.length < lastCount) {
//            resultLength = items.length;
//        } else {
//            resultLength = lastCount;
//        }
        Movie[] result = new Movie[resultLength];


        for (int i = 0; i < result.length; i++) {
            result[i] = items[items.length - 1 - i];
        }
        return result;
    }
}



